package dev.joaofvic.NinjaRegistry.Missions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missions")
public class MissionsController {

    private final MissionsService missionsService;
    private MissionsMapper missionsMapper;

    public MissionsController(MissionsService missionsService, MissionsMapper missionsMapper) {
        this.missionsService = missionsService;
        this.missionsMapper = missionsMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionsDTO>> all() {
        List<MissionsDTO> missions = missionsService.listMissions();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> allId(@PathVariable Long id) {
        MissionsDTO mission = missionsService.listMissionsId(id);

        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission from id " + id + " not found");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MissionsDTO missionsDTO) {
        MissionsDTO missionNew = missionsService.register(missionsDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission created sucessfully: " + missionNew.getName());

    }

    @PutMapping("/change/{id}")
    public ResponseEntity<String> changeId(@PathVariable Long id, @RequestBody MissionsDTO missionsUpdated) {
        if (missionsService.listMissionsId(id) != null) {
            missionsService.changeId(id, missionsUpdated);
            return ResponseEntity.ok()
                    .body("Mission changed sucessfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission from id " + id + " not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteId(@PathVariable Long id) {
        if (missionsService.listMissionsId(id) != null) {
            missionsService.deleteId(id);
            return ResponseEntity.ok()
                    .body("Mission from id " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission from id " + id + " not found.");
        }
    }

}
