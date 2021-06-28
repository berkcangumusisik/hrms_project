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

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.dtos.CvLanguageDto;

@RestController
@RequestMapping("/api/cvLanguages")
@CrossOrigin
public class CvLanguagesController {
	private CvLanguageService cvLanguageService;
	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CvLanguage>> getAll() {
		return this.cvLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		return this.cvLanguageService.add(cvLanguage);
	}
	
	@GetMapping("/getCvLanguageDetails")
	public DataResult<List<CvLanguageDto>> getCvLanguageDetails(@RequestParam int cvId){
		return this.cvLanguageService.getCvLanguageDetails(cvId);
	}
	
}