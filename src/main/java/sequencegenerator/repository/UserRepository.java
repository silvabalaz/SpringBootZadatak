package sequencegenerator.repository;

/**
 * Created by silva on 18.09.16..
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sequencegenerator.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUsername(String username);
    User save(User user);
    List<User> findAll();
}