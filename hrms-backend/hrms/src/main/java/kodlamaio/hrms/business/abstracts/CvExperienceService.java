package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvExperience;

public interface CvExperienceService {


	Result addAll(List<CvExperience> cvExperience);

	DataResult<List<CvExperience>> getAll();
	
	DataResult<List<CvExperience>> getAllByJobSeekerId(int id);

	DataResult<List<CvExperience>> getAllByJobSeekerIdOrderByJobEndingDateDesc(int jobSeekerId);
}