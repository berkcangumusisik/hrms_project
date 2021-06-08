package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

public interface JobSeekerService {
	 Result register(JobSeeker jobSeeker, String passwordAgain);
	 Result delete(int userId);
	 List<JobSeeker> getAll();
	 List<String> getAllEmails();
	 List<String> getAllIdentificationNumber();
	 DataResult<JobSeeker> getById(int userId);
	 DataResult<CreateCvDto> getCvById(int id);

}
