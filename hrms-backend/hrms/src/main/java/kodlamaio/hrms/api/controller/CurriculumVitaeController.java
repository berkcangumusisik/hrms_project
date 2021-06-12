package kodlamaio.hrms.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CreateCvDto;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin

public class CurriculumVitaeController {

	@Autowired
	private CurriculumVitaeService curriculumVitaeService;

	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid CreateCvDto createCvDto, int jobSeekerId) {
		return ResponseEntity.ok(curriculumVitaeService.add(createCvDto, jobSeekerId));
	}
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody @Valid CreateCvDto createCvDto, int jobSeekerId) {
		return ResponseEntity.ok(curriculumVitaeService.update(createCvDto, jobSeekerId));
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int userId) {
		return this.curriculumVitaeService.delete(userId);
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		return errors;
	}
}