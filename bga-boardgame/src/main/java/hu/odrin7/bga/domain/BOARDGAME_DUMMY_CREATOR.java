package hu.odrin7.bga.domain;

import hu.odrin7.bga.domain.boardgame.BoardGame;

import java.util.Arrays;
import java.util.Collections;

import static hu.odrin7.bga.domain.boardgame.TypeOfBoardGame.*;
import static java.util.Collections.singletonList;

public   class BOARDGAME_DUMMY_CREATOR {
    public static String MEMOIRE44 = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDw0PDg0RDRsUFRAWIB0iIiAdHx8kICggJB8lGx8fITEhJSkrLi46Ix8zODMsNygtLisBCgoKDQwNGg8PGi0dHyUrLS0tNS01Ny01LS0tKysrKzctLSs3Ky0rKysrKysrKysrKysrKystKysrKysrKysrK//AABEIADIAMgMBIgACEQEDEQH/xAAaAAACAwEBAAAAAAAAAAAAAAAABQMEBgEC/8QAMhAAAgEDAgQDBgUFAAAAAAAAAQIDAAQRBSESMUFREyJhFBUjMlJxBoGRocEzQmKx4f/EABkBAQEBAQEBAAAAAAAAAAAAAAMCBAEFAP/EAB8RAAMAAgMBAAMAAAAAAAAAAAABAhIhAxExQTJCUf/aAAwDAQACEQMRAD8Ant4rq8muFjuI4o4ZYUPFCDhWA82cjOCQMetVfCuEtLW6bUFZLl3ThFsMx4k4Pr3yAW/brU7W0ok8WK+aLiZXCiNWAYAdxv8AKNjXWikaFE94cXhksieBHsSwc9PrAP8AytKqk9MxVE0to93OlahbyyRvewM6e0s4EXyoighs8XNsjbp3qx7NqMRjt2vYlL3NvAMWwbyyKGDElunIj96WsLxRGnvGQKGlP9NcniGGBONwRtvT230a6DJMNYkYMyTljChAcKMYz2GAByqrzSXbDhcbppIggtrhtZhsbi6jliaEyuywhHA4+HA55J6ferlpFpk9ppc/h3AfUJFRYy6/CB4tyeHf5eX37VUggubK7NxLKLrhjlGHiUYDMGJJGDzGR+1L49Zs4Vs4o9PtWS1bjiIZ8hhnc+bfmeeay2670ehxqMdopycHG2w5npRS6S7PiP8ALzNdruSOYMbs7tBHkcYO+QeQpdeXXs6tJIeFEGSTV6RHjCCPByMen2pbqIin8WKVgshXjOccKgHseYyAftmuXyYImIyZe/D2oQX+rXVqhWeO2CsGIGJAeWBnoelONQ1ExMI43wueBBjcmsGt3Nba/wC224hgjOA6qMZXJPPG3oMbbVqrOyFxYJqc1zG0sw8ijcKpPLPfv+lfTyOkkynxKW2j1reqk6d4ZUpJK2WAJxjGAM+n81m7chWyRkLVnUIZr2cwhwpj4jknGMUudZ7eI5ikbfBJUjPrg/lRclvxMfihetBJcJ4j7Hme1cqs8i8bbdTRRZMbBf01+o6i1gI/akWSKRmVWT5kHqN8nccqyx1pry8lzCkkfC/HNx8BKD6t/TYd+lTS217crHGpThDPwIWOShI69jnb7mvE+lySXTWCuqxYUyThenIADlvjA/OqdqvQVPXgtivNMl1B/bVuYrIr8JEbLBsjck9ug3rSWbHRIxBfNI6vM+SCAIc7ADvkjftnpSrSNFeV7SUOYpoG85yf7RkbAdMVf/Ec8tuqTndZRuEJ8hHXJHI/zSyq67S0gqqMsW9v4MJb7Hw4PDE8vAC2QdzyAPLelVx7xuy6e1YjiY4Qc8dz358+tdYSyESBlV2CNwAcRXGCMk759a6IzB7RJHmJny3GQCDg8sfbb/VZ6e+/ponWvgjktLjxGy55npRXqX3gZHJgO5Pair7ZHaNFKzeXc/J39aowu3x/MfnTr96KKKfCn6VGdvHl8x/Wo79mMUuST5R1/wAqKKVfCBlA7fUefeq2oMxfBJPmXrRRUL8kV+rIsnvRRRSBn//Z";
    public static String SEVENWONDERS = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxIREhUSEhMWFRUXGBYaGBcWGRYWGRYXGBgXFxYXFhcYICggGh0lHRgXITEiJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGxAQGy0mICUtLS8tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAGYAZgMBEQACEQEDEQH/xAAbAAACAgMBAAAAAAAAAAAAAAADBAUGAQIHAP/EADkQAAIAAwYFAgMHAQkAAAAAAAECAAMRBAUSITFBBiJRYXETkTKBsQcUI0JSYqHBFRYzNFNjctHh/8QAGgEAAwEBAQEAAAAAAAAAAAAAAgMEAQAFBv/EAC8RAAEEAQMDAgQGAwEAAAAAAAEAAgMRIQQSMRNBYSJRMmJxgQUUI5Gh0UJSwRX/2gAMAwEAAhEDEQA/AKNc90GdQ50JyA37t2hTnm6CpggMhUvb7jElQcEs/WGxRGR2XFM1Gn6IsJJbOv8Apy4s/wDPB/zK88zVmk/Z7oRx8MusYfw/5yu6/hMJw6p/LLgfyPzlZ1/ARU4YU6LLjDomjlxWif5U3K4MU6+mPlCjp2f7FF1T7BNJwLL39P2gfy47OK7q+AtzwJKH6PaO6HzFd1fAQpvBMoZLgJ8Rv5f5iibJfYIEzg+WDTkJ+kLdFtHxFWQw78kUsPwYtDyI3Ya+R0MILtpwSmO07DwqLe1gMiYU22rr4MNY4uHlQyM2HKm7itZlBWAB5KUhsMYeHeCnRTmGqGCpZbas9qFaZb0zMT6jSTBxIdjwqGztlOcfVb2mUiLiKjtTfxEUjJGPDN58rnbW3wUpZ7QqCuRbegOUe7DqmxxhpBxi8LznxkutFF4luXfxDTrmAbtpr7f2gEJJq0zKvb0+XCcQ7HPxAnVtc3dtNfb+1nSINXlSNi4mUfGPYae8KkkDclpH7f2tDCe6ZPFqn4EY+AP+4DrtBqj/AAi6RWDxUh/Ka+I10234mkfsubGTwUuvEi10zPaFyattYCfDEASXoku/5YOanvlCHdQjhWmVvAUldN8JPJVQRTPMUrCRfNILBVE+1EATlIyqMyN/MOiaWuNhTzk4pLXNKLIMq8sPgka0uB91nRe9gc3hOCxYyFGpI/8AYtdOGNLz2SdpulteVo/EVU+CXlT6x5ei03XjfI7l3CN79hACLLl0Wp0zxH9gzX+axHvv0/x83dNrulC2NVfMAklyNcQ0/iPRihAkc1wtzRgHgpTiSPBTdnmtWUWYlqtSozCjSF6lob1GM+EgWOwK1huieViS4dcbZMFfENjrRl+nyjJi+GIROyCWlp9vC1oBduCFLJAlBGZT6Z0G9dYrghifLJvHsgduAFI1oYfiYmIyWpUaNuBELC9xY0Ddk1ft5TC3JQQowzGDEHlozD+YZNQLLb3NgIwKCY9c1NalQorUZt+5fEbHCZIXBprPH/F15Ulc1oEotgdmxKKFxmBtDYdj7FbTeUyMFVLjotiVmrVjXPpTaBdt6lD2StVeNyk+FmOAAaYRlCQ1pcSVboy7p0FLNKwFmptQfWEa2e4xGPdDJBtdai5diYqCVPNnWsXRSSNYAxwwFOdObt3BRbTcc0EE4qMo3/LtE0ZDj25v7ozpznabXlsk2WDgDAEUPQjvFT2OnNuIwl9AMGEW67lmO1UYh+rfQRz9O5rdhIortubJUk/C84J8QqK5+dYx/VeA11UsFdigf3cnlQuPICgpsIU+ElxJ78prYxXK9L4enICqGg3ruesbJGXVuIwu2ADBWRw3PatXFCBXvSAEe0gg8ZWbfKInD1oUgq9KZCBc0mxYzyt2eU7ctxzZLs7YWJG+g8Ro9IXANHdVD7UC/qpjpWm0FEfWa9kjUAUKQrhtwlBQd12gd9EnyqdLI0N2lWqw+nPO9e+hjiI3ZIyqHuCftF0qi4h8K5kQW4txSBsgJpE/xgHUctMvETwim2U0EM9KNZZIrmfesVNfWaSpG/6qRWWo0AEaHFTm+FnCNocNyVhBvC0rKWp1Og6wp0m1Gxm5J2CdWhbeJRKQ6j3VTm+nCmUs+8UcqR0nuiizeYEhL6gW62frGbfdYZFyn7YFwz5dP0wcbaefogJsZUJYahVIWpwQhzwCQcZVELgOysVkvtJcgclXrQjSmRzicNcZbvCp3tLPKkblv5q/iHkbI1zJEUB5BsZSy1pHKdsHEFms7tInPgSoMp6cpU/lPzhjSDxwgJJo1lAsF5JOtzoZwCV5dArLQkUPWsCQ7eK4WtkqPyrl9zRQSch+6KKKQZiVguqyw9CKioXcwJJAtcHEmgqZelpLOWY5+dB0EIvurmign5GSiJSdxJVNenKsF0WqvI2v5T/SHwy2KK8/VRUd7eO6xxFeLSJalPiZgB2Fc4oJoZU8Ee8mlJSHxKrdRWNZkJJFYXJvtl/zEv8A4xrR+ofotPwBQt1WOZMVSmgXPx4iSWRrTRV2nie5ttTrNLcgenioQDrr1hLg4G7TJqBATX3IS64RmWFSc1HtFEVuwUpoPLVjiMD7u7OQSaUy08QbR6sBC8HF/bwq9OsOD06uTmhK/pBIoRTvGNkL92EfT2UbV5biW0EiW4UhCAKg83Qvnn8qRsT3ECkJiANpi18QTJgzYA6ZAj56xpJKJkQCzc11y5ql5wZs8s8h30gUUljAKh5V6TpM1pMwBsLYQeo66wt8beQnxSkmiFPTry9FlU5mmLLSJ2ZyjdTgVXL/AL+nz5lWoAPhFCKDrrF3PKlDdhpqtUq+XkWOVMqDQKGDb1G2YgGyZICnljyqD9o14/eHR9KZdtIbA63kuSXtoAJSyW+ZLlqsunMvxn6CFGASPLj2Kqimc1m1qbueWQruxzC4h3OkZLl2F1k+oqbW0GWkuuastadD1jWtyU6E7b2qtcQXkHdJZyRM6nUnvDS0gEgpD3ND6PCZl2U+iJjE1LqaH9NRpEPU/V2NPalS5no3H3/hNzJ4LOWNcwAe0Wxt9IpKb5W1nnqakkKB138Ru1buCtfDt7SPSVfWUOX+E7wBbSW8glVi+EP3x2agUvTPQ9xC5cBMgfnBVztxRPTIQNy+8QF+xm6+65zrJoqi3zbVmTmYDCNKR6TB6R5TGkUDasHo+tdpVlrSlPloYkeSx+4IJuVz2/0YIgbWp03HWLdM8PcdqhfkJuxWUOq9cGUGw5P1To49wT9lnBKI6EgaERxjs2EeRhGnqrlcNchoTp5gmMAOUQslBsd1i0es5ZSQaU3I7QBed2OAtNFpJ5KLYbK6l5TNhGGssHruPasLlDWSB1crGNc6Oh2QRd9DnnlUHZvEUnulUW4ScqVVyCgLA6daZ/1gCPZLu1J2e7VYluVmOyigETSOe2q4RhpKUNlKWqVLYZgr9Y5pJYbTo20F0XjOcJFmmTQoJXDT5gad4ijgEjg1AX0Fzmj1DFW5/wBulY9Ju0DbjCa3gGlervlN/ZsxMQqoIwkgHLcQmt/09kE7mh1H25XKrzNZSdamuLXeKItoebUkhG0UpW7nwopNaYdgSfnSMDmgmz3VMO6rCba3KBow2GVK9dYPeLwjt1WQt5V5SVHWmgzzr1gi4e6yzwpG65RWUoRTUnEXOVSdhWFxAOvOVryBhCvEMZisV0yr17GBmadhJ7LI3AupDtTTKaZ1oF3Xx0ENaLANoXO9ghs2A0IBegKkA1xdCdxkPeO2HlLLgn7MpmEMrAKDVssPPvkdV7Qp7DZwia5R7uGvCVRqgMBXxAOtsZT7xhdD4pkCZJdTUglDTuDrEsPqcAEg4GVXJt0TsmWaWNRkBUKO1Io6QbgrOq8twUxZuHZOKpmEhga1fME7U6wfS9NAJdNv1ZVD44sUuSyy0aq1JqTXPpWGQWHkFY/jCPc96pJRQwJJXRRUxHPC+Rx2+69LR6iOOOnpW+L3M0jldVGlVp84dBp9gyRaXqNaJD6RhD4ftCLaEad8IzNfpG6ljjGQzlBp5GmS3Gl0OTbJdrs/qmYkoISEXrTtD/w5nQFPzaRqiHu9OVUeIrcVWWUNGxVizWtaWgdilwPcMpa/7c0uYlGzMsM56kx4+kbbTZ70PovR1Tywih2SCXxMG/iKw09iputiiE1J4imKc8J87Rv6g7rt7O4RLotnqWyXMblq5J6CJ9S4mNxTo6OAui2y+7POVkWaBXL22jztL1I3hzgaWOju0BJg1WYVbQemeWnePVGoiLsFK6BrhRwl0ZWAUklqsTr3p1j0RwvOePV91R+L8yKgA1OQNR58xOcTH6JjT6FYuB0VlxBULgUqwBI8R4P4kX7g0Xn27p7AxzgXmsKyTbJiGCbKRwdeUVA7RFJHNp3jdbT2ymvihLbjdX1VUt/CgWbWSC8s5g9Oxj6TRySSRXM3a5SDaDSblXcFGSD2EekI47ta1zhgKBv6zH1BWtQOmUIlAtcCQo8WVnqWJJH0hTIwPhRue5/xIMyyMN44hClyCMjGLfsmbPasBxU0H1hTmX3VLJq4QSTWtTnnB0KpLLyTabs96TpZFGbwdIW+Jj+yMSuCmLFxIDQTpSsBU1UAEeD1gXCbhj6WsbETZao3iqZLYoZQopFcNKUPfr5jdKZHEl5ylagMGGikvct9NZGxDNdxvXqIOWESUTz2SgawVabR9oRchnlnIbUGUS6nRPncNzuFxDTzaXfjOuSqw6jKhilvWb8ZBWlotBHFSgUwH3EM68valoDUCbfyMalGPtHGWTwu9K1/tuTn+EfcRrdRKPZdTSlpttkt+Rx8xHOnkPNLAGpWYJR1D+4he959lpDUMypP7/eM3v8AC4NC9glD9fuI7c/wuoLIEr/c9xHW/wALdzQtJs2UmYDHyco71HBXF4CWnzmc4m8eB0HaGNYOAll25f/Z";
    public static String CAVERNA = "https://images-na.ssl-images-amazon.com/images/I/71VPXtzOV2L._CR0,412,1060,1060_UX128.jpg";
    public static String TERAMISTICA = "https://images-na.ssl-images-amazon.com/images/I/71PA72r5UVL._CR0,412,1060,1060_UX128.jpg";
    public static String RISIKO = "http://i.ebayimg.com/thumbs/images/g/E2IAAOSwzJ5XXrBe/s-l96.jpg";
    public static String CATAN = "http://thumbs.webs.com/Members/viewThumb.jsp?siteId=87782531&fileID=371992922&size=square";
    public static String ROBINSONCRUOSO = "http://www.balenaludens.it/wp-content/uploads/2014/09/p19-128x128.jpg";
    public static String TEXASHOLDEM = "http://d2ujflorbtfzji.cloudfront.net/key-image/24df8912-a0c2-4eb4-b583-b5c0c7eb30ee.png";
    public static String CHESS = "http://szoftverhotel.hu/images/logos/yea-chess.png";
    public static String CARCASSONE = "http://static.wixstatic.com/media/eeda92_24fe655c60864e57bfa7a6f3f94af253.jpg_256";


