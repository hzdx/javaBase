package myGame.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import myGame.entities.Ground;
import myGame.entities.Shape;
import myGame.util.Global;

public class GamePanel extends JPanel {
	private Shape shape;
	private Ground ground;

	public void display(Ground ground, Shape shape) {
		System.out.println("GamePanel's display");
		this.ground = ground;
		this.shape = shape;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub ÷ÿ–¬œ‘ æ
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.CELL_SIZE * Global.WIDTH, Global.CELL_SIZE
				* Global.HEIGHT);
		if (shape != null && ground != null) {
			shape.drawMe(g);
			ground.drawMe(g);
		}
	}

	public GamePanel() {
		this.setSize(Global.CELL_SIZE * Global.WIDTH, Global.CELL_SIZE
				* Global.HEIGHT);
	}
}
