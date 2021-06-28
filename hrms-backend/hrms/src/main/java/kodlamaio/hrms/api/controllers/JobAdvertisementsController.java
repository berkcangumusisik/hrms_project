package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByJobAdvertisementId")
	public DataResult<List<JobAdvertisement>> getByJobAdvertisementId(int id){
		return this.jobAdvertisementService.getByJobAdvertisementId(id);
	}

	@GetMapping("/getAllActives")
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(@RequestParam boolean status) {
		return this.jobAdvertisementService.getByAdvertisementStatus(status);
	}

	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}
	
	@GetMapping("/getAllActiveSorted")
	public DataResult<List<JobAdvertisement>> getAllActiveSorted() {
		return this.jobAdvertisementService.getAllActiveSorted();
	}
	@GetMapping("/getJobAdvertisementDetails")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails() {
		return this.jobAdvertisementService.getJobAdvertisementDetails();
	}

	@GetMapping("/getByEmployerJobAdvertisements")
	public DataResult<List<JobAdvertisement>> getByEmployer_id(@RequestParam int userId) {
		return this.jobAdvertisementService.getByEmployer_id(userId);
	}
	
	@GetMapping("/getAllApproveStatus")
	public DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status){
		return this.jobAdvertisementService.getAllApproveStatus(status);
	}

	@PostMapping("/add")
	public Result addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.addJobAdvertisement(jobAdvertisement);
	}

	@PostMapping("/closeTheJobAdvertisement")
	@Transactional
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(@RequestParam("jobAdvertisementId") int jobAdvertisementId, @RequestParam("employerId") int employerId) {
		return this.jobAdvertisementService.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(jobAdvertisementId, employerId);
	}
}