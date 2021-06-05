package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallbydate")
	public DataResult<List<JobAdvertisement>> getAllByDate(){
		return this.jobAdvertisementService.getAllSortedByDate();
	}
	
	@GetMapping("/getallbyactive")
	public DataResult<List<JobAdvertisement>> getAllByActive(){
		return this.jobAdvertisementService.getAllSortedByActive();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody JobAdvertisement jobAdvertisement){
		this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody JobAdvertisement jobAdvertisement){
		this.jobAdvertisementService.update(jobAdvertisement);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
}
