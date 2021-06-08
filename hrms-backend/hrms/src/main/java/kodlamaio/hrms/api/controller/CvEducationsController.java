package kodlamaio.hrms.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CvEducation;


@RestController
@RequestMapping("/api/cvEducation")
public class CvEducationsController {

	private CvEducationService cvEducationService;

	@Autowired
	public CvEducationsController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvEducation>> getAll(){
		return this.cvEducationService.getAll();
	}
	
	@GetMapping("/getGraduationDateDesc")
	public DataResult<List<CvEducation>> getByJobSeekerIdOrderByGraduationDateDesc(@RequestParam int jobSeekerId) {
		return this.cvEducationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId);
	}
	
	
}