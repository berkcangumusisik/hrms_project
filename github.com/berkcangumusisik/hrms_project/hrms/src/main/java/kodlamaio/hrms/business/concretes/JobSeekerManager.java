package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service

public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;
	private MernisCheckService mernisCheckService;
	private List<String> emails = new ArrayList<>();
	private List<String> identificationNumbers = new ArrayList<>();
	
	@Autowired
	public JobSeekerManager(EmailCheckService emailCheckService, JobSeekerDao jobSeekerDao, EmailSendService emailSendService, MernisCheckService mernisCheckService) {
		super();
		this.emailCheckService = emailCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public Result login(String email, String password) {
		Result result = new ErrorResult("Giriş Başarısız!");
		for (int i = 0; i < getAll().size(); i++) {
			if (getAll().get(i).getEmail() == email && getAll().get(i).getPassword() == password) {
				result = new SuccessResult("Giriş Başarılı!");
			}
		}
		return result;
	}

	@Override
	public Result register(JobSeeker jobSeeker) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailCheckService.emailCheck(jobSeeker.getEmail())
				&& emailIsItUsed(jobSeeker.getEmail())
				&& identificationNumberIsItUsed(jobSeeker.getNationalityId())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)) {
			emailSendService.emailSend(jobSeeker.getEmail());
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResult("Kayıt Başarılı.");
		}
		return result;
	}

	@Override
	public List<JobSeeker> getAll() {
		return this.jobSeekerDao.findAll();
	}

	@Override
	public List<String> getAllEmails() {
		for (int i = 0; i < getAll().size(); i++) {
			emails.add(getAll().get(i).getEmail());
		}
		return emails;
	}

	@Override
	public List<String> getAllIdentificationNumber() {
		for (int i = 0; i < getAll().size(); i++) {
			identificationNumbers.add(getAll().get(i).getNationalityId());
		}
		return identificationNumbers;
	}
	
	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}

	public boolean identificationNumberIsItUsed(String identificationNumber) {
		boolean result = true;
		if (getAllIdentificationNumber().contains(identificationNumber)) {
			result = false;
		}
		return result;
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult("Silme işlemi Başarıyla Gerçekleşti.");
	}

}
