package dev.joaofvic.NinjaRegistry.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionsService {

    private final MissionsRepository missionsRepository;
    private final MissionsMapper missionsMapper;

    public MissionsService(MissionsRepository missionsRepository, MissionsMapper missionsMapper) {
        this.missionsRepository = missionsRepository;
        this.missionsMapper = missionsMapper;
    }

    public List<MissionsDTO> listMissions() {
        List<MissionsModel> missions = missionsRepository.findAll();
        return missions.stream()
                .map(missionsMapper::map)
                .collect(Collectors.toList());

    }

    public MissionsDTO listMissionsId(Long id) {
        Optional<MissionsModel> missionModel = missionsRepository.findById(id);
        return missionModel.map(missionsMapper::map).orElse(null);
    }

    public MissionsDTO register(MissionsDTO missionsDTO) {
        MissionsModel mission = missionsMapper.map(missionsDTO);
        mission = missionsRepository.save(mission);
        return missionsMapper.map(mission);
    }

    public void deleteId(Long id) {
        missionsRepository.deleteById(id);
    }

    public MissionsDTO changeId(Long id, MissionsDTO missionsDTO) {
        Optional<MissionsModel> missionExistings = missionsRepository.findById(id);

        if (missionExistings.isPresent()) {
            MissionsModel missionUpdated = missionsMapper.map(missionsDTO);
            missionUpdated.setId(id);
            MissionsModel missionSaved = missionsRepository.save(missionUpdated);
            return missionsMapper.map(missionSaved);
        }

        return null;
    }

}
