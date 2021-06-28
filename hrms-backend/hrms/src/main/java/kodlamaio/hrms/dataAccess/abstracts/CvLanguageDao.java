package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.dtos.CvLanguageDto;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer> {
	@Query("Select new kodlamaio.hrms.entities.dtos.CvLanguageDto(c.cvLanguageId, "
			+ " f.foreignLanguageName, l.languageLevel) "
			+ "From CvLanguage c INNER JOIN c.foreignLanguage f INNER JOIN c.languageLevel l "
			+ " where c.cv.cvId = ?1")
	List<CvLanguageDto> getCvLanguageDetails(int cvId);
}
