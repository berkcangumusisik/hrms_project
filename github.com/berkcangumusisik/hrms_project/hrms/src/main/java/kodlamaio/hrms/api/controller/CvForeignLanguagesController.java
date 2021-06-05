package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;

@RestController
@RequestMapping("/api/cvforeignlanguage")
public class CvForeignLanguagesController {
	public CvForeignLanguageService cvForeignLanguageService;
	@Autowired
	public CvForeignLanguagesController(CvForeignLanguageService cvForeignLanguageService) {
		super();
		this.cvForeignLanguageService = cvForeignLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvForeignLanguage>> getAll(){
		return this.cvForeignLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvForeignLanguage cvForeignLanguage) {
		return this.cvForeignLanguageService.add(cvForeignLanguage);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody CvForeignLanguage cvForeignLanguage){
		this.cvForeignLanguageService.update(cvForeignLanguage);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody CvForeignLanguage cvForeignLanguage) {
		return this.cvForeignLanguageService.delete(cvForeignLanguage);
		
	}
	

}
