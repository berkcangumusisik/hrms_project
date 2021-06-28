package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceCvDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceJobPositionDto;

@RestController
@RequestMapping("/api/workExperience")
@CrossOrigin
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
	@GetMapping("/getWorkExperiencJobPositionDetails")
	public DataResult<List<WorkExperienceJobPositionDto>> getWorkExperiencJobPositionDetails(
			@RequestParam int cvId){
		return this.workExperienceService.getWorkExperienceJobPositionDetails(cvId);
	}
	
	@GetMapping("/getWorkExperienceCvDetails")
	public DataResult<List<WorkExperienceCvDto>> getWorkExperienceCvDetails(
			@RequestParam int userId){
		return this.workExperienceService.getWorkExperienceCvDetails(userId);
	}
	

}