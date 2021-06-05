package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;

public interface CvService {
	
	public DataResult<List<Cv>> getAll();
	
	public Result add(Cv cv);
	public Result update(Cv cv);
	public Result delete(Cv cv);

	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId);
	

}