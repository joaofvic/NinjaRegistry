package dev.joaofvic.NinjaRegistry.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionsMapper {

    // Mapping from DTO to the entity (model)
    public MissionsModel map(MissionsDTO missionsDTO){

        MissionsModel missionsModel = new MissionsModel();
        missionsModel.setId(missionsDTO.getId());
        missionsModel.setName(missionsDTO.getName());
        missionsModel.setDifficulty(missionsDTO.getDifficulty());
        missionsModel.setNinjas(missionsDTO.getNinjas());

        return missionsModel;
    }

    // Mapping from the entity (model) to the DTO
    public MissionsDTO map(MissionsModel missionsModel) {

        MissionsDTO missionsDTO = new MissionsDTO();
        missionsDTO.setId(missionsModel.getId());
        missionsDTO.setName(missionsModel.getName());
        missionsDTO.setDifficulty(missionsModel.getDifficulty());
        missionsDTO.setNinjas(missionsModel.getNinjas());

        return missionsDTO;
    }

}
