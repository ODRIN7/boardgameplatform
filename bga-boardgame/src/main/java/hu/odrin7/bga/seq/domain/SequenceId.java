package hu.odrin7.bga.seq.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceId {

	@Id
	private String id;

	private long seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

    public SequenceId() {
    }

    public SequenceId(String id, long seq) {
        this.id = id;
        this.seq = seq;
    }

    @Override
	public String toString() {
		return "SequenceId [id=" + id + ", seq=" + seq + "]";
	}



}
