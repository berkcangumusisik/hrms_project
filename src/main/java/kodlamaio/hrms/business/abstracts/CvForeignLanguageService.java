package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageService {
	public DataResult<List<CvForeignLanguage>> getAll();
	
	public Result add(CvForeignLanguage cvForeignLanguage);
	public Result update(CvForeignLanguage cvForeignLanguage);
	public Result delete(CvForeignLanguage cvForeignLanguage);

}
