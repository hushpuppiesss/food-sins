package main;

import main.GamePanel;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // VARIABLES
        JFrame window = new JFrame(); // creates a frame
        GamePanel gamePanel = new GamePanel();

        String frameIconPath = "/res/menu/frame icon.png";
        ImageIcon frameIcon = new ImageIcon(frameIconPath); // creating icon for the frame
        //

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // lets the user close the window when you hit x
        window.setResizable(true); // allows user to resize window
        window.setTitle("Food Sins"); /// sets title

        window.add(gamePanel); // displays everything
        window.pack(); // causes window to be sized to fit the preferred size and layouts of its subcomponents (gamepanel)
        window.setLocationRelativeTo(null); // displays window at the center of the screen
        window.setVisible(true); // can see the window

        window.setIconImage(frameIcon.getImage()); // setting the icon of the frame

        gamePanel.startGameThread();
    }
}