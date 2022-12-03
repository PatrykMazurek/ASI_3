package up;

import java.util.Arrays;
import java.util.List;

public class BoardGame {

        public String name;
        public int year;
        public double rating;
        public double price;
        public int minPlayers;
        public int maxPlayers;

        public BoardGame(){}

        public BoardGame(String name, int year, double rating, double price, int minPlayers, int maxPlayers) {
            this.name = name;
            this.year = year;
            this.rating = rating;
            this.price = price;
            this.minPlayers = minPlayers;
            this.maxPlayers = maxPlayers;
        }

        public List<up.BoardGame> initListGame(){
            return Arrays.asList(
                    new up.BoardGame("Terraforming Mars", 2016, 8.38, 123.49, 1, 5),
                    new up.BoardGame("Codenames", 2015, 7.82, 64.95, 2, 8),
                    new up.BoardGame("Puerto Rico", 2011, 8.07, 149.99, 2, 5),
                    new up.BoardGame("Terra Mystica", 2012,8.26, 252.99, 2, 5),
                    new up.BoardGame("Scythe", 2016, 8.3, 314.95, 1, 5),
                    new up.BoardGame("Power Grid", 2004, 7.92, 145, 2, 6),
                    new up.BoardGame("7 Wonders Duel", 2015,8.15, 109.95, 2, 2),
                    new up.BoardGame("Dominion: Intrigue", 2009,7.77, 159.95, 2, 4),
                    new up.BoardGame("Patchwork", 2014,7.77, 75, 2, 2),
                    new up.BoardGame("The Castles of Burgundy", 2011,8.12, 129.95, 2, 4),
                    new up.BoardGame("Brass: Birmingham", 2018,8.7, 133.38, 2, 4),
                    new up.BoardGame("Pandemic Legacy: Season 1", 2016,8.3, 66.35, 2,4),
                    new up.BoardGame("Gloomhaven", 2017,8.7, 349.44, 1,4),
                    new up.BoardGame("Gaia Project", 2017,8.5, 72.09, 1,4),
                    new up.BoardGame("Star Wars: Rebellion", 2016,8.4, 114.13, 2,2),
                    new up.BoardGame("Spirit Island", 2017,8.4, 122.17, 1,4),
                    new up.BoardGame("War of the Ring: Second Edition", 2011,8.5, 200.10,2,4),
                    new up.BoardGame("Through the Ages: A New Story of Civilization", 2015,8.4, 70.43,2,4),
                    new up.BoardGame("Great Western Trail", 2016, 8.3, 75.23,2,4),
                    new up.BoardGame("Dune: Imperium", 2020, 8.3, 58.96, 1,4),
                    new up.BoardGame("Ark Nova", 2021, 8.7, 63.09, 1,4),
                    new up.BoardGame("Concordia", 2013, 8.1, 49.21, 2,5),
                    new up.BoardGame("Wingspan", 2019, 8.1, 55.00,1,5),
                    new up.BoardGame("Everdell", 2018, 8.1, 81.95,1,4),
                    new up.BoardGame("Clank!: Legacy – Acquisitions Incorporated", 2019, 8.7, 27.99, 2,4),
                    new up.BoardGame("Root", 2018, 8.1, 40.74,2,4),
                    new up.BoardGame("Inis", 2016, 7.8, 149.99, 2,4),
                    new up.BoardGame("Decrypto", 2018, 7.8, 24.84, 3,8),
                    new up.BoardGame("The Isle of Cats", 2019, 7.9, 62.72, 1,4),
                    new up.BoardGame("Trickerion: Legends of Illusion", 2015,8.0, 67.91, 2,4 ),
                    new up.BoardGame("Pandemic: Iberia", 2016, 7.9, 94.99,2,5),
                    new up.BoardGame("Yokohama", 2016, 7.8, 63.09, 2,4),
                    new up.BoardGame("Res Arcana", 2019, 7.7, 48.22, 2,4),
                    new up.BoardGame("Alchemists", 2014, 7.7, 63.39, 2,4),
                    new up.BoardGame("Targi", 2012, 7.6, 22.36, 2, 2),
                    new up.BoardGame("Star Wars: X-Wing Miniatures Game", 2012, 7.7, 28.99, 2,2),
                    new up.BoardGame("Ticket to Ride: Europe", 2005, 7.5, 41.26,2,5),
                    new up.BoardGame("The Lord of the Rings: The Card Game", 2011, 7.7, 39.99, 1,2),
                    new up.BoardGame("Concordia Venus", 2018, 8.3, 49.29, 2,6),
                    new up.BoardGame("Marco Polo II: In the Service of the Khan", 2009, 8.0, 64.06, 2,4),
                    new up.BoardGame("Praga Caput Regni", 2020, 8.0, 55.55,1,4)
            );
        }

        public int getYear() { return year;}

        public double getPrice() { return price; }

        public double getRating() { return rating; }

        public String bestGame(List<up.BoardGame> boardGames){
            double highestRanking = 0;
            up.BoardGame bestGame = null;
            for (up.BoardGame game : boardGames) {
                if (game.name.contains("a")) {
                    if (game.rating > highestRanking) {
                        highestRanking = game.rating;
                        bestGame = game;
                    }
                }
            }
//        System.out.println(bestGame.name);
            return "Najlepsz gra: " + bestGame.toString();
        }

        @Override
        public String toString() {
            return name + " (" + year + "), ocena=" + rating + ", cena=" + price +
                    ", gracze=" + minPlayers + " - " +maxPlayers ;
        }
}
