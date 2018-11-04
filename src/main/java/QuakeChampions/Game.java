package QuakeChampions;

public class Game {

    private Maps map;
    private String enemyName;
    private Champions my1;
    private Champions my2;
    private Champions my3;
    private Champions enemy1;
    private Champions enemy2;
    private Champions enemy3;
    private String comment;
    private String gameResult;

    public Maps getMap() {
        return map;
    }

    public void setMap(Maps map) {
        this.map = map;
    }

    public Champions getMy1() {
        return my1;
    }

    public void setMy1(Champions my1) {
        this.my1 = my1;
    }

    public Champions getMy2() {
        return my2;
    }

    public void setMy2(Champions my2) {
        this.my2 = my2;
    }

    public Champions getMy3() {
        return my3;
    }

    public void setMy3(Champions my3) {
        this.my3 = my3;
    }

    public Champions getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(Champions enemy1) {
        this.enemy1 = enemy1;
    }

    public Champions getEnemy2() {
        return enemy2;
    }

    public void setEnemy2(Champions enemy2) {
        this.enemy2 = enemy2;
    }

    public Champions getEnemy3() {
        return enemy3;
    }

    public void setEnemy3(Champions enemy3) {
        this.enemy3 = enemy3;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public boolean amIwin() {
        return gameResult.startsWith("3");
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
}
