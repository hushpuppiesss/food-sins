package main;

import main.GamePanel;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // lets the user close the window when you hit x
        window.setResizable(true); // allows user to resize window
        window.setTitle("Food Sins");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // causes window to be sized to fit the preferred size and layouts of its subcomponents (gamepanel)

        window.setLocationRelativeTo(null); // displays window at the center of the screen
        window.setVisible(true); // can see the window

        gamePanel.startGameThread();
    }
}