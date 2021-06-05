package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = new ErrorResult("İş Pozisyonu Sisteme Eklenemedi");
		if (positionIsItUsed(jobPosition.getName())) {
			this.jobPositionDao.save(jobPosition);
			result = new SuccessResult("İş Pozisyonu Sisteme Başarıyla Eklendi!");
		}
		return result;
	}
	
	public boolean positionIsItUsed(String positionName) {
		boolean result = true;
		for (int i = 0; i < getAll().size(); i++) {
			if (getAll().get(i).getName() == positionName) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult("İş Pozisyonu Başarıyla Silindi");
	}
}
