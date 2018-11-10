package QuakeChampions;

import QuakeChampions.actions.GetDataFromApi;
import QuakeChampions.json.playerstats.Stats;
import QuakeChampions.util.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by aliaksei_klimenka1 on 11/9/18.
 */
public class QL extends JFrame{

    private JPanel myPanel = new JPanel();
    //PLAYERS INFO
    private JLabel playerChampionsIcon = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "doom.png"));
    private JLabel enemyPlayerChampionIcon = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "doom.png"));
    //rate
    private JLabel playerRate = new JLabel(new ImageIcon(new File("").getAbsolutePath() + "\\resources\\images\\rate\\Elite_01.png"));
    private JLabel enemyPlayerRate = new JLabel(new ImageIcon(new File("").getAbsolutePath() + "\\resources\\images\\rate\\Elite_01.png"));
    //fields
    private JTextField playerName = new JTextField("Your nick");
    private JTextField enemyPlayerName = new JTextField();
    private JTextField playerRateField = new JTextField("Rating:");
    //search button:
    private JButton searchByPlayerName = new JButton(">");
    private JButton searchByEnemyName = new JButton(">");

    //maps:
    private JLabel awoken_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "awoken.jpg"));
    private JLabel blood_covenant_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "blood_covenant.jpg"));
    private JLabel blood_run_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "blood_run.jpg"));
    private JLabel corrupted_keep_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "corrupted_keep.jpg"));
    private JLabel ruins_of_sarnath_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "ruins_of_sarnath.jpg"));
    private JLabel the_molten_falls_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "the_molten_falls.jpg"));
    private JLabel vale_of_pnath_map = new JLabel(new ImageIcon(Config.MAPS_IMAGES_PATH + "vale_of_pnath.jpg"));

    //champions
    private JLabel anarki = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "anarki_mini.png"));
    private JLabel athena = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "athena_mini.png"));
    private JLabel bj  = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "bj_mini.png"));
    private JLabel clutch = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "clutch_mini.png"));
    private JLabel deathknight = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "deathknight_mini.png"));
    private JLabel doom = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "doom_mini.png"));
    private JLabel galena = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "galena_mini.png"));
    private JLabel keel = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "keel_mini.png"));
    private JLabel nyx = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "nyx_mini.png"));
    private JLabel ranger = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "ranger.png"));
    private JLabel scalebearer = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "scalebearer_mini.png"));
    private JLabel slash = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "slash_mini.png"));
    private JLabel sorlag = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "sorlag_mini.png"));
    private JLabel strogg = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "strogg_mini.png"));
    private JLabel visor = new JLabel(new ImageIcon(Config.CHAMPION_IMAGES_PATH + "visor_mini.png"));

    public QL() {
        //MyHeader
        JPanel myHeader = new JPanel(); myHeader.setBackground(new Color(22,222,37,50)); myHeader.setBounds(0,0,640,100);
        //EnemyHeader
        JPanel enemyHeader = new JPanel(); enemyHeader.setBackground(new Color(222, 0, 37, 50)); enemyHeader.setBounds(641,0,1280,100);
        //MapsBackPlate
        JPanel mapsBackplate = new JPanel(); mapsBackplate.setBackground(new Color(150, 200, 220, 50)); mapsBackplate.setBounds(10, 110, 160, 650);
        //ChampionsBackPlate
        JPanel championsBackplate = new JPanel(); championsBackplate.setBackground(new Color(20, 200, 150, 50 )); championsBackplate.setBounds(590, 110, 100, 700);


        setSize(1280, 1024);
        setResizable(false);
        ImageIcon background_image = new ImageIcon(Config.CHAMPION_IMAGES_PATH + "Quake-Champions.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1280, 800, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.add(myHeader);
        background.add(enemyHeader);
        background.add(mapsBackplate);
        background.add(championsBackplate);

        playerChampionsIcon.setBounds(20, 20, 70, 70); background.add(playerChampionsIcon); add(playerChampionsIcon);
        playerRate.setBounds(95, 70, 32,32); background.add(playerRate); add(playerRate);
        playerRateField.setBounds(130, 50, 90, 20); add(playerRateField); playerRateField.setEditable(false);
        playerName.setBounds(100, 25, 120,20); background.add(playerName); add(playerName);
        searchByPlayerName.setMargin(new Insets(0,0,0,0));
        searchByPlayerName.setBounds(230, 25, 20, 20); background.add(searchByPlayerName); add(searchByPlayerName);

        enemyPlayerChampionIcon.setBounds(660, 20, 70,70); background.add(enemyPlayerChampionIcon); add(enemyPlayerChampionIcon);
        enemyPlayerRate.setBounds(735, 70,32,32); background.add(enemyPlayerRate); add(enemyPlayerRate);
        enemyPlayerName.setBounds(740, 25, 120,20); background.add(enemyPlayerName); add(enemyPlayerName);
        searchByEnemyName.setMargin(new Insets(0,0,0,0));
        searchByEnemyName.setBounds(870, 25, 20, 20); add(searchByEnemyName);


        //maps
        awoken_map.setBounds(20, 120, 125, 70); background.add(awoken_map); add(awoken_map);
        blood_covenant_map.setBounds(20, 200, 125, 70); background.add(blood_covenant_map); add(blood_covenant_map);
        blood_run_map.setBounds(20, 280, 125, 70); background.add(blood_run_map); add(blood_run_map);
        corrupted_keep_map.setBounds(20, 360, 125, 70); background.add(corrupted_keep_map); add(corrupted_keep_map);
        ruins_of_sarnath_map.setBounds(20, 440, 125, 70); background.add(ruins_of_sarnath_map); add(ruins_of_sarnath_map);
        the_molten_falls_map.setBounds(20, 520, 125, 70); background.add(the_molten_falls_map); add(the_molten_falls_map);
        vale_of_pnath_map.setBounds(20, 600, 125, 70); background.add(vale_of_pnath_map); add(vale_of_pnath_map);


        //champions
        anarki.setBounds(627, 120, 35,35); background.add(anarki); add(anarki);
        athena.setBounds(627, 160, 35,35); background.add(athena); add(athena);
        bj.setBounds(627, 200, 35,35); background.add(bj); add(bj);
        clutch.setBounds(627, 240, 35,35); background.add(clutch); add(clutch);
        deathknight.setBounds(627, 280, 35,35); background.add(deathknight); add(deathknight);
        doom.setBounds(627, 320, 35,35); background.add(doom); add(doom);
        galena.setBounds(627, 360, 35,35); background.add(galena); add(galena);
        keel.setBounds(627, 400, 35,35); background.add(keel); add(keel);
        nyx.setBounds(627, 440, 35,35); background.add(nyx); add(nyx);
        ranger.setBounds(627, 480, 35,35); background.add(ranger); add(ranger);
        scalebearer.setBounds(627, 520, 35,35); background.add(scalebearer); add(scalebearer);
        slash.setBounds(627, 560, 35,35); background.add(slash); add(slash);
        sorlag.setBounds(627, 600, 35,35); background.add(sorlag); add(sorlag);
        strogg.setBounds(627, 640, 35,35); background.add(strogg); add(strogg);
        visor.setBounds(627, 680, 35,35); background.add(visor); add(visor);


        String[] columnNames = {"cpn1", "cpn2", "cpn3", "map", "score", "enemy1", "enemy2", "enemy3"};

        Object[][] data = {
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"}
        };

        TableModel tableModel = new DefaultTableModel(data, columnNames);

        JTable myTable = new JTable(tableModel);
        myTable.setFillsViewportHeight(true);
        myTable.setShowGrid(true);
        myTable.getGridColor().darker();
        JScrollPane scrollPane = new JScrollPane(myTable);

        scrollPane.setBounds(820, 120, 450, 400);

        background.add(scrollPane);
        add(scrollPane);


        background.setBounds(0,0,900,600);
        myPanel.add(background);
        add(myPanel);
        setVisible(true);


        ////////WINDOW LOGIC

        searchByPlayerName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            GetDataFromApi getDataFromApi = new GetDataFromApi();
            Stats myStats = getDataFromApi.getStatsByPlayerName(playerName.getText());
            playerRateField.setText("Rating: " + myStats.getPlayerRatings().getDuel().getRating());


            }
        });
    }

    public void refresh() {


    }
}
