package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where advertisementStatus=true ORDER BY applicationDeadline DESC")
	List<JobAdvertisement> getAllSortedJobAdvertisementByStatus(boolean status);
	
	@Query("From JobAdvertisement j where j.advertisementStatus=?1 and j.employer.id=?2 ORDER BY applicationDeadline DESC")
	List<JobAdvertisement> getAllSortedJobAdvertisementByStatusForEmployerId(boolean status, int employerId);
	
	JobAdvertisement getByJobAdvertisementId(int id);
	
	List<JobAdvertisement> getByAdvertisementStatus(boolean status);
	
	List<JobAdvertisement> getByAdvertisementStatusAndApprovalStatus(boolean advertisementStatus, boolean approvalStatus);

	List<JobAdvertisement> getByApprovalStatus(boolean status);
	
	JobAdvertisement getByJobAdvertisementIdAndEmployer_id(int jobAdvertisementId, int userId);
	
	List<JobAdvertisement> getByEmployer_id(int userId);

	@Modifying
	@Query("update JobAdvertisement set advertisementStatus=?3 "
			+ "where jobAdvertisementId=?1 "
			+ "and employer.id=?2 ")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(int jobAdvertisementId, int employerId, boolean status);
	
	@Modifying
	@Query("update JobAdvertisement set approvalStatus=?2 "
			+ "where jobAdvertisementId=?1")
	int updateJobAdvertisementSetApprovalStatus(int jobAdvertisementId, boolean status);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(ja.jobAdvertisementId, e.companyName , p.positionName , ja.positionAmount, ja.releaseDate, ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.position p")
	List<JobAdvertisementDto> getJobAdvertisementDetails();
	

	
}