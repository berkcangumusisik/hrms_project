package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})

public class City {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_name")
	private String CityName;
	
	@OneToMany(mappedBy="city")
	private List<JobAdvertisement> jobAdvertisement;
}
