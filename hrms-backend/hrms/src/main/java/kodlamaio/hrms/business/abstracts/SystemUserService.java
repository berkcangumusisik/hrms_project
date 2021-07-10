package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;

public interface SystemUserService{
	DataResult<List<SystemUser>> getAll();
	Result delete(int userId);
	Result update(SystemUser systemUser);
	Result register(SystemUser systemUser);
	Result updateEmployerSetVerificationStatusForUserId(int employerId, boolean status);

}
