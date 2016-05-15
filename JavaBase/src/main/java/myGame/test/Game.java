package myGame.test;

import javax.swing.JFrame;

import myGame.controller.Controller;
import myGame.entities.Ground;
import myGame.entities.ShapeFactory;
import myGame.view.GamePanel;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory shapeFactory = new ShapeFactory();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(shapeFactory,
				ground,gamePanel);
		JFrame frame = new JFrame("¶íÂÞË¹·½¿é");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(gamePanel.getSize().width+10, gamePanel.getSize().height+35);
		frame.add(gamePanel);
		gamePanel.addKeyListener(controller);
		
		frame.addKeyListener(controller);
		frame.setVisible(true);
		controller.newGame();
	}

}
