package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteService {
	Result add(Favorite favorite);
	DataResult<List<Favorite>> getAll();
	Result deleteByFavoriteId(int favoriteId);
	Result deleteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
		
	boolean existsByJobAdvertisement(int jobAdvertisementId, int jobSeekerId);
	boolean existsByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
	
	DataResult<List<Favorite>> getFavoriteByJobSeeker_id(int userId);
	
	DataResult<List<Integer>> getFavoriteByJobSeekerId(int userId);
	
	DataResult<Favorite> getFavoriteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);

}

