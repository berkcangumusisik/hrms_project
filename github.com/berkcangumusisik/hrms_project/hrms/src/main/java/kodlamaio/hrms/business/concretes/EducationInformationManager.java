package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationInformationDao;
	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.findAll(),"Eğitim Bilgileri Başarıyla Listelendi");
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		if(educationInformation.getGraduationDate().isEmpty()) {
			educationInformation.setGraduationDate("Devam Ediyor");
		}
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public Result delete(EducationInformation educationInformation) {
		this.educationInformationDao.delete(educationInformation);
		return new SuccessResult("Eğitim Bilgisi Başarıyla Silindi");
	}

	@Override
	public Result update(EducationInformation educationInformation) {
		if(educationInformation.getGraduationDate().isEmpty()) {
			educationInformation.setGraduationDate("Devam Ediyor");
		}
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim Bilgisi Başarıyla Güncellendi.");
	}

	@Override
	public DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>> getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(
			int userId) {
		return new SuccessDataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>>(
				this.educationInformationDao.getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(userId));
	}

}
