package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CvSkill;

@RestController
@RequestMapping("/api/cvSkill")
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
}
