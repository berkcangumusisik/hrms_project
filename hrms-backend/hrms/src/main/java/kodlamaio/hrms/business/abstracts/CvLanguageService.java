package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.dtos.CvLanguageDto;

public interface CvLanguageService {
	public DataResult<List<CvLanguage>> getAll();
	public Result add(CvLanguage cvLanguage);
	DataResult<List<CvLanguageDto>> getCvLanguageDetails(int cvId);
}
