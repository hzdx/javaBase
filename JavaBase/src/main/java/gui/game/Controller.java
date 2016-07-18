package gui.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements ShapeListner {

	private Shape shape;
	private ShapeFactory shapeFactory;
	private Ground ground;
	private GamePanel gamePanel;

	public Controller(ShapeFactory shapeFactory, Ground ground, GamePanel gamePanel) {
		this.shapeFactory = shapeFactory;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	@Override
	public synchronized boolean isShapeMoveDownable(Shape shape) {
		if (this.shape != shape)
			return false;
		if (ground.isMoveable(shape, Shape.DOWN))
			return true;
		ground.accept(this.shape);
		if (!ground.isFull())
			this.shape = shapeFactory.getShape(this);
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (ground.isMoveable(shape, Shape.ROTATE))
				shape.rotate();
			break;

		case KeyEvent.VK_DOWN:
			if (isShapeMoveDownable(shape))
				shape.moveDown();
			break;

		case KeyEvent.VK_LEFT:
			if (ground.isMoveable(shape, Shape.LEFT))
				shape.moveLeft();
			break;

		case KeyEvent.VK_RIGHT:
			if (ground.isMoveable(shape, Shape.RIGHT))
				shape.moveRight();
			break;
		}
		gamePanel.display(ground, shape);
	}

	public void newGame() {
		shape = shapeFactory.getShape(this);
	}

	@Override
	public void shapeMoveDown(Shape shape) {
		gamePanel.display(ground, shape);
	}
}
