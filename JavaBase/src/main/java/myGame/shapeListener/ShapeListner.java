package myGame.shapeListener;

import myGame.entities.Shape;

public interface ShapeListner {
	void shapeMoveDown(Shape shape);
	
	boolean isShapeMoveDownable(Shape shape);
}

