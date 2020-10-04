package objectgame;

import userinterface.GameScreen;
import utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemisManager {
    private List<Enemy> enemies;
    private Random random;

    private BufferedImage  imageCactus1, imageCactus2;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;

    public EnemisManager(MainCharacter mainCharacter, GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.mainCharacter = mainCharacter;
        enemies = new ArrayList<Enemy>();
        imageCactus1 = Resources.getResourcesImage("src/test/resources/image/cactus1.png");
        imageCactus2 = Resources.getResourcesImage("src/test/resources/image/cactus2.png");
        random = new Random();

        enemies.add(getRandomCactus());
    }

    public void update() {
        for(Enemy e : enemies) {
            e.update();
            if(e.isOver()) {
                gameScreen.plusScore(20);
            }
            if(e.getBound().intersects(mainCharacter.getBound())) {
                mainCharacter.setAlive(false);
            }
        }
        Enemy firstEnemy = enemies.get(0);
        if(firstEnemy.isOutOfScreen()) {
            enemies.remove(firstEnemy);
            enemies.add(getRandomCactus());
        }
    }

    public void draw(Graphics g) {
        for (Enemy e : enemies) {
            e.draw(g);
        }
    }


    public void reset() {
        enemies.clear();
        enemies.add(getRandomCactus());
    }


    private Cactus getRandomCactus() {
        Cactus cactus;
        cactus = new Cactus(mainCharacter);
        cactus.setX(600);

         if(random.nextBoolean()) {
            cactus.setImage(imageCactus1);
        } else {
            cactus.setImage(imageCactus2);
        }
        return cactus;
    }
}
