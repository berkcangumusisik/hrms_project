package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	@Modifying
	@Query("update Employer set verificationStatus=?2 where id=?1")
	int updateEmployerSetVerificationStatusForUserId(int employerId, boolean status);
	
	List<Employer> getAllEmployerByVerificationStatus(boolean status);
	@Query("Select e.update From Employer e where e.id=?1")
	Map<String, Object> getUpdateById(int id);
	
	Employer getById(int id);

	List<Employer> findByUpdateNotNull();
}
