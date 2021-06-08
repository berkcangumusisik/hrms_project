package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

public interface CurriculumVitaeService {
	Result add(CreateCvDto createCvDto, int jobSeekerId);
	Result update(CreateCvDto createCvDto, int jobSeekerId);
	Result delete(int userId);
}
