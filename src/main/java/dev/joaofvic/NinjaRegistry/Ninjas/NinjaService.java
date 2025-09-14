package dev.joaofvic.NinjaRegistry.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listNinjasId(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel register(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }
    public void deleteId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel changeId(Long id, NinjaModel ninjaUpdated) {
        if (ninjaRepository.existsById(id)) {
            ninjaUpdated.setId(id);
            return ninjaRepository.save(ninjaUpdated);
        }
        return null;
    }
}
