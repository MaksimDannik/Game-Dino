package objectgame;

import utils.Animation;
import utils.Resources;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

import static userinterface.GameScreen.GRAVITY;
import static userinterface.GameScreen.GROUND;

public class MainCharacter  {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation characterRun;
    private Animation characterRun1;

    private Rectangle rect;
    private  boolean isAlive = true;

    public MainCharacter() {
        characterRun = new Animation();
        characterRun1 = new Animation();

        characterRun.addFrame(Resources.getResourcesImage("/Users/mdannyk/IdeaProjects/untitled/src/test/resources/image/1.png"));
        characterRun.addFrame(Resources.getResourcesImage("/Users/mdannyk/IdeaProjects/untitled/src/test/resources/image/1.2.png"));
        characterRun1.addFrame(Resources.getResourcesImage("/Users/mdannyk/IdeaProjects/untitled/src/test/resources/image/scout.png"));
        rect = new Rectangle();
    }



    public void update() {
        characterRun.update();

        if (y >= GROUND - characterRun.getFrame().getHeight()) {
            speedY = 0;
            y = GROUND - characterRun.getFrame().getHeight();
        }
        else {
            speedY += GRAVITY;
            y += speedY;
        }
        rect.x = (int) x;
        rect.y = (int) y;
        rect.width = characterRun.getFrame().getWidth();
        rect.height = characterRun.getFrame().getHeight();
    }

    public  Rectangle getBound() {
        return rect;
    }


    public void draw(Graphics g) {
        g.setColor(Color.black);
        if (y < 150) {
            g.drawImage(characterRun1.getFrame(), (int) x, (int) y, null);
        }
        else
            g.drawImage(characterRun.getFrame(), (int) x, (int) y, null);

    }

    public void jump() {
        if (speedY == 0) {
            speedY = -5;
            y += speedY;
            SoundClip("src/test/resources/image/j.wav");
        }
    }


    public void SoundClip(String s) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(s));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }

    public float getX() {
        return  x;
    }

    public void setX(float x) {
        this.x = x;
    }


    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean getAlive() {
        return isAlive;
    }
}
