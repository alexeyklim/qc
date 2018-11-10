package QuakeChampions;

import QuakeChampions.bo.Game;
import QuakeChampions.bo.enums.Champions;
import QuakeChampions.bo.enums.Maps;
import QuakeChampions.util.Autocomplete;
import QuakeChampions.util.SearchGames;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuakeChampionsApp extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField playerName;
    private JLabel MAPS;
    private JButton button1;
    private JLabel awoken_score;
    private JLabel dm6_score;
    private JLabel ztn_score;
    private JLabel corrupted_score;
    private JLabel molten_score;
    private JLabel vale_score;
    private JLabel ranger;
    private JLabel anarki;
    private JLabel athena;
    private JLabel bj;
    private JLabel clutch;
    private JLabel deathknight;
    private JLabel galena;
    private JLabel keel;
    private JLabel scalebearer;
    private JLabel nyx;
    private JLabel slash;
    private JLabel sorlag;
    private JLabel strogg;
    private JLabel visor;
    private JCheckBox enemyRanger;
    private JCheckBox enemyAnarki;
    private JCheckBox enemyAthena;
    private JCheckBox enemyBJ;
    private JCheckBox enemyClutch;
    private JCheckBox enemyDK;
    private JCheckBox enemyGalena;
    private JCheckBox enemyKeel;
    private JCheckBox enemyScalebearer;
    private JCheckBox enemyNyx;
    private JCheckBox enemySlash;
    private JCheckBox enemySorlag;
    private JCheckBox enemyStrogg;
    private JCheckBox enemyVisor;
    private JCheckBox myRanger;
    private JCheckBox myAnarki;
    private JCheckBox myAthena;
    private JCheckBox myBJ;
    private JCheckBox myClutch;
    private JCheckBox myDK;
    private JCheckBox myGalena;
    private JCheckBox myKeel;
    private JCheckBox myScalebearer;
    private JCheckBox myNyx;
    private JCheckBox mySlash;
    private JCheckBox mySorlag;
    private JCheckBox myStrogg;
    private JCheckBox myVisor;
    private JRadioButton awokenMap;
    private JRadioButton bloodRunMap;
    private JRadioButton corruptedKeepMap;
    private JRadioButton moltenFallsMap;
    private JRadioButton valeOfPnathMap;
    private JRadioButton bloodCovenantMap;
    private JRadioButton win30;
    private JRadioButton win32;
    private JRadioButton win31;
    private JRadioButton lose23;
    private JRadioButton lose03;
    private JRadioButton lose13;
    private JLabel doom;
    private JCheckBox myDoom;
    private JCheckBox enemyDoom;
    private ButtonGroup currentMap;
    private ButtonGroup theGameScore;
    private static final String COMMIT_ACTION = "commit";
    public List<String> playersNames;

    public QuakeChampionsApp(final List<String> playersNames){



        setTitle("Quake Champions");

        currentMap = new ButtonGroup();
        currentMap.add(awokenMap);
        currentMap.add(bloodRunMap);
        currentMap.add(corruptedKeepMap);
        currentMap.add(moltenFallsMap);
        currentMap.add(valeOfPnathMap);
        currentMap.add(bloodCovenantMap);

        theGameScore = new ButtonGroup();
        theGameScore.add(win30);
        theGameScore.add(win31);
        theGameScore.add(win32);
        theGameScore.add(lose03);
        theGameScore.add(lose13);
        theGameScore.add(lose23);

        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        playerName.setFocusTraversalKeysEnabled(false);
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.addAll(playersNames);
        Autocomplete autocomplete = new Autocomplete(playerName, keywords);
        playerName.getDocument().addDocumentListener(autocomplete);
        playerName.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        playerName.getActionMap().put(COMMIT_ACTION, autocomplete.new CommitAction());


        //KeyEvent.VK_ENTER


        playerName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                List<Game> games = new ArrayList<>();
                char keyChar = e.getKeyChar();
                if (e.paramString().contains("keyChar=Tab")) {
                    SearchGames searchGames = new SearchGames();
                    String path = new File("").getAbsolutePath();
                    final String GAMES = "\\resources\\files\\games";

                    try {
                        games = searchGames.collectAllGamesWithThePlayer(Files.readAllLines(Paths.get(path + GAMES), StandardCharsets.UTF_8), playerName.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                int awokenWin = 0, awokenLose = 0;
                int dm6Win = 0, dm6Lose = 0;
                int ztnWin = 0, ztnLose = 0;
                int corruptedWin = 0, corruptedLose = 0;
                int moltenWin = 0, moltenLose =0;
                int valeWin = 0, valeLose = 0;
                for (int i = 0; i < games.size(); i++){
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("awoken")) {
                         if (games.get(i).amIwin()) {awokenWin=awokenWin+1;} else {awokenLose=awokenLose+1;}
                    }
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("dm6")) {
                        if (games.get(i).amIwin()) {dm6Win=dm6Win+1;} else {dm6Lose=dm6Lose+1;}
                    }
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("ztn")) {
                        if (games.get(i).amIwin()) {ztnWin=ztnWin+1;} else {ztnLose=ztnLose+1;}
                    }
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("corrupted")) {
                        if (games.get(i).amIwin()) {corruptedWin=corruptedWin+1;} else {corruptedLose=corruptedLose+1;}
                    }
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("molten")) {
                        if (games.get(i).amIwin()) {moltenWin=moltenWin+1;} else {moltenLose=moltenLose+1;}
                    }
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("vale")) {
                        if (games.get(i).amIwin()) {valeWin=valeWin+1;} else {valeLose=valeLose+1;}
                    }
                }

                if(awokenWin!=0||awokenLose!=0) {awoken_score.setText(awokenWin+ ":" +awokenLose);} else {awoken_score.setText("n/a");}
                if(dm6Win!=0||dm6Lose!=0) {dm6_score.setText(dm6Win+ ":" +dm6Lose);} else {dm6_score.setText("n/a");}
                if(ztnWin!=0||ztnLose!=0) {ztn_score.setText(ztnWin+ ":" +ztnLose);} else {ztn_score.setText("n/a");}
                if(corruptedWin!=0||corruptedLose!=0) {corrupted_score.setText(corruptedWin+ ":" + corruptedLose);} else {corrupted_score.setText("n/a");}
                if(moltenWin!=0||moltenLose!=0) {molten_score.setText(moltenWin+ ":" +moltenLose);}  else {molten_score.setText("n/a");}
                if(valeWin!=0||valeLose!=0) {vale_score.setText(valeWin+ ":" +valeLose);} else {vale_score.setText("n/a");}

            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String PLAYERS_NAMES = "\\resources\\files\\names";
                final String GAMES = "\\resources\\files\\games";
                String path = new File("").getAbsolutePath();
                String theScore = "";
                String theRecord = "";
                Game game = new Game();
                if(awokenMap.isSelected()) game.setMap(Maps.AWOKEN);
                if(bloodCovenantMap.isSelected()) game.setMap(Maps.BLOOD_COVENANT);
                if(bloodRunMap.isSelected()) game.setMap(Maps.BLOOD_RUN);
                if(corruptedKeepMap.isSelected()) game.setMap(Maps.CORRUPTED_KEEP);
                if(moltenFallsMap.isSelected()) game.setMap(Maps.MOLTEN_FALLS);
                if(valeOfPnathMap.isSelected()) game.setMap(Maps.VALE_OF_PNATH);

                List<Champions> myChampions = new ArrayList<>();
                if (myRanger.isSelected()) myChampions.add(Champions.RANGER);
                if (myAnarki.isSelected()) myChampions.add(Champions.ANARKI);
                if (myAthena.isSelected()) myChampions.add(Champions.ATHENA);
                if (myBJ.isSelected()) myChampions.add(Champions.BJ_BLAZKOWICZ);
                if (myClutch.isSelected()) myChampions.add(Champions.CLUTCH);
                if (myDK.isSelected()) myChampions.add(Champions.DEATH_KNIGHT);
                if (myGalena.isSelected()) myChampions.add(Champions.GALENA);
                if (myKeel.isSelected()) myChampions.add(Champions.KEEL);
                if (myScalebearer.isSelected()) myChampions.add(Champions.SCALEBEARER);
                if (myNyx.isSelected()) myChampions.add(Champions.NYX);
                if (mySlash.isSelected()) myChampions.add(Champions.SLASH);
                if (mySorlag.isSelected()) myChampions.add(Champions.SORLAG);
                if (myStrogg.isSelected()) myChampions.add(Champions.STROGG_AND_PEEKER);
                if (myVisor.isSelected()) myChampions.add(Champions.VISOR);
                if (myDoom.isSelected()) myChampions.add(Champions.DOOM_SLAYER);

                theRecord = theRecord + myChampions.get(0).getChampionName() + "%"
                        + myChampions.get(1).getChampionName() + "%"
                        + myChampions.get(2).getChampionName()+"%";

                List<Champions> enemyChampions = new ArrayList<>();
                if (enemyRanger.isSelected()) enemyChampions.add(Champions.RANGER);
                if (enemyAnarki.isSelected()) enemyChampions.add(Champions.ANARKI);
                if (enemyAthena.isSelected()) enemyChampions.add(Champions.ATHENA);
                if (enemyBJ.isSelected()) enemyChampions.add(Champions.BJ_BLAZKOWICZ);
                if (enemyClutch.isSelected()) enemyChampions.add(Champions.CLUTCH);
                if (enemyDK.isSelected()) enemyChampions.add(Champions.DEATH_KNIGHT);
                if (enemyGalena.isSelected()) enemyChampions.add(Champions.GALENA);
                if (enemyKeel.isSelected()) enemyChampions.add(Champions.KEEL);
                if (enemyScalebearer.isSelected()) enemyChampions.add(Champions.SCALEBEARER);
                if (enemyNyx.isSelected()) enemyChampions.add(Champions.NYX);
                if (enemySlash.isSelected()) enemyChampions.add(Champions.SLASH);
                if (enemySorlag.isSelected()) enemyChampions.add(Champions.SORLAG);
                if (enemyStrogg.isSelected()) enemyChampions.add(Champions.STROGG_AND_PEEKER);
                if (enemyVisor.isSelected()) enemyChampions.add(Champions.VISOR);
                if (enemyDoom.isSelected()) enemyChampions.add(Champions.DOOM_SLAYER);

                if (win30.isSelected()) theScore = "3:0";
                if (win31.isSelected()) theScore = "3:1";
                if (win32.isSelected()) theScore = "3:2";
                if (lose03.isSelected()) theScore = "0:3";
                if (lose13.isSelected()) theScore = "1:3";
                if (lose23.isSelected()) theScore = "2:3";

                try {
                    List<String> plNames = Files.readAllLines(Paths.get(path + PLAYERS_NAMES), StandardCharsets.UTF_8);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                game.setEnemyName(playerName.getText());

                theRecord = theRecord + game.getEnemyName() + "%";
                theRecord = theRecord + game.getMap().getMapName() +"%";

                theRecord = theRecord + enemyChampions.get(0).getChampionName() + "%"
                        + enemyChampions.get(1).getChampionName() + "%"
                        + enemyChampions.get(2).getChampionName()+"%";

                theRecord = theRecord + theScore + "%comment";

                if (!playersNames.contains(playerName.getText())) {
                    try {
                        FileWriter fW2 = new FileWriter(path + PLAYERS_NAMES, true);
                        fW2.write('\n' +playerName.getText());
                        fW2.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                try {
                    FileWriter fW = new FileWriter(path + GAMES, true);
                    fW.write( '\n' + theRecord);
                    fW.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                    currentMap.clearSelection();
                    theGameScore.clearSelection();
                    playerName.setText("");

            }

        });
    }

    private void onOK() {
        // add your code here
        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        //dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String path = new File("").getAbsolutePath();
        final String rangerFile = "\\resources\\images\\champions\\ranger2.png";
        ranger = new JLabel(new ImageIcon(path+rangerFile));
        anarki = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\anarki2.png"));
        athena = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\athena2.png"));
        bj = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\bj2.png"));
        clutch = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\clutch2.png"));
        deathknight = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\deathknight2.png"));
        galena = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\galena2.png"));
        keel = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\keel2.png"));
        nyx = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\nyx2.png"));
        scalebearer = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\scalebearer2.png"));
        slash = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\slash2.png"));
        sorlag = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\sorlag2.png"));
        strogg = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\strogg2.png"));
        visor = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\visor2.png"));
        doom = new JLabel(new ImageIcon(path + "\\resources\\images\\champions\\doom2.png"));
    }
}
