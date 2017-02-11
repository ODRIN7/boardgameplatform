package hu.odrin7.bga.domain.boardgame;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "boardGames")
public class BoardGame {

    @Id
    private String id;
    private String name;
    private String shortDescription;
    private String rule;


    public BoardGame() {
    }

    public BoardGame(String id, String name, String shortDescription, String rule) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.rule = rule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }



    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("name", name)
            .add("shortDescription", shortDescription)
            .add("rule", rule)
            .toString();
    }
}
