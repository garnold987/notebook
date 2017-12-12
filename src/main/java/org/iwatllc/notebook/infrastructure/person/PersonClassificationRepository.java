package org.iwatllc.notebook.infrastructure.person;

import java.util.List;

import org.iwatllc.notebook.model.person.PersonClassification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "personclassification", path = "personclassification")
public interface PersonClassificationRepository extends PagingAndSortingRepository<PersonClassification, Long> {

	List<PersonClassification> findByName(@Param("name") String name);
}
