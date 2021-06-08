package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvPrewritingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvPrewritingDao;
import kodlamaio.hrms.entities.concretes.CvPrewriting;

@Service
public class CvPrewritingManager implements CvPrewritingService {

	private CvPrewritingDao cvPrewritingDao;


	@Autowired
	public CvPrewritingManager(CvPrewritingDao cvPrewritingDao) {
		this.cvPrewritingDao = cvPrewritingDao;

	}


	@Override
	public Result addAll(List<CvPrewriting> cvPrewriting) {
		cvPrewritingDao.saveAll(cvPrewriting);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CvPrewriting>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<>(this.cvPrewritingDao.getAllByJobSeekerId(id));
	}



}