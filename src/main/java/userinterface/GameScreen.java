package userinterface;

import objectgame.*;
import utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameScreen  extends JPanel implements  Runnable, KeyListener {
    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;

    public static  final float GRAVITY = 0.1f;
    public static  final float GROUND = 250;

    private final MainCharacter mainCharacter;
    private final Thread thread;
    private Land land;
    private Clounds clounds;
    private EnemisManager enemisManager;
    private int score = 0;
    private MENU menu;

    private  int gameState = GAME_FIRST_STATE;

    private BufferedImage imageGameOverText;
    private boolean sounds = false;

    public static  boolean pressMouse = false;


    public static enum STATE {
        MENU,
        GAME
    };

    public static STATE State = STATE.MENU;


    public static void setPressMouse(boolean g) {
        pressMouse = g;
    }


    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50);
        mainCharacter.setY(60);
        land = new Land(this);
        clounds = new Clounds();
        enemisManager = new EnemisManager(mainCharacter, this);
        imageGameOverText = Resources.getResourcesImage("src/test/resources/image/gameover_text.png");
        menu = new MENU();

        this.addMouseListener(new MouseInput());
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                update();
                repaint();
                Thread.sleep(9);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void update() {
        switch (gameState) {
            case GAME_PLAY_STATE:
                mainCharacter.update();
                clounds.update();
                land.update();
                enemisManager.update();
                if(!mainCharacter.getAlive()) {
                    gameState = GAME_OVER_STATE;
                }
                break;
        }
    }
    public void plusScore(int score)  {
        this.score += score;
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(0,0, getWidth(), getHeight());

            switch (gameState) {
                case GAME_FIRST_STATE:
                    menu.render(g);
                    if (pressMouse == true) {
                        if (gameState == GAME_FIRST_STATE) {
                            gameState = GAME_PLAY_STATE;
                        } else if (gameState == GAME_PLAY_STATE) {
                            mainCharacter.jump();
                        } else if (gameState == GAME_OVER_STATE) {
                            gameState = GAME_PLAY_STATE;
                            resetGame();
                        }
                        break;
                    }
                    break;
                case GAME_PLAY_STATE:
                        if (!sounds)
                            sounds = true;
                        clounds.draw(g);
                        land.draw(g);
                        mainCharacter.draw(g);
                        enemisManager.draw(g);
                        g.drawString("Score " + String.valueOf(score), 500, 20);
                        break;
                case GAME_OVER_STATE:
                    score = 0;
                    clounds.draw(g);
                    land.draw(g);
                    mainCharacter.draw(g);
                    enemisManager.draw(g);
                    g.drawImage(imageGameOverText, 200, 80,
                            null);
                    if (sounds) {
                        mainCharacter.SoundClip("src/test/resources/image/dd.wav");
                        sounds = false;
                    }
                    break;
            }
    }

    private void resetGame() {
        mainCharacter.setAlive(true);
        mainCharacter.setX(50);
        mainCharacter.setY(60);
        enemisManager.reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (pressMouse == true) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    if (gameState == GAME_FIRST_STATE) {
                        gameState = GAME_PLAY_STATE;
                    } else if (gameState == GAME_PLAY_STATE) {
                        mainCharacter.jump();
                    } else if (gameState == GAME_OVER_STATE) {
                        gameState = GAME_PLAY_STATE;
                        resetGame();
                    }
                    break;
            }
        }
    }
}

