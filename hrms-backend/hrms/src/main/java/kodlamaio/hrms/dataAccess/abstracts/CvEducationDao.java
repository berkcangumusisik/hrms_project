package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer> {
    List<CvEducation> getAllByCv_CvIdOrderByGraduationDateDesc(int cvId);
    List<CvEducation> getAllByCv_CvId(int cvId);


}
