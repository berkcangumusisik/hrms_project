package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceService {
	public DataResult<List<WorkExperience>> getAll();
	
	public Result add(WorkExperience workExperience);
	public Result update(WorkExperience workExperience);
	public Result delete(WorkExperience workExperience);
	DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDetails(int userId);
}
