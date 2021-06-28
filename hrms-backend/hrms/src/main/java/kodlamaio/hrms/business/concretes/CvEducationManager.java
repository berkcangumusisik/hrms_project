package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvEducationDao;
import kodlamaio.hrms.entities.concretes.CvEducation;

@Service
public class CvEducationManager implements CvEducationService {

	private CvEducationDao cvEducationDao;

	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CvEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("CV'ye Eğitim Bilgisi Başarıyla Eklendi.");
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		return new SuccessDataResult<>(this.cvEducationDao.findAll(),"Eğitim Bilgisi Başarıyla Listelendi.");

	}

	@Override
	public DataResult<List<CvEducation>> getAllByCv_CvIdOrderByGraduationDateDesc(int cvId) {
		return new SuccessDataResult<>(this.cvEducationDao.getAllByCv_CvIdOrderByGraduationDateDesc(cvId),
				"Mezuniyet Tarihine Göre Listelendi.");
	}

	@Override
	public DataResult<List<CvEducation>> getAllByCv_CvId(int cvId) {
		return new SuccessDataResult<>(this.cvEducationDao.getAllByCv_CvId(cvId));

	}
}