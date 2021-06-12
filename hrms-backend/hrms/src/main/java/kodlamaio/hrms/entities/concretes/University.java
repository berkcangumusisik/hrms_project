package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "universities")
@AllArgsConstructor
@NoArgsConstructor
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "university_id")
	private int universityId;

	@Column(name = "university_name")
	private String universityName;

	@Column(name = "status")
	private int status;
	
	@OneToOne(mappedBy = "university")
	@JsonIgnore()
	private transient CvEducation cvEducation;

	@OneToMany(mappedBy = "university")
	@JsonIgnore()
	private List<Faculty> Faculty;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
}