package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;

public interface SystemUserService{
	public DataResult<List<SystemUser>> getAll();
	public Result delete(int userId);
	public Result update(SystemUser systemUser);
	public Result register(SystemUser systemUser);
}
