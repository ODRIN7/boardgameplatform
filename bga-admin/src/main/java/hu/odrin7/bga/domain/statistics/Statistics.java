package hu.odrin7.bga.domain.statistics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "statistics")
public class Statistics {
    @Id
    private String id;
    private String content;

    public Statistics() {
    }

    public Statistics(String id, String content) {
        this.id = id;
        this.content = content;
    }
}
