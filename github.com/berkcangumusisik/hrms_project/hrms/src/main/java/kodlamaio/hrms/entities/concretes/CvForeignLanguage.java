package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="cv_foreign_languages")
public class CvForeignLanguage {
	
	@Id
	@Column(name="foreign_languages_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvforeignLanguageId;
	
	@Column(name="foreign_languages_name")
	private String ForeignLanguageName;
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="language_level_id")
	private LanguageLevel languageLevel;
	

}