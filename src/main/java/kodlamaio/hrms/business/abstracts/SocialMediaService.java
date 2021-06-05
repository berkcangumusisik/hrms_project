package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	public DataResult<List<SocialMedia>> getAll();

}
