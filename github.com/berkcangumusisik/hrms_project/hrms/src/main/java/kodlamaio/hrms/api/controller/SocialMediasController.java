package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialmedia")
public class SocialMediasController {
	private SocialMediaService socialMediaService;
	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	@GetMapping("/getall")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}
}
