package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	public DataResult<List<SystemPersonnel>> getAll();
	public Result delete(SystemPersonnel systemPersonnel);

	
	public Result register(SystemPersonnel systemPersonnel);
}
