package kodlamaio.hrms.core.mernis.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@Component
public class FakeMernisCheckManager implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}

}