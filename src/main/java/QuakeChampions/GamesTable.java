package QuakeChampions;

import javax.swing.*;
import java.awt.*;

public class GamesTable extends JFrame {
    JTable GamesTable;

    public GamesTable() {
        setLayout(new FlowLayout());

        String[] columnNames = {"My1", "My2", "My3", "MAP", "Enemy1", "Enemy2", "Enemy3", "Result", "Comment"};
        Object[][] data = {};
        GamesTable = new JTable(data, columnNames);
        GamesTable.setPreferredScrollableViewportSize(new Dimension(500,50));
        GamesTable.setFillsViewportHeight(true);
        JScrollPane scrollPage = new JScrollPane(GamesTable);
        add(scrollPage);
    }
}
