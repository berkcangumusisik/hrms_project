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
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

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
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(),"İş Tecrübeleri Listelendi.");

	}

	@Override
	public Result add(WorkExperience workExperience) {
		if(workExperience.getEndDate().isEmpty()) {
			workExperience.setEndDate("Devam Ediyor");
		}
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş Tecrübesi Başarıyla Eklendi.");
	}

	@Override
	public Result update(WorkExperience workExperience) {
		if(workExperience.getEndDate().isEmpty()) {
			workExperience.setEndDate("Devam Ediyor");
		}
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş Tecrübesi Başarıyla Güncellendi.");
	}

	@Override
	public Result delete(WorkExperience workExperience) {
		this.workExperienceDao.delete(workExperience);
		return new SuccessResult("İş Tecrübesi Başarıyla Silindi.");
	}

	@Override
	public DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDateils(
			int userId) {
		return new SuccessDataResult<List<WorkExperienceWithCvWithJobSeekerDto>>(
				this.workExperienceDao.getWorkExperienceWithCvWithJobSeekerDateils(userId));
	}
}
