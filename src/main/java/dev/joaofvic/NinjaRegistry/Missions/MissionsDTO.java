package dev.joaofvic.NinjaRegistry.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.joaofvic.NinjaRegistry.Ninjas.NinjaModel;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionsDTO {

    private Long id;
    private String name;
    private String difficulty;
    private List<NinjaModel> ninjas;
}
