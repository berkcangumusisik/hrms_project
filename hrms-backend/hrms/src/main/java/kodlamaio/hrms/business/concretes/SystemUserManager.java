package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemUserDao;
import kodlamaio.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService{
	private SystemUserDao systemUserDao;
	private EmployerDao employerDao;

	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao, EmployerDao employerDao) {
		super();
		this.systemUserDao = systemUserDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(), "Sistem Kullanıcı Bilgileri Listelendi.");

	}

	@Override
	public Result delete(int userId) {
		this.systemUserDao.deleteById(userId);
		return new SuccessResult("Sistem Personeli Başarılı Bir Şekilde Silindi.");
	}

	@Override
	public Result update(SystemUser systemUser) {
		this.systemUserDao.save(systemUser);
		return new SuccessResult("Sistem Personeli Başarıyla Eklendi.");
	}

	@Override
	public Result register(SystemUser systemUser) {
		this.systemUserDao.save(systemUser);
		return new SuccessResult("Sistem Personeli Başarıyla Güncellendi.");
	}
	@Override
	public Result updateEmployerSetVerificationStatusForUserId(int employerId, boolean status) {
		this.employerDao.updateEmployerSetVerificationStatusForUserId(employerId,status);
		return new SuccessResult("İş Veren Onaylandı!");
	}

	@Override
	public DataResult<SystemUser> getById(int id) {
		return new SuccessDataResult<SystemUser>(this.systemUserDao.getById(id));

	}

}
