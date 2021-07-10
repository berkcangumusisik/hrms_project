package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	@Modifying
	@Query("update Employer set verificationStatus=?2 where id=?1")
	int updateEmployerSetVerificationStatusForUserId(int employerId, boolean status);
	
	List<Employer> getAllEmployerByVerificationStatus(boolean status);

}
