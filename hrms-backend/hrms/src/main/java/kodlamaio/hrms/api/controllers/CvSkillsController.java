package kodlamaio.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSkill;

@RestController
@RequestMapping("/api/cvSkill")
@CrossOrigin

public class CvSkillsController {
	private CvSkillService cvSkillService;
	
	@Autowired
	public CvSkillsController(CvSkillService cvSkillService) {
		super();
		this.cvSkillService = cvSkillService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvSkill>> getAll(){
		return this.cvSkillService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSkill cvSkill) {
		return this.cvSkillService.add(cvSkill);
	}
}