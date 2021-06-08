package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.business.abstracts.CvPrewritingService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.PhotographService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSkillDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.Verification;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

@Service

public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;
	private MernisCheckService mernisCheckService;
	private CvLanguageService cvLanguageService;
	private CvExperienceService cvExperienceService;
	private LinkService linkService;
	private PhotographService photographService;
	private CvSkillDao cvSkillService;
	private CvPrewritingService cvPrewritingService;
	private CvEducationService cvEducationService;
	private VerificationService verificationService;
	private List<String> emails = new ArrayList<>();
	private List<String> identificationNumbers = new ArrayList<>();
	

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailCheckService emailCheckService,
			EmailSendService emailSendService, MernisCheckService mernisCheckService,
			CvLanguageService cvLanguageService, CvExperienceService cvExperienceService, LinkService linkService,
			PhotographService photographService, CvSkillDao cvSkillService, CvPrewritingService cvPrewritingService,
			CvEducationService cvEducationService, VerificationService verificationService, List<String> emails,
			List<String> identificationNumbers) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailCheckService = emailCheckService;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
		this.cvLanguageService = cvLanguageService;
		this.cvExperienceService = cvExperienceService;
		this.linkService = linkService;
		this.photographService = photographService;
		this.cvSkillService = cvSkillService;
		this.cvPrewritingService = cvPrewritingService;
		this.cvEducationService = cvEducationService;
		this.verificationService = verificationService;
		this.emails = emails;
		this.identificationNumbers = identificationNumbers;
	}


	
	@Override
	public Result register(JobSeeker jobSeeker, String passwordAgain) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailCheckService.emailCheck(jobSeeker.getEmail()) && emailIsItUsed(jobSeeker.getEmail())
				&& nationalityIdIsItUsed(jobSeeker.getNationalityId())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)
				&& Objects.equal(passwordAgain, jobSeeker.getPassword())) {
			emailSendService.emailSend(jobSeeker.getEmail());
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResult("Kayıt Başarılı.");
		}
		return result;
	}


	public boolean nationalityIdIsItUsed(String nationalityId) {
		boolean result = true;
		if (getAllIdentificationNumber().contains(nationalityId)) {
			result = false;
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
	public Result delete(int userId) {
		this.jobSeekerDao.deleteById(userId);
		return new SuccessResult("Silme işlemi Başarıyla Gerçekleşti.");
	}



	@Override
	public DataResult<JobSeeker> getById(int userId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(userId));

	}
	public void verificationCode(String code, int id, String email) {
		Verification verificationCode = new Verification(id, code, false, LocalDateTime.now());
		this.verificationService.save(verificationCode);
	}

	@Override
	public DataResult<CreateCvDto> getCvById(int id) {
		CreateCvDto createCvDto = new CreateCvDto();
		createCvDto.setJobSeeker(this.getById(id).getData());
		createCvDto.setPhotograph(this.photographService.getAllByUserId(id).getData());
		createCvDto.setCvLanguage(this.cvLanguageService.getAllByJobSeekerId(id).getData());
		createCvDto.setLink(this.linkService.getAllByJobSeekerId(id).getData());
		createCvDto.setCvSkill(this.cvSkillService.getAllByJobSeekerId(id));
		createCvDto.setCvEducation(this.cvEducationService.getAllByJobSeekerId(id).getData());
		createCvDto.setCvExperience(this.cvExperienceService.getAllByJobSeekerId(id).getData());
		createCvDto.setCvPrewriting(this.cvPrewritingService.getAllByJobSeekerId(id).getData());
		return new SuccessDataResult<>(createCvDto, "Cv Listelendi");
	}


}
