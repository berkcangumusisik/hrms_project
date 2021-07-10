package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemUser")
@CrossOrigin
public class SystemUsersController {
	private SystemUserService systemUserService;
	
	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}
	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll(){
		return this.systemUserService.getAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> add(@Valid @RequestBody SystemUser systemUser) {
		return ResponseEntity.ok(this.systemUserService.update(systemUser));
	}
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody SystemUser systemUser){
		return ResponseEntity.ok(this.systemUserService.update(systemUser));
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int userId) {
		return this.systemUserService.delete(userId);
		
	}
	@Transactional
	@PostMapping("/employerVerification")
	public Result updateEmployerSetVerificationStatusForEmployer_id(@RequestParam("employerId") int employerId,
			@RequestParam("status") boolean status) {
		return this.systemUserService.updateEmployerSetVerificationStatusForUserId(employerId, status);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String , String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		return errors;
	}
}
