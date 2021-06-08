package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hrms.entities.concretes.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;


	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		this.cvLanguageDao = cvLanguageDao;
	}


	@Override
	public Result addAll(List<CvLanguage> cvLanguage) {
		cvLanguageDao.saveAll(cvLanguage);
		return new SuccessResult("Cv'ye Dil Bilgisi Başarıyla Eklendi.");
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<>(this.cvLanguageDao.findAll(),"Cv'ye Dil Bilgisi Başarıyla Listelendi..");
	}

	@Override
	public DataResult<List<CvLanguage>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(this.cvLanguageDao.getAllByCvLanguageId(jobSeekerId));
	}

}