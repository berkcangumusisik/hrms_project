package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceCvDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceJobPositionDto;


@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(),"İş Deneyimleri Başarıyla Listelendi");
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş tecrübesi eklendi.");
	}

	@Override
	public DataResult<List<WorkExperienceCvDto>> getWorkExperienceCvDetails(
			int userId) {
		return new SuccessDataResult<List<WorkExperienceCvDto>>(
				this.workExperienceDao.getWorkExperienceCvDetails(userId),"Kullanıcının İş Geçmişi Başarılı Bir Şekilde Listelendi.");
	}

	@Override
	public DataResult<List<WorkExperienceJobPositionDto>> getWorkExperienceJobPositionDetails(
			int cvId) {
		return new SuccessDataResult<List<WorkExperienceJobPositionDto>>(this.workExperienceDao.getWorkExperienceJobPositionDetails(cvId),
				"İş Tecrübeleri Listelendi");
	}

}