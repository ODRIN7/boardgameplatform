package hu.odrin7.bga.domain.boardgame;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class BoardGame {

    private long id;
    private String icon;
    private String name;
    private List<TypeOfBoardGame> typeOfBoardGames;
    private String shortDescription;
    private String pdfDescription;
    private long price;
    private int maxplayer;
    private int minplayer;

    private BoardGame() {
    }

    private BoardGame(long id,
                      String icon,
                      String name,
                      List<TypeOfBoardGame> typeOfBoardGames,
                      String shortDescription,
                      String pdfDescription,
                      long price,
                      int maxplayer,
                      int minplayer) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.typeOfBoardGames = typeOfBoardGames;
        this.shortDescription = shortDescription;
        this.pdfDescription = pdfDescription;
        this.price = price;
        this.maxplayer = maxplayer;
        this.minplayer = minplayer;
    }

    public static BoardGame create(long id,
                                   String name,
                                   String icon,
                                   String shortDescription,
                                   String pdfDescription,
                                   List<TypeOfBoardGame> typeOfBoardGames,
                                   long price,
                                   int maxplayer,
                                   int minplayer) {
        return new BoardGame(id, icon, name, typeOfBoardGames, shortDescription, pdfDescription, price, maxplayer, minplayer);
    }

    public void decorateTypeOfBoardGame(TypeOfBoardGame typeOfBoardGame) {
        this.typeOfBoardGames.add(typeOfBoardGame);
    }

    public String getIcon() {
        return icon;
    }

    public List<TypeOfBoardGame> getTypeOfBoardGames() {
        return typeOfBoardGames;
    }

    public String getPdfDescription() {
        return pdfDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getMaxplayer() {
        return maxplayer;
    }

    public void setMaxplayer(int maxplayer) {
        this.maxplayer = maxplayer;
    }

    public int getMinplayer() {
        return minplayer;
    }

    public void setMinplayer(int minplayer) {
        this.minplayer = minplayer;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("id", id)
            .add("icon", icon)
            .add("name", name)
            .add("typeOfBoardGames", typeOfBoardGames)
            .add("shortDescription", shortDescription)
            .add("pdfDescription", pdfDescription)
            .add("price", price)
            .add("minplayer", minplayer)
            .add("maxplayer", maxplayer)
            .toString();
    }
}
