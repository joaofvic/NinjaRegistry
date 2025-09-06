package dev.joaofvic.NinjaRegistry.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "This is my first message on this route";
	}

    // Add ninja
    @PostMapping("./register")
    public String register() {
        return "Ninja created";
    }

    // Show ninjas
    @GetMapping("./all")
    public String all() {
        return "Ninja showed";
    }

    // Show ninjas by Id
    @GetMapping("./allId")
    public String allId() {
        return "Ninja showed by Id";
    }

    // Change ninja data
    @PutMapping("./changeId")
    public String changeId() {
        return "Changed ninja by Id";
    }

    // Delete ninja
    @DeleteMapping("./deleteId")
    public String deleteId() {
        return "Deleted ninja by Id";
    }
}
