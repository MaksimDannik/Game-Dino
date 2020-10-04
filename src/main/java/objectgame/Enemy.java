package objectgame;

import java.awt.*;

public abstract class Enemy {
    public abstract Rectangle getBound();
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract boolean isOutOfScreen();
    public abstract boolean isOver();
//    public abstract boolean isIsScoreGot();
//    public abstract boolean setIsScooreGot();
}

