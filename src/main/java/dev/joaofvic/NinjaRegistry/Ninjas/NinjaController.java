package dev.joaofvic.NinjaRegistry.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;
    private NinjaMapper ninjaMapper;

    public NinjaController(NinjaService ninjaService, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
        this.ninjaMapper = ninjaMapper;
    }

    @GetMapping("/welcome")
	public String welcome() {
		return "This is my first message on this route";
	}

    // Add ninja
    @PostMapping("/register")
    public NinjaDTO register(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.register(ninjaDTO);
    }

    // Show ninjas
    @GetMapping("/all")
    public List<NinjaDTO> all() {
        return ninjaService.listNinjas();
    }

    // Show ninjas by Id
    @GetMapping("/all/{id}")
    public NinjaDTO allId(@PathVariable Long id) {
        return ninjaService.listNinjasId(id);
    }

    // Change ninja data
    @PutMapping("/changeId/{id}")
    public NinjaDTO changeId(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdated) {
        return ninjaService.changeId(id, ninjaUpdated);
    }

    // Delete ninja
    @DeleteMapping("/deleteId/{id}")
    public void deleteId(@PathVariable Long id) {
        ninjaService.deleteId(id);
    }

}
