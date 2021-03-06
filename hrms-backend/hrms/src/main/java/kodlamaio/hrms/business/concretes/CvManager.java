package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Sistemde bulunan CV'ler listelendi.");
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("CV sisteme eklendi.");
	}

	@Override
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByCvIdForJobSeekerId(userId));
	}

	@Override
	public DataResult<List<CvDto>> getCvDetails(int cvId) {
		return new SuccessDataResult<List<CvDto>>(this.cvDao.getCvDetails(cvId), "Cv listelendi.");
	}

	@Override
	public Result updateCv(Cv cv, int cvId, int id) {
		cv.setCvId(cvId);
		return null;
	}

	@Override
	public Result updateCvSetCreationDate(int cvId) {
		Date date = new Date(System.currentTimeMillis());
		this.cvDao.updateCvSetCreationDate(cvId, date);
		return new SuccessResult("Oluşturulma Tarihi Güncellendi");
	}
}
