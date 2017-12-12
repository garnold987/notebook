package org.iwatllc.notebook.infrastructure.user;

import org.iwatllc.notebook.model.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findOneByUsername(String username);
}
