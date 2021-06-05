package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Cv cv) {
		return this.cvService.update(cv);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Cv cv) {
		return this.cvService.delete(cv);
		
	}
	
	@PostMapping("/getByCvIdForJobSeeker_UserId")
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(@RequestParam int userId) {
		return this.cvService.getByCvIdForJobSeeker_UserId(userId);
	}

}
