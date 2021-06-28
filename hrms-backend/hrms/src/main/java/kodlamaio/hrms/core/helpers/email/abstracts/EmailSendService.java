package kodlamaio.hrms.core.helpers.email.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailSendService {
	
	public void emailSend(String email);
	
	public Result run( String email) throws Exception;

}