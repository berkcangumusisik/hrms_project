package kodlamaio.hrms.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/link")

public class LinksController {
	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid Link link,@RequestParam int userId) {
		return ResponseEntity.ok(linkService.add(link));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody @Valid Link link,@RequestParam int userId) {
		return ResponseEntity.ok(linkService.update(link));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody int linkId) {
		return this.linkService.delete(linkId);
	}
}