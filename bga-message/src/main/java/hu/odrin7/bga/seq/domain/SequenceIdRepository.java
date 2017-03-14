package hu.odrin7.bga.seq.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceIdRepository extends CrudRepository<SequenceId, String> {
}
