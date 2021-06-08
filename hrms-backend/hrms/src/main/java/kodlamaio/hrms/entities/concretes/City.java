package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")

public class City {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_name")
	private String CityName;
	
	@OneToMany(mappedBy="city")
	@JsonIgnore()
	private List<JobAdvertisement> jobAdvertisement;
	
	@OneToMany(mappedBy = "city")
	@JsonIgnore()
	private List<University> university;
}