    public static BoardGame getMemoire(Long id) {
        return BoardGame.create(id,
            "MEMOIRE44", MEMOIRE44,
            "You will greatly benefit by applying a small degree of discipline (Buck Up Soldier!) when setting up a game scenario in\n" +
                "Memoir '44. We strongly recommend that you follow the step-by-step approach outlined below when setting up a game,\n" +
                "especially for your first few plays. The reward is an endless variety of battlefields to play on, and the\n" +
                "opportunity to pick-up fascinating historical tidbits and information from each of the scenarios played.\n" +
                "1 - Select a battle from the scenario section of this booklet. If this is your first game of Memoir ’44, we\n" +
                "strongly suggest you start with the first battle - Pegasus Bridge, p 19. This battle was both the opening\n" +
                "engagement of D-Day and is a good introductory scenario to Memoir ’44.\n" +
                "2 - Place the board in the center of the table, with the\n" +
                "proper face (countryside or beach landing) visible.\n" +
                "For Pegasus Bridge, this means the countryside face up.\n" +
                "3 - Place the necessary Terrain hexes, as indicated by the\n" +
                "battle scenario. For Pegasus Bridge, lay the 20 River\n" +
                "hexes, then 4 Village hexes and finally 9 Forest hexes.\n" +
                "4 - Add the fixed (Bunkers and Bridges) and removable\n" +
                "Obstacles, if any. For Pegasus Bridge, this means two\n" +
                "bridges, one over each river, and four barbed wires and a\n" +
                "sandbag placement to protect the bridge’s perimeter.\n" +
                "5 - Now place the figures on the board, matching the\n" +
                "various units’ positions to the scenario’s battle map.\n" +
                "Experience shows that dropping one figure per hex, for positioning\n" +
                "purposes, then filling up the units as required, is the\n" +
                "quickest way to set up. An Artillery unit is usually made of\n" +
                "2 figures, an Armor unit - 3 and an Infantry unit - 4.\n" +
                "6 - Add the Special Unit badges to individual units and\n" +
                "Victory Medals to specific, on-the-map objectives, if\n" +
                "required per the scenario’s special rules. For Pegasus\n" +
                "Bridge, place an Allied victory medal on each bridge.\n" +
                "7 - Place the Terrain summary cards that correspond to\n" +
                "the terrain in the scenario (Wood, Towns & Villages and\n" +
                "Rivers summary cards for Pegasus Bridge), plus the\n" +
                "Obstacle and Units summary cards, to the board’s side, for in-game reference. If needed, refer to Terrain in Appendix 2 (p 13)\n" +
                "for additional details on each terrain’s effects.\n" +
                "8 - Assemble the cardholder segments and place them on the board map’s edges.\n" +
                "The card holders are not necessary, but are particularly useful when playing in teams\n" +
                "of multiple players to a side, or in a classroom/demonstration environment.\n" +
                "With them, players on a same side can point to and study various options.\n" +
                "9 - Now choose each player’s side and sit in front of the board accordingly. Given the relatively short duration of a typical\n" +
                "battle scenario, we recommend match play, with each player taking first one side, then the other in an immediate re-match.\n" +
                "This helps balance any historical advantage that one side may have in a particular scenario. The winner of the match is the\n" +
                "player who scores the most Victory Medals after both battles.\n" +
                "1\n" +
                "6\n" +
                "+\n" +
                "3\n" +
                "4\n" +
                "Place Terrain hex.\n" +
                "x20\n" +
                "x4\n" +
                "x9\n" +
                "12\n" +
                "10\n" +
                "8\n" +
                "7\n" +
                "5\n" +
                "10 - Shuffle the Command cards deck thoroughly, and deal Command cards to each side per the selected scenario’s briefing\n" +
                "notes. Place those cards in your respective cardholder, keeping them secret from the opposing player. For Pegasus Bridge,\n" +
                "the Allied Commander-in-Chief receives 6 Command cards, while the German General starts with a meager 2! Rommel\n" +
                "shouldn’t have been vacationing on that fateful day!\n" +
                "11 - Place the remainder of the deck face down, alongside the board’s battlefield, within easy reach of both players.\n" +
                "12 - Each side takes four Battle dice.\n" +
                "13 - The starting player (in Pegasus Bridge — British Major, John Howard), as indicated in the scenario’s briefing notes,\n" +
                "begins play.", "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Strategic, Card, Dice, Table), 5000L, 2, 2);
    }
    public static BoardGame getSevenWOnders(Long id) {
        return BoardGame.create(id,
            "Seven Wonders", SEVENWONDERS ,
            "You are the leader of one of the 7 great cities of the Ancient World. Gather resources, develop commercial routes, and affirm your military supremacy. Build your city and erect an architectural wonder which will transcend future times.\n" +
                "\n" +
                "7 Wonders lasts three ages. In each age, players receive seven cards from a particular deck, choose one of those cards, then pass the remainder to an adjacent player. Players reveal their cards simultaneously, paying resources if needed or collecting resources or interacting with other players in various ways. (Players have individual boards with special powers on which to organize their cards, and the boards are double-sided). Each player then chooses another card from the deck they were passed, and the process repeats until players have six cards in play from that age. After three ages, the game ends.\n" +
                "\n" +
                "In essence, 7 Wonders is a card development game. Some cards have immediate effects, while others provide bonuses or upgrades later in the game. Some cards provide discounts on future purchases. Some provide military strength to overpower ",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Card, Dice), 5000L, 7, 3);
    }

    public static BoardGame getCarcassone(Long id) {
        return BoardGame.create(id,
            "Carcassone", CARCASSONE ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Card, Table), 5000L, 6, 2);
    }

    public static BoardGame getCarverna(Long id) {
        return BoardGame.create(id,
            "Caverna", CAVERNA ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Card, Table), 5000L, 6, 2);
    }
    public static BoardGame getCattan(Long id) {
        return BoardGame.create(id,
            "Catan", CATAN ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Strategic,Card, Table), 5000L, 4, 2);
    }
    public static BoardGame getTERAMISTICA(Long id) {
        return BoardGame.create(id,
            "Teramistica", TERAMISTICA ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Strategic,Card, Table), 5000L, 4, 2);
    }

    public static BoardGame getRISIKO(Long id) {
        return BoardGame.create(id,
            "Risk", RISIKO ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Strategic,Card, Table), 5000L, 7, 2);
    }
    public static BoardGame getRobinsonCrouso(Long id) {
        return BoardGame.create(id,
            "Robinson crusoe", ROBINSONCRUOSO ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", Arrays.asList(Card, Table), 5000L, 8, 2);
    }
    public static BoardGame getTexasHoldem(Long id) {
        return BoardGame.create(id,
            "Texas Holdem Poker", TEXASHOLDEM ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", singletonList(Card), 5000L, 7, 2);
    }
    public static BoardGame getChess(Long id) {
        return BoardGame.create(id,
            "Chess", CHESS ,
            "Carcassonne is a tile-based German-style board game for two to five players, designed by Klaus-Jürgen Wrede and published in 2000 by Hans im Glück in German and by Rio Grande Games (until 2012) and Z-Man Games (currently)[1] in English.[2] It received the Spiel des Jahres and the Deutscher Spiele Preis awards in 2001.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is named after the medieval fortified town of Carcassonne in southern France, famed for its city walls. The game has spawned many expansions and spin-offs, and several PC, console and mobile versions. A new edition, with updated artwork on the tiles and the box, was released in 2014",
            "https://cdn0.daysofwonder.com/memoir44/en/img/mm_rules_part1_en.pdf", singletonList(Card), 5000L, 2, 2);
    }

}
