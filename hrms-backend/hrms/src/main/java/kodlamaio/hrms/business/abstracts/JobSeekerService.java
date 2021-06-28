package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
public interface JobSeekerService {
	public Result register(JobSeeker jobSeeker, String passwordAgain, long validationCode);
	List<JobSeeker> getAll();
	List<String> getAllEmail();
	List<String> getAllIdentityNumber();
	Result delete(int userId);

}
