package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Map;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;


public interface EmployerService {

	 DataResult<List<Employer>> getAll();
	 Result register(Employer employer, String passwordAgain);
	 Result login( String email, String password);
	 Result update(Employer employer);
	 Result delete(int userId);
	 DataResult<List<Employer>> getAllEmployerByVerificationStatus(boolean status);
	 DataResult<Map<String, Object>> getUpdateById(int id);
	 DataResult<List<Employer>> getAllUpdatedEmployer();
	 Result updatedEmployerVerification(int employerId);
	 DataResult<Employer>  getById(int id);
}
