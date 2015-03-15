package de.schuelkeonline.masterdata.app.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.schuelkeonline.masterdata.app.bean.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	public User findByUsername(String username);

	
	
}
