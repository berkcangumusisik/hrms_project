package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceCvDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceJobPositionDto;


public interface WorkExperienceService {
	
	DataResult<List<WorkExperience>> getAll();
	
	Result add(WorkExperience workExperience);
	
	DataResult<List<WorkExperienceJobPositionDto>> getWorkExperienceJobPositionDetails(int cvId);
	
	DataResult<	List<WorkExperienceCvDto>> getWorkExperienceCvDetails(int userId);


}