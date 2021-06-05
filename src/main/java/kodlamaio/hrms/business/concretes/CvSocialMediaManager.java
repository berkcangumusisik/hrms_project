package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSocialMediaDao;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;

@Service
public class CvSocialMediaManager implements CvSocialMediaService {
	private CvSocialMediaDao cvSocialMediaDao;
	
	@Autowired
	public CvSocialMediaManager(CvSocialMediaDao cvSocialMediaDao) {
		super();
		this.cvSocialMediaDao = cvSocialMediaDao;
	}

	@Override
	public DataResult<List<CvSocialMedia>> getAll() {

		return new SuccessDataResult<List<CvSocialMedia>>(this.cvSocialMediaDao.findAll());
	}

	@Override
	public Result add(CvSocialMedia cvSocialMedia) {
		this.cvSocialMediaDao.save(cvSocialMedia);
		return new SuccessResult("Sosyal Medya Hesapları Cv'ye Başarıyla Eklendi.");
	}

	@Override
	public Result delete(CvSocialMedia cvSocialMedia) {
		this.cvSocialMediaDao.delete(cvSocialMedia);
		return new SuccessResult("Sosyal Medya Hesapları Cv'den Başarıyla Silindi.");
	}

	@Override
	public Result update(CvSocialMedia cvSocialMedia) {
		this.cvSocialMediaDao.save(cvSocialMedia);
		return new SuccessResult("Sosyal Medya Hesapları Cv'ye Başarıyla Güncellendi.");
	}
	
}
