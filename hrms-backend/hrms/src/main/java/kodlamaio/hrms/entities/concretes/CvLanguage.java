package kodlamaio.hrms.entities.concretes;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cv_languages")
public class CvLanguage {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvLanguageId;
	
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
    private Cv cv;
	
	
	@ManyToOne
	@JoinColumn(name="language_level_id")
	private LanguageLevel languageLevel;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="foreign_language_id")
	private ForeignLanguage foreignLanguage;
}
