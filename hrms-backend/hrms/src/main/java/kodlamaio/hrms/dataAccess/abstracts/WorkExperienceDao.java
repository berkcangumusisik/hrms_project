package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceCvDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceJobPositionDto;


public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{
	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceJobPositionDto("
			+ "w.workExperienceId,p.positionId, w.workplaceName, w.startingDate, w.endingDate, p.positionName) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobPosition p ON w.jobPosition.positionId=p.positionId "
			+ "where w.cv.cvId=?1 ORDER BY w.endingDate DESC")
	List<WorkExperienceJobPositionDto> getWorkExperienceJobPositionDetails(int cvId);

	
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceCvDto("
			+ "w.workExperienceId,w.workplaceName, w.startingDate, w.endingDate, p.positionName, j.firstName, j.lastName ) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobSeeker j ON w.cv.jobSeeker.id=j.id "
			+ "Inner Join JobPosition p ON w.jobPosition.positionId=p.positionId "
			+ "where w.cv.jobSeeker.id=?1 ORDER BY w.endingDate DESC")
	List<WorkExperienceCvDto> getWorkExperienceCvDetails(int userId);
	
}
