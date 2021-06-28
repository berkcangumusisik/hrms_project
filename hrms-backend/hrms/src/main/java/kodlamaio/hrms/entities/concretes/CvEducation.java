package kodlamaio.hrms.entities.concretes;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_educations")
@AllArgsConstructor
@NoArgsConstructor
public class CvEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int cvEducationId;

	@NotBlank(message = "Bu alanın doldurulması zorunludur.")
	@Column(name = "school_type")
	private String schoolType;

	@NotBlank(message = "Bu alanın doldurulması zorunludur.")
	@PastOrPresent
	@Column(name = "edu_beginning_date")
	private LocalDate schoolBeginningDate;

	@PastOrPresent
	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	@OneToOne()
	@JoinColumn(name = "university_id")
	private transient University university;

	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
}
