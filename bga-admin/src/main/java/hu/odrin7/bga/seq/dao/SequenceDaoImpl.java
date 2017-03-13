package hu.odrin7.bga.seq.dao;

import hu.odrin7.bga.seq.domain.SequenceId;
import hu.odrin7.bga.seq.domain.SequenceIdRepository;
import hu.odrin7.bga.seq.exception.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceDaoImpl implements SequenceDao {

    private final MongoOperations mongoOperation;
    private final SequenceIdRepository sequenceIdRepository;

    @Autowired
    public SequenceDaoImpl(MongoOperations mongoOperation, SequenceIdRepository sequenceIdRepository) {
        this.mongoOperation = mongoOperation;
        this.sequenceIdRepository = sequenceIdRepository;
    }


    @Override
    public void saveNewKey(String key, long startingNumber) throws SequenceException {
        sequenceIdRepository.save(new SequenceId(key,startingNumber));
    }

    @Override
    public long getNextSequenceId(String key) throws SequenceException {

        Query query = new Query(Criteria.where("_id").is(key));

        Update update = new Update();
        update.inc("seq", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        SequenceId seqId = mongoOperation.findAndModify(query, update, options, SequenceId.class);

        if (seqId == null) {
            throw new SequenceException("Unable to get sequence id for key : " + key);
        }

        return seqId.getSeq();

    }

}
