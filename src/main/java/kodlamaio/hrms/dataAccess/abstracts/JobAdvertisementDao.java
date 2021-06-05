package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Service

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getByIsActive();

}
