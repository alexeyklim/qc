package QuakeChampions.util;

import QuakeChampions.Champions;
import QuakeChampions.Game;
import QuakeChampions.Maps;

import java.util.ArrayList;
import java.util.List;

public class SearchGames {

    public List<Game> collectAllGames(List<String> games) {
        List<Game> allgames = new ArrayList<>();
        for(int i = 0; i<games.size(); i++) {
            String gamesArr[] = games.get(i).split("%");
            Game game = new Game();
            game.setMy1(Champions.getChampionByName(gamesArr[0]));
            game.setMy2(Champions.getChampionByName(gamesArr[1]));
            game.setMy3(Champions.getChampionByName(gamesArr[2]));
            game.setEnemyName(gamesArr[3]);
            game.setMap(Maps.getMapByName(gamesArr[4]));
            game.setEnemy1(Champions.getChampionByName(gamesArr[5]));
            game.setEnemy2(Champions.getChampionByName(gamesArr[6]));
            game.setEnemy3(Champions.getChampionByName(gamesArr[7]));
            game.setGameResult(gamesArr[8]);
            game.setComment(gamesArr[9]);
            allgames.add(game);
        }
        return allgames;
    }

    public List<Game> collectAllGamesWithThePlayer(List<String> games, String playerName) {
        List<Game> allgames = new ArrayList<>();
        for(int i = 0; i<games.size(); i++) {
            String gamesArr[] = games.get(i).split("%");
            Game game = new Game();
            if (gamesArr[3].equalsIgnoreCase(playerName.split(" ")[0])) {
            game.setMy1(Champions.getChampionByName(gamesArr[0]));
            game.setMy2(Champions.getChampionByName(gamesArr[1]));
            game.setMy3(Champions.getChampionByName(gamesArr[2]));
            game.setEnemyName(gamesArr[3]);
            game.setMap(Maps.getMapByName(gamesArr[4]));
            game.setEnemy1(Champions.getChampionByName(gamesArr[5]));
            game.setEnemy2(Champions.getChampionByName(gamesArr[6]));
            game.setEnemy3(Champions.getChampionByName(gamesArr[7]));
            game.setGameResult(gamesArr[8]);
            game.setComment(gamesArr[9]);
            allgames.add(game);
            }
        }
        return allgames;
    }
}
