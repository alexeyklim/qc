package QuakeChampions;


import QuakeChampions.util.SearchGames;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App
{
    public static void main(String[] args) throws IOException {
        final String PLAYERS_NAMES = "\\resources\\files\\names";
        final String GAMES = "\\resources\\files\\games";
        String path = new File("").getAbsolutePath();
        SearchGames searchGames = new SearchGames();
        List<String> names = Files.readAllLines(Paths.get(path + PLAYERS_NAMES), StandardCharsets.UTF_8);
        List<Game> games = searchGames.collectAllGames(Files.readAllLines(Paths.get(path + GAMES), StandardCharsets.UTF_8));
        QuakeChampionsApp dialog = new QuakeChampionsApp(names);
        dialog.pack();
        dialog.setVisible(true);
    }
}
