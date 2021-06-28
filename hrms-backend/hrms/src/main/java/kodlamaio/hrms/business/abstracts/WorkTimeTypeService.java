package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkTimeType;

public interface WorkTimeTypeService {
	
	public DataResult<List<WorkTimeType>> getAll();

}
