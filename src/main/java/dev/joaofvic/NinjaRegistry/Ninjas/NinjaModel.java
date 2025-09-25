package dev.joaofvic.NinjaRegistry.Ninjas;

import dev.joaofvic.NinjaRegistry.Missions.MissionsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "tb_register")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missions")
public class NinjaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;

    @Column(name = "name")
	private String name;

    @Column(unique = true)
	private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "age")
	private int age;

    @Column(name = "rank")
    private String rank;

	@ManyToOne
	@JoinColumn(name = "missions_id") // Foreing Key
	private MissionsModel missions;
	
	
}
