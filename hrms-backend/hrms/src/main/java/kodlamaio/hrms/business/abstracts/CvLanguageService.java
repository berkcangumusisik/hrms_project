package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;

public interface CvLanguageService {

	Result addAll(List<CvLanguage> candidateLanguage);

	DataResult<List<CvLanguage>> getAll();

	DataResult<List<CvLanguage>> getAllByJobSeekerId(int jobSeekerId);
}
