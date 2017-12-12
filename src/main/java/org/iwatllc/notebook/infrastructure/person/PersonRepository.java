package org.iwatllc.notebook.infrastructure.person;

import java.util.List;

import org.iwatllc.notebook.model.person.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);
	List<Person> findByFirstName(@Param("name") String name);
	
}
