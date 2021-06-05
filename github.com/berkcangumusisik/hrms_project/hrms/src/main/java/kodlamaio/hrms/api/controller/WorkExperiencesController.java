package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

@RestController
@RequestMapping("/api/workexperience")
public class WorkExperiencesController {
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.update(workExperience);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.delete(workExperience);
		
	}
	
	@PostMapping("/getWorkExperienceWithCvWithJobSeekerDateils")
	public DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDateils(
			@RequestParam int userId){
		return this.workExperienceService.getWorkExperienceWithCvWithJobSeekerDateils(userId);
	}

	

}
