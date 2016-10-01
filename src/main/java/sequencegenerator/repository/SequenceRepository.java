package sequencegenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sequencegenerator.model.Sequence;
import java.util.List;

/**
 * Created by silva on 27.09.16..
 */

@Repository
public interface SequenceRepository extends CrudRepository<Sequence, Long> {

    Sequence save(Sequence sequence);
    List<Sequence> findAll();
}

