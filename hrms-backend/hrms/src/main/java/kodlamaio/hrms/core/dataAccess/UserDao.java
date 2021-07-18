package kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	@Query("Select u.password From User u where u.email=?1")
	String getPasswordByEmail(String email);
	
	@Modifying
	@Query("update User set password=?2 "
			+ "where id=?1")
	int updateUserSetPassword(int id, String password);
}

