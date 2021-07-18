package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	@Query("Select email From User")
	List<String> getByEmail();
	
	@Query("Select identityNumber From JobSeeker")
	List<String> getByIdentityNumber();
	
	JobSeeker getJobSeekerById(int id);

}
