package main;

import userinterface.GameScreen;

import javax.swing.*;

public class Main extends JFrame{

    private GameScreen gameScreen;

    public Main() {
        super("Java T-Rex game");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
    }

    public void startGame() {
        gameScreen.startGame();
    }

    public static void main(String args[]) {
        Main gw = new Main();
        gw.setVisible(true);
        gw.startGame();
    }
}
