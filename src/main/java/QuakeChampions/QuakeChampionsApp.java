package QuakeChampions;

import QuakeChampions.util.Autocomplete;
import QuakeChampions.util.SearchGames;

import javax.swing.*;
import java.awt.*;
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
//    private JRadioButton radioButton1;
//    private JRadioButton radioButton2;
//    private JRadioButton radioButton3;
//    private JRadioButton radioButton4;
//    private JRadioButton radioButton5;
//    private JRadioButton radioButton6;
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
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    private JCheckBox checkBox13;
    private JCheckBox checkBox14;
    private JCheckBox checkBox15;
    private JCheckBox checkBox16;
    private JCheckBox checkBox17;
    private JCheckBox checkBox18;
    private JCheckBox checkBox19;
    private JCheckBox checkBox20;
    private JCheckBox checkBox21;
    private JCheckBox checkBox22;
    private JCheckBox checkBox23;
    private JCheckBox checkBox24;
    private JCheckBox checkBox25;
    private JCheckBox checkBox26;
    private JCheckBox checkBox27;
    private JCheckBox checkBox28;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private static final String COMMIT_ACTION = "commit";
    public List<String> playersNames;
    public List<Game> games;

    public QuakeChampionsApp(final List<String> playersNames){


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
                if (e.paramString().contains("keyChar=Enter")) {
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
                        awoken_score.setText(awokenWin+ ":" +awokenLose);
                    } else {awoken_score.setText("n/a");}
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("dm6")) {
                        if (games.get(i).amIwin()) {dm6Win=dm6Win+1;} else {dm6Lose=dm6Lose+1;}
                        dm6_score.setText(dm6Win+ ":" +dm6Lose);
                    } else {dm6_score.setText("n/a");}
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("ztn")) {
                        if (games.get(i).amIwin()) {ztnWin=ztnWin+1;} else {ztnLose=ztnLose+1;}
                        ztn_score.setText(ztnWin+ ":" +ztnLose);
                    } else {ztn_score.setText("n/a");}
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("corrupted")) {
                        if (games.get(i).amIwin()) {corruptedWin=corruptedWin+1;} else {corruptedLose=corruptedLose+1;}
                        corrupted_score.setText(corruptedWin+ ":" + corruptedLose);
                    } else {corrupted_score.setText("n/a");}
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("molten")) {
                        if (games.get(i).amIwin()) {moltenWin=moltenWin+1;} else {moltenLose=moltenLose+1;}
                        molten_score.setText(moltenWin+ ":" +moltenLose);
                    } else {molten_score.setText("n/a");}
                    if(games.get(i).getMap().getMapName().equalsIgnoreCase("vale")) {
                        if (games.get(i).amIwin()) {valeWin=valeWin+1;} else {valeLose=valeLose+1;}
                        vale_score.setText(valeWin+ ":" +valeLose);
                    } else {vale_score.setText("n/a");}
                }

            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String PLAYERS_NAMES = "\\resources\\files\\names";
                final String GAMES = "\\resources\\files\\games";
                String path = new File("").getAbsolutePath();

                try {
                    List<String> plNames = Files.readAllLines(Paths.get(path + PLAYERS_NAMES), StandardCharsets.UTF_8);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                if (playersNames.contains(playerName.getText())) {
                //логика для отображения статистики
                } else {
                    try {
                        FileWriter fW = new FileWriter(path + "\\resources\\files\\" + playerName.getText());
                        fW.write("");
                        fW.close();
                        FileWriter fW2 = new FileWriter(path + PLAYERS_NAMES, true);
                        fW2.write('\n' +playerName.getText());
                        fW2.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

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
        final String rangerFile = "\\resources\\images\\ranger2.png";
        ranger = new JLabel(new ImageIcon(path+rangerFile));
        anarki = new JLabel(new ImageIcon(path + "\\resources\\images\\anarki2.png"));
        athena = new JLabel(new ImageIcon(path + "\\resources\\images\\athena2.png"));
        bj = new JLabel(new ImageIcon(path + "\\resources\\images\\bj2.png"));
        clutch = new JLabel(new ImageIcon(path + "\\resources\\images\\clutch2.png"));
        deathknight = new JLabel(new ImageIcon(path + "\\resources\\images\\deathknight2.png"));
        galena = new JLabel(new ImageIcon(path + "\\resources\\images\\galena2.png"));
        keel = new JLabel(new ImageIcon(path + "\\resources\\images\\keel2.png"));
        nyx = new JLabel(new ImageIcon(path + "\\resources\\images\\nyx2.png"));
        scalebearer = new JLabel(new ImageIcon(path + "\\resources\\images\\scalebearer2.png"));
        slash = new JLabel(new ImageIcon(path + "\\resources\\images\\slash2.png"));
        sorlag = new JLabel(new ImageIcon(path + "\\resources\\images\\sorlag2.png"));
        strogg = new JLabel(new ImageIcon(path + "\\resources\\images\\strogg2.png"));
        visor = new JLabel(new ImageIcon(path + "\\resources\\images\\visor2.png"));
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//
//        String path = new File("").getAbsolutePath();
//        final String rangerFile = "\\resources\\images\\ranger2.png";
////        ranger = new JLabel(new ImageIcon(path+rangerFile));
////        anarki = new JLabel(new ImageIcon(path + "\\resources\\images\\anarki2.png"));
////
////
////
////
////
////
////
////
////        slash = new JLabel(new ImageIcon(path + "\\resources\\images\\slash2.png"));
////
////        strogg = new JLabel(new ImageIcon(path + "\\resources\\images\\strogg2.png"));
////        visor = new JLabel(new ImageIcon(path + "\\resources\\images\\visor2.png"));
//
//
//    }
}
