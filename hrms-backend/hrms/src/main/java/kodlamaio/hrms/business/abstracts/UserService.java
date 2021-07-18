package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {
	public Result updateUserSetPassword(int id, String password, String passwordAgain);

}
