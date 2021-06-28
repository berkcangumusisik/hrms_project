package kodlamaio.hrms.business.abstracts;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface PhotoService {
	
	DataResult<List<Photo>> getAll();
	
	Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	
	Result update(int cvId, MultipartFile multipartFile) throws IOException;
	
	Result delete(String id) throws IOException;
	
	DataResult<List<Photo>> getByPhotoForCvId(int cvId);
	
}