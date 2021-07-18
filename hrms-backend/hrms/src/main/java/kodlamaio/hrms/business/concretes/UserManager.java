package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public Result updateUserSetPassword(int userId, String password, String passwordAgain) {
		Result result = new ErrorResult("Güncelleme Başarısız!");
		if (Objects.equal(passwordAgain, password)) {
			this.userDao.updateUserSetPassword(userId, password);
			result = new SuccessResult("Güncelleme Başarılı.");
		}
		return result;
	}

}