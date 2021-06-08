package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;


	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		this.cvExperienceDao = cvExperienceDao;

	}



	@Override
	public Result addAll(List<CvExperience> cvExperince) {
		this.cvExperienceDao.saveAll(cvExperince);
		return new SuccessResult("Cv'ye İş Tecrünesi Başarıyla Eklendi.");
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		return new SuccessDataResult<>(this.cvExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CvExperience>> getAllByJobSeekerIdOrderByJobEndingDateDesc(int jobSeekerId) {
		return new SuccessDataResult<>(this.cvExperienceDao.getAllByJobSeekerIdOrderByJobEndingDateDesc(jobSeekerId));
	}

	@Override
	public DataResult<List<CvExperience>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<>(this.cvExperienceDao.getAllByJobSeekerId(id));
	}

	

}