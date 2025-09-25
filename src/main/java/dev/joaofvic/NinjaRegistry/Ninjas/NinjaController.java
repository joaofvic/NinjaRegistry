package dev.joaofvic.NinjaRegistry.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> register(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninjaNew = ninjaService.register(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja created successfully: " + ninjaNew.getName());
    }

    // Show ninjas
    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> all() {
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Show ninjas by Id
    @GetMapping("/all/{id}")
    public ResponseEntity<?> allId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listNinjasId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja from id " + id + " not found.");
        }
    }

    // Change ninja data
    @PutMapping("/change/{id}")
    public ResponseEntity<String> changeId(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdated) {
        if (ninjaService.listNinjasId(id) != null) {
            ninjaService.changeId(id, ninjaUpdated);
            return ResponseEntity.ok().body("Ninja changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja from id " + id + " not found");
        }
    }

    // Delete ninja
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<String> deleteId(@PathVariable Long id) {

        if (ninjaService.listNinjasId(id) != null) {
            ninjaService.deleteId(id);
            return ResponseEntity.ok("Ninja from id " + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja from id " + id + " not found");
        }
    }

}
