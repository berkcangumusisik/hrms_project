package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvForeignLanguage"})
public class Cv {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvId;

	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name ="creation_date")
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvLanguage> cvLanguage;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvSkill> cvSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvEducation>  cvEducation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience>  workExperience;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Photo> photo;

}