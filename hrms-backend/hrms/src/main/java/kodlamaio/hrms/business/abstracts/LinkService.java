package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

public interface LinkService {
	Result add(CreateCvDto createCvDto);

	Result add(Link link);
	Result update(Link link);

	Result addAll(List<Link> link);

	Result delete(int linkId);

	DataResult<List<Link>> getAll();

	DataResult<List<Link>> getAllByJobSeekerId(int jobSeeker);
	

}
