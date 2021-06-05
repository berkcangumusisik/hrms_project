package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="language_levels")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvForeignLanguages"})
public class LanguageLevel {
	
	@Id
	@Column(name="language_level_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageLevelId;
	
	@Min(1)
	@Max(5)
	@Column(name="language_level")
	private int languageLevel;
		
	@OneToMany(mappedBy = "languageLevel")
	private List<CvForeignLanguage> cvForeignLanguages;

}