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
	public DataResult<JobAdvertisement> getByJobAdvertisementId(@RequestParam int id) {
		return this.jobAdvertisementService.getByJobAdvertisementId(id);
	}

	@GetMapping("/getByAdvertisementStatus")
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(@RequestParam boolean status) {
		return this.jobAdvertisementService.getByAdvertisementStatus(status);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
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
	public Result jobAdvertisementAdd(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.jobAdvertisementAdd(jobAdvertisement);
	}

	@PostMapping("/closeTheJobAdvertisement")
	@Transactional
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
			@RequestParam("jobAdvertisementId") int jobAdvertisementId, @RequestParam("employerId") int employerId,
			@RequestParam("status") boolean status) {
		return this.jobAdvertisementService.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
				jobAdvertisementId, employerId, status);
	}
	@GetMapping("/getAllSortedJobAdvertisementByStatusForEmployerId")
	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatusForEmployer_id(
			@RequestParam("status") boolean status, @RequestParam("employerId") int employerId) {
		return this.jobAdvertisementService.getAllSortedJobAdvertisementByStatusForEmployer_id(status, employerId);
	}

	@PostMapping("/updateJobAdvertisementSetApprovalStatus")
	@Transactional
	public Result updateJobAdvertisementSetApprovalStatus(@RequestParam("jobAdvertisementId") int jobAdvertisementId,
			@RequestParam("status") boolean status) {
		return this.jobAdvertisementService.updateJobAdvertisementSetApprovalStatus(jobAdvertisementId, status);
	}
	@GetMapping("/getAllByPageSize")
	public DataResult<List<JobAdvertisement>> getAllByPageSize(@RequestParam("pageNo") int pageNo,
			@RequestParam("pageSize") int pageSize) {
		return this.jobAdvertisementService.getAllByPageSize(pageNo, pageSize);
	}
	@GetMapping("/getByAdvertisementStatusAndApprovalStatus")
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatusAndApprovalStatus(){
		return this.jobAdvertisementService.getByAdvertisementStatusAndApprovalStatus();
	}
}