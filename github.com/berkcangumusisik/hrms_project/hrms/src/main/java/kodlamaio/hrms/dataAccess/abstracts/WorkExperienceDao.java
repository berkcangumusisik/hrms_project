package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{

	
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto("
			+ "w.workExperienceId,w.workplaceName, w.startDate, w.endDate, p.positionName, f.firstName, f.lastName ) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobSeeker f ON w.cv.jobSeeker.userId=j.userId "
			+ "Inner Join JobPosition p ON w.jobPosition.positionId=p.positionId "
			+ "where w.cv.jobSeeker.userId=?1 ORDER BY w.endDate DESC")
	List<WorkExperienceWithCvWithJobSeekerDto> getWorkExperienceWithCvWithJobSeekerDateils(int userId);
}
