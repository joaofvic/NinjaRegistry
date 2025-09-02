package dev.joaofvic.NinjaRegistry.Ninjas;

import dev.joaofvic.NinjaRegistry.Missions.MissionsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_register")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

    @Column(unique = true)
	private String email;

	private int age;

	@ManyToOne
	@JoinColumn(name = "missions_id")
	private MissionsModel missions;
	
	
}
