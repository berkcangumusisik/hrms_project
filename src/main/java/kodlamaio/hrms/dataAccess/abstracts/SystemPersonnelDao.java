package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemPersonnel;


public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {

}
