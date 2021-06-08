package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSkillDao;
import kodlamaio.hrms.entities.concretes.CvSkill;

@Service
public class CvSkillManager implements CvSkillService {

	private CvSkillDao cvSkillDao;
	

	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		this.cvSkillDao = cvSkillDao;
	}

	@Override
	public Result addAll(List<CvSkill> cvSkill) {
		cvSkillDao.saveAll(cvSkill);
		return new SuccessResult("Cv'ye Yetenekler Başarıyla Eklendi.");
	}

	@Override
	public DataResult<List<CvSkill>> getAll() {
		return new SuccessDataResult<>(this.cvSkillDao.findAll(),"Yetenekler Başarıyla Listelendi.");
	}

	@Override
	public DataResult<List<CvSkill>> getAllByJobSeekerId(int cvId) {
		return new SuccessDataResult<>(this.cvSkillDao.getAllByJobSeekerId(cvId));
	}

	
}