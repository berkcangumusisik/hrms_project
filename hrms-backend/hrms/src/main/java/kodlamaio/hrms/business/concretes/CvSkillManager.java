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
public class CvSkillManager implements CvSkillService  {
	private CvSkillDao cvSkillDao;
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		this.cvSkillDao = cvSkillDao;
	}
	@Override
	public DataResult<List<CvSkill>> getAll() {
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll(),"Teknolojiler başarıyla listelendi.");

	}

	@Override
	public Result add(CvSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Programlama Dili Başarıyla Eklendi.");
	}

	@Override
	public DataResult<List<CvSkill>> getAllByCv_CvId(int cvId) {
		return new SuccessDataResult<>(this.cvSkillDao.getAllByCv_CvId(cvId),"Programlama Dilleri Başarıyla Listelendi");

	}

}
