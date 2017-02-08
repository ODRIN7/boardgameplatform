package hu.odrin7.bga.seq.dao;

import hu.odrin7.bga.seq.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}
