package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Verification;

public interface VerificationService {

	Result save(Verification code);
	String verifyCode();
}