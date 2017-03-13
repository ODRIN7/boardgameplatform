package hu.odrin7.bga.domain.boardgame;

import java.util.List;

public class BoardGame {

    private static long seq = 1000L;

    private long id;
    private String icon;
    private String name;
    private List<TypeOfBoardGame> typeOfBoardGames;
    private String shortDescription;
    private List<String> rules;
    private String pdfDescription;
    private long price;


    private BoardGame() {
    }

    private BoardGame(long id,
                      String icon,
                      String name,
                      List<TypeOfBoardGame> typeOfBoardGames, String shortDescription,
                      List<String> rules,
                      String pdfDescription, long price) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.typeOfBoardGames = typeOfBoardGames;
        this.shortDescription = shortDescription;
        this.rules = rules;
        this.pdfDescription = pdfDescription;
        this.price = price;
    }

    public static BoardGame create(String name,
                                   String icon,
                                   String shortDescription,
                                   List<String> rules,
                                   String pdfDescription,
                                   List<TypeOfBoardGame> typeOfBoardGames,
                                   long price) {
        return new BoardGame(seq++, icon, name, typeOfBoardGames, shortDescription, rules, pdfDescription, price);
    }

    public void decorateTypeOfBoardGame(TypeOfBoardGame typeOfBoardGame) {
        this.typeOfBoardGames.add(typeOfBoardGame);
    }

    public static long getSeq() {
        return seq;
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

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}