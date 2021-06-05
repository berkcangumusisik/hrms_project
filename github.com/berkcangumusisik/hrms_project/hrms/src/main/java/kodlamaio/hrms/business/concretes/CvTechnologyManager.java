package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvTechnologyDao;
import kodlamaio.hrms.entities.concretes.CvTechnology;

@Service
public class CvTechnologyManager implements CvTechnologyService {
	private CvTechnologyDao cvTechnologyDao;
	@Autowired
	public CvTechnologyManager(CvTechnologyDao cvTechnologyDao) {
		super();
		this.cvTechnologyDao = cvTechnologyDao;
	}
	@Override
	public DataResult<List<CvTechnology>> getAll() {
		return new SuccessDataResult<List<CvTechnology>>(this.cvTechnologyDao.findAll());
	}
	@Override
	public Result add(CvTechnology cvTechnology) {
		this.cvTechnologyDao.save(cvTechnology);
		return new SuccessResult("Cv'ye Programlama dili/Teknoloji Başarıyla Eklendi.");
	}
	@Override
	public Result update(CvTechnology cvTechnology) {
		this.cvTechnologyDao.save(cvTechnology);
		return new SuccessResult("Cv'de Bulunan Programlama dili/Teknoloji Başarıyla Güncellendi.");
	}
	@Override
	public Result delete(CvTechnology cvTechnology) {
		this.cvTechnologyDao.delete(cvTechnology);
		return new SuccessResult("Cv'den Programlama dili/Teknoloji Başarıyla Silindi.");
	}
	
}
