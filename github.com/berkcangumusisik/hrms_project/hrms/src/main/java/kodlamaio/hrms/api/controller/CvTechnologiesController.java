package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvTechnology;

@RestController
@RequestMapping("/api/cvtechnology")
public class CvTechnologiesController {
	private CvTechnologyService cvTechnologyService;

	@Autowired
	public CvTechnologiesController(CvTechnologyService cvTechnologyService) {
		super();
		this.cvTechnologyService = cvTechnologyService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CvTechnology>> getAll(){
		return this.cvTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvTechnology cvTechnology) {
		return this.cvTechnologyService.add(cvTechnology);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvTechnology cvTechnology) {
		return this.cvTechnologyService.update(cvTechnology);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody CvTechnology cvTechnology) {
		return this.cvTechnologyService.delete(cvTechnology);
	}
	
}
