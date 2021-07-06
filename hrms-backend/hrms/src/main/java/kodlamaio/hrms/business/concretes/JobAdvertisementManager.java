package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Direction.ASC, "applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_id(int userId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_id(userId), "Firmanın iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status) {
		String message = "Aktif ";
		if (status == false) {
			message = "Pasif ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAdvertisementStatus(status), message + " iş ilanları listelendi.");
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		Result result = new ErrorResult("Ekleme başarısız!");
		if (!jobAdvertisement.getJobDescription().isEmpty()) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			result = new SuccessResult("Ekleme başarılı!");
		}
		return result;
	}

	@Override
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(int jobAdvertisementId, int employerId) {
		this.jobAdvertisementDao.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(jobAdvertisementId, employerId);
		return new SuccessResult("İlan kapatıldı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveSorted() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveSorted(), "İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetails(), "İş ilanları tablo yapısında listelendi.");
	}

	@Override 
	public DataResult<JobAdvertisement> getByJobAdvertisementId(int id) {
		return SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByJobAdvertisementId(id));
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status) {
		String message = "Onaylanan ";
		if (status == false) {
			message = "Onaylanmayan ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByApprovalStatus(status), message + " iş ilanları listelendi.");
	}
	
}