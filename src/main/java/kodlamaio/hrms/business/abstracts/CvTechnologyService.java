package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvTechnology;

public interface CvTechnologyService {
	DataResult<List<CvTechnology>> getAll();
	
	Result add(CvTechnology cvTechnology);
	Result update(CvTechnology cvTechnology);
	Result delete(CvTechnology cvTechnology);
}
