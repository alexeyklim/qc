package QuakeChampions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by aliaksei_klimenka1 on 11/9/18.
 */
public class QL extends JFrame{
    private JLabel playerChampionsIcon = new JLabel(new ImageIcon("download.png"));
    private JLabel enemyPlayerChampionIcon = new JLabel(new ImageIcon("download.png"));
    private JPanel myPanel = new JPanel();
    private JTextField playerName = new JTextField("Your nick");
    private JTextField enemyPlayerName = new JTextField();



    public QL() {
        //MyHeader
        JPanel myHeader = new JPanel();
        myHeader.setBackground(new Color(22,222,37,90));
        myHeader.setBounds(0,0,640,100);

        //EnemyHeader
        JPanel enemyHeader = new JPanel();
        enemyHeader.setBackground(new Color(222, 0, 37, 80));
        enemyHeader.setBounds(641,0,1280,100);



        setSize(1280, 1024);
        setResizable(true);
        ImageIcon background_image = new ImageIcon("images.jpeg");
        Image img =background_image.getImage();
        Image temp_img = img.getScaledInstance(1280, 1024, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.add(myHeader);
        background.add(enemyHeader);

        playerChampionsIcon.setBounds(20, 20, 70, 70);
        background.add(playerChampionsIcon);
        add(playerChampionsIcon);

        enemyPlayerChampionIcon.setBounds(660, 20, 70,70);
        background.add(enemyPlayerChampionIcon);
        add(enemyPlayerChampionIcon);

        playerName.setBounds(100, 20, 120,20);
        background.add(playerName);
        add(playerName);

        enemyPlayerName.setBounds(740, 20, 120,20);
        background.add(enemyPlayerName);
        add(enemyPlayerName);

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
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},{"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},{"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},{"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},{"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},{"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"},
                {"doom", "anarki", "athena", "awoken", "3:1", "doom", "visor", "nyx"}
        };

        TableModel tableModel = new DefaultTableModel(data, columnNames);

        JTable myTable = new JTable(tableModel);
        myTable.setFillsViewportHeight(true);
        myTable.setShowGrid(true);
        myTable.getGridColor().darker();
        GamesResults gamesResults = new GamesResults(data, columnNames);

        //gamesResults.setBounds(20, 120, 400,500);
        gamesResults.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(myTable);
        //background.add(scrollPane);
        //add(gamesResults);

        scrollPane.setBounds(20, 120, 400, 500);

        background.add(scrollPane);
        add(scrollPane);


        background.setBounds(0,0,900,600);
        myPanel.add(background);
        add(myPanel);
        setVisible(true);
    }
}
