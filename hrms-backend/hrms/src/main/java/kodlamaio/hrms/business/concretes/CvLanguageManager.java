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
import kodlamaio.hrms.entities.dtos.CvLanguageDto;

@Service
public class CvLanguageManager implements CvLanguageService {
	private CvLanguageDao cvLanguageDao;
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}
	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll(),"Cv'de Bulunan Yabancı Diller Listelendi.");

	}
	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("CV'ye Yabancı Dil Bilgisi Başarıyla Eklendi.");
	}
	@Override
	public DataResult<List<CvLanguageDto>> getCvLanguageDetails(int cvId) {
		return new SuccessDataResult<>(this.cvLanguageDao.getCvLanguageDetails(cvId), "Yabancı dil bilgileri listelendi.");

	}
}
