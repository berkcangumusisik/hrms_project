package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkDao;
	private ModelMapper modelMapper;

	@Autowired
	public LinkManager(LinkDao linkDao, ModelMapper modelMapper) {
		this.linkDao = linkDao;
		this.modelMapper = modelMapper;
	}
	



	@Override
	public Result add(CreateCvDto createCvDto) {
		Link link = this.modelMapper.map(createCvDto, Link.class);
		this.linkDao.save(link);
		return new SuccessResult("Linkler Başarıyla Cv'ye Eklendi.");
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Link Başarıyla Sisteme Eklendi.");
	}

	@Override
	public Result addAll(List<Link> link) {
		linkDao.saveAll(link);
		return new SuccessResult("Linkler Başarıyla Eklendi.");
	}
	
	@Override
	public Result delete(int linkId) {
		this.linkDao.deleteById(linkId);
		return new SuccessResult("Silme İşlemi Başarıyla Gerçekleştirildi.");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<>(this.linkDao.findAll());
	}

	@Override
	public DataResult<List<Link>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(this.linkDao.getAllByLinkId(jobSeekerId));
	}




	@Override
	public Result update(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Link Başarıyla Güncellendi.");
	}


}