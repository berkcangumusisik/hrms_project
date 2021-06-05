package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;

public interface CvSocialMediaService {
	public DataResult<List<CvSocialMedia>> getAll();
	
	public Result add(CvSocialMedia cvSocialMedia);
	public Result delete(CvSocialMedia cvSocialMedia);
	public Result update(CvSocialMedia cvSocialMedia);

}
