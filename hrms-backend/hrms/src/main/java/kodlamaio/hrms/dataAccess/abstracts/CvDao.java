package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;


public interface CvDao extends JpaRepository<Cv, Integer> {
	@Query("From Cv c where c.jobSeeker.id= ?1")
	List<Cv> getByCvIdForJobSeekerId(int userId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CvDto( c.githubLink, c.linkedinLink,c.coverLetter,"
			+ "j.firstName, j.lastName,j.email, j.dateOfBirth) "
			+ "From Cv c INNER JOIN c.jobSeeker j "
			+ "where c.cvId = :cvId")
			
	List<CvDto> getCvDetails(int cvId);
	
	@Modifying
	@Query("update Cv set creationDate=?2 "
			+ "where cvId=?1")
	int updateCvSetCreationDate(int cvId, Date creationDate);
}