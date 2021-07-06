package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<JobAdvertisement> getByJobAdvertisementId(int id);
	
	DataResult<List<JobAdvertisement>> getAllSorted();
	
	DataResult<List<JobAdvertisement>> getAllActiveSorted();
	
	DataResult<List<JobAdvertisement>> getByEmployer_id(int userId);

	
	DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status);	
	
	DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status);
	
	Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	
	Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(int jobAdvertisementId, int employerId);

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails();
}
