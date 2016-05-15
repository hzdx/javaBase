package myGame.entities;

import java.awt.Color;
import java.awt.Graphics;

import myGame.shapeListener.ShapeListner;
import myGame.util.Global;

public class Shape {

	public static final int ROTATE = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;

	private int[][] body;
	private int status;
	private ShapeListner listner;
	private int left;
	private int top;

	public void moveLeft() {
		System.out.println("Shape's moveLeft");
		left--;
	}

	public void moveRight() {
		System.out.println("Shape's moveRight");
		left++;
	}

	public void moveDown() {
		System.out.println("Shape's moveDown");
		top++;
	}

	public void rotate() {
		System.out.println("Shape's rotate");
		status = (status + 1) % body.length;
	}

	public void drawMe(Graphics g) {
		System.out.println("Shape's drawMe");
		g.setColor(Color.BLUE);
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (getFlagByPoint(x, y)) {
					g.fill3DRect((left + x) * Global.CELL_SIZE, (top + y)
							* Global.CELL_SIZE, Global.CELL_SIZE,
							Global.CELL_SIZE, true);
				}
			}
		}
	}

	private boolean getFlagByPoint(int x, int y) {
		return body[status][y * 4 + x] == 1;
	}

	public boolean isMember(int x, int y, boolean rotate) {
		int tempStatus = status;
		if (rotate) {
			tempStatus = (status + 1) % body.length;
		}
		return body[tempStatus][y * 4 + x] == 1;
	}

	private class ShapeDriver implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (listner.isShapeMoveDownable(Shape.this)) {
				moveDown();
				listner.shapeMoveDown(Shape.this);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
				}
			}
		}

	}

	public Shape() {
		new Thread(new ShapeDriver()).start();
	}

	// ×¢²á¼àÌýÆ÷
	public void addShapeListner(ShapeListner sl) {
		if (sl != null) {
			this.listner = sl;
		}
	}

	public void setBody(int body[][]) {
		this.body = body;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTop() {
		return top;
	}

	public int getLeft() {
		return left;
	}
}
