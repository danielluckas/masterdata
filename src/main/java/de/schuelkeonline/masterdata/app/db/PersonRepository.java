package de.schuelkeonline.masterdata.app.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.schuelkeonline.masterdata.app.bean.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	Person findByUsername(String username);

	
	
}
