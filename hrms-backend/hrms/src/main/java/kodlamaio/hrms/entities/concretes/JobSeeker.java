package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvs"})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")

public class JobSeeker extends User {

	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identification_number")
	private String NationalityId;
	
	@Column(name = "birth_year")
	private int birthYear;
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvEducation> cvEducation;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvLanguage> cvLanguage;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvSkill> cvSkill;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvExperience> cvExperience;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<CvPrewriting> cvPrewriting;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Link> link;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Photograph> photograph;

	

	
}