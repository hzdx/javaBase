package myGame.entities;

import java.util.Random;

import myGame.shapeListener.ShapeListner;

public class ShapeFactory {
	private int[][][] shapes = new int [][][]{
			{
				{	1,0,0,0,  1,1,1,0,
					0,0,0,0,  0,0,0,0	},
					
				{	1,1,0,0,  1,0,0,0,
					1,0,0,0,  0,0,0,0   },
					
				{   1,1,1,0,  0,0,1,0,
					0,0,0,0,  0,0,0,0   },
					
				{   0,1,0,0,  0,1,0,0,
					1,1,0,0,  0,0,0,0	}	
			},
			{
				{	1,1,0,0,  0,1,1,0,
					0,0,0,0,  0,0,0,0	},
					
				{	0,1,0,0,  1,1,0,0,
					1,0,0,0,  0,0,0,0   },
					
				{   1,1,0,0,  0,1,1,0,
					0,0,0,0,  0,0,0,0   },
					
				{   0,1,0,0,  1,1,0,0,
					1,0,0,0,  0,0,0,0	}	
			},
			{
				{	1,1,1,1,  0,0,0,0,
					0,0,0,0,  0,0,0,0	},
					
				{	1,0,0,0,  1,0,0,0,
					1,0,0,0,  1,0,0,0   }	
			},
			{	
				{	1,1,1,0,  0,1,0,0,
					0,0,0,0,  0,0,0,0	},
					
				{	0,1,0,0,  1,1,0,0,
					0,1,0,0,  0,0,0,0   },
					
				{   0,1,0,0,  1,1,1,0,
					0,0,0,0,  0,0,0,0   },
					
				{   1,0,0,0,  1,1,0,0,
					1,0,0,0,  0,0,0,0	}	
			},
			{
				
				{
					1,1,0,0,  1,1,0,0,
					0,0,0,0,  0,0,0,0
				}
			},
			
	};
	public Shape getShape(ShapeListner listner){
		System.out.println("ShapeFactory's getShape");
		Shape shape = new Shape();
		shape.addShapeListner(listner);
		int type = new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		shape.setStatus(0);
		return shape;
	}
}
