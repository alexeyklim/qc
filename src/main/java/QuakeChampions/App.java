package QuakeChampions;


import QuakeChampions.bo.Game;
import QuakeChampions.json.JsonParserHelper;
import QuakeChampions.json.matchresults.Match;
import QuakeChampions.util.Config;
import QuakeChampions.util.SearchGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App
{
    public static void main(String[] args) throws IOException {
//        QL ql = new QL();
//        ql.pack();
//        ql.setVisible(true);
        //JsonParserHelper.getInstance().getJavaObjectFromJson(JsonParserHelper.getInstance().getJsonFromUrl(Config.GAME_RESULTS + "3c5a2525-e285-11e8-af10-0003ffb80013&playerName=whybe"), Match.class);
        String config = Config.DEFAULT_PATH;
        final String PLAYERS_NAMES = "\\resources\\files\\names";
        final String GAMES = "\\resources\\files\\games";
        String path = new File("").getAbsolutePath();
        SearchGames searchGames = new SearchGames();


        List<String> names = Files.readAllLines(Paths.get(path + PLAYERS_NAMES), StandardCharsets.UTF_8);
        List<Game> games = searchGames.collectAllGames(Files.readAllLines(Paths.get(path + GAMES), StandardCharsets.UTF_8));
        QuakeChampionsApp dialog = new QuakeChampionsApp(names);
        dialog.pack();
        dialog.setVisible(true);
        TESTWINDOW test = new TESTWINDOW();
        test.pack();
        test.setVisible(true);
    }
}
