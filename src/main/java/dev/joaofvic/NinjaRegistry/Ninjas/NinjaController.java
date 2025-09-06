package dev.joaofvic.NinjaRegistry.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/allId")
    public String allId() {
        return "Ninja showed by Id";
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
