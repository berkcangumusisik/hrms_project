package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvService {
	DataResult<List<Cv>> getAll();
	Result add(Cv cv);
	DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId);
	DataResult<List<CvDto>> getCvDetails(int cvId);
}