package hu.odrin7.bga.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "status")
public enum Status {
    ALREADY_PAYED,
    NOT_PAYED
}
