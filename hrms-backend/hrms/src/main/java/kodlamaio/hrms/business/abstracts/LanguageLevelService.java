package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelService {
	public DataResult<List<LanguageLevel>> getAll();

}
