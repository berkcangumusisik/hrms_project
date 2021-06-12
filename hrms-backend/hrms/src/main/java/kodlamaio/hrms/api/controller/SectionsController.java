package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SectionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Section;
@CrossOrigin
@RestController
@RequestMapping("/api/section")
public class SectionsController {
	private SectionService sectionService;
	@Autowired
	public SectionsController(SectionService sectionService) {
		super();
		this.sectionService = sectionService;
	}
	@GetMapping("/getall")
	public DataResult<List<Section>> getAll(){
		return this.sectionService.getAll();
	}
}
