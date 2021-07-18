package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	
	
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"İş Verenler Başarıyla Listelendi.");
	}

	@Override
	public Result register(Employer employer,String password) {
		employerDao.save(employer);
		return new SuccessResult(employer.getCompanyName() +" eklendi.");
	}

	@Override
	public Result update(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(employer.getCompanyName() +" güncellendi.");
	}

	@Override
	public Result delete(int userId) {
		employerDao.deleteById(userId);
		return new SuccessResult("Şirket Başarılı Bir Şekilde Silindi.");
	}

	@Override
	public Result login(String email, String password) {
		Result result = new ErrorResult("Giriş Başarısız!");
		if (Objects.equal(this.userDao.getPasswordByEmail(email), password)) {
			result = new SuccessResult("Giriş Başarılı.");
		}
		return result;
	}
	@Override
	public DataResult<List<Employer>> getAllEmployerByVerificationStatus(boolean status) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getAllEmployerByVerificationStatus(status),
				"İş Verenler Listelendi.");
	}

	@Override
	public DataResult<Map<String, Object>> getUpdateById(int id) {
		return new SuccessDataResult<>(this.employerDao.getUpdateById(id), "Güncellenmiş bilgiler listelendi.");

	}

	@Override
	public DataResult<List<Employer>> getAllUpdatedEmployer() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByUpdateNotNull(), "Güncellenmiş iş verenler listelendi");

	}



	@Override
	public Result updatedEmployerVerification(int employerId) {
		Map<String, Object> updatedInfo = getUpdateById(employerId).getData();
		Employer newEmployer = new Employer();
		newEmployer.setId(employerId);
		newEmployer.setEmail(updatedInfo.get("email").toString());
		newEmployer.setPassword(updatedInfo.get("password").toString());
		newEmployer.setCompanyName(updatedInfo.get("companyName").toString());
		newEmployer.setWebAddress(updatedInfo.get("webAdress").toString());
		newEmployer.setPhoneNumber(updatedInfo.get("phoneNumber").toString());
		newEmployer.setUpdateStatus(true);
		this.employerDao.save(newEmployer);
		return new SuccessResult("Güncelleme Onaylandı!");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id), "İş Veren Bilgileri Listelendi.");

	}
}
