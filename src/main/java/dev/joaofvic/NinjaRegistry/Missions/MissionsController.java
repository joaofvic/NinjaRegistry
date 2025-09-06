package dev.joaofvic.NinjaRegistry.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")
public class MissionsController {

    @GetMapping("/all")
    public String allMisions() {
        return "All missions here";
    }

    @PostMapping("/create")
    public String createMission() {
        return "Mission created";
    }

    @PutMapping("/change")
    public String changeMission() {
        return "Mission change successful";
    }

    @DeleteMapping("/delete")
    public String deleteMission() {
        return "Mission deleted";
    }

}
