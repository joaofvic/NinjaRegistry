package dev.joaofvic.NinjaRegistry.Missions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.joaofvic.NinjaRegistry.Ninjas.NinjaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissionsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String difficulty;

	@OneToMany(mappedBy = "missions")
    @JsonIgnore
	private List<NinjaModel> ninjas;
	
	
}
