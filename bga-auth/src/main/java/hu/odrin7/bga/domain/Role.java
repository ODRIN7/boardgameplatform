package hu.odrin7.bga.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public enum Role {
    ADMIN_ROLE,
    USER_ROLE
}
