package dev.joaofvic.NinjaRegistry.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
	public String welcome() {
		return "This is my first message on this route";
	}

    // Add ninja
    @PostMapping("/register")
    public String register() {
        return "Ninja created";
    }

    // Show ninjas
    @GetMapping("/all")
    public List<NinjaModel> all() {
        return ninjaService.listNinjas();
    }

    // Show ninjas by Id
    @GetMapping("/all/{id}")
    public NinjaModel allId(@PathVariable Long id) {
        return ninjaService.listNinjasId(id);
    }

    // Change ninja data
    @PutMapping("/changeId")
    public String changeId() {
        return "Changed ninja by Id";
    }

    // Delete ninja
    @DeleteMapping("/deleteId")
    public String deleteId() {
        return "Deleted ninja by Id";
    }

}
