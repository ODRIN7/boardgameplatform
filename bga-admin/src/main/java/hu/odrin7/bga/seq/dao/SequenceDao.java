package hu.odrin7.bga.seq.dao;

import hu.odrin7.bga.seq.exception.SequenceException;

public interface SequenceDao {

    void saveNewKey(String key, long startingNumber) throws SequenceException;

	long getNextSequenceId(String key) throws SequenceException;

}
