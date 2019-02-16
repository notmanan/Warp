import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class dot {
	Circle c;
	double initialx;
	double initialy;
	double initialr;
	double currx;
	double curry;
	double currr;

	public dot(double a, double b) {
		initialx = a;
		initialy = b;
//		initialr = Math.random() * 3;
		initialr = Math.min(a/b, b/a)*3;
		c = new Circle(initialx, initialy, initialr);
		Color color = new Color(initialx / 1200, initialy / 1200, 1, 1);
		getValues();
		c.setFill(color);
	}

	public void offset(MouseEvent e) {
		// TODO Auto-generated method stub
		getValues();
		double mouseX = e.getX();
		double mouseY = e.getY();
		double dist = Math.sqrt((Math.pow(currx - mouseX, 2)) + ((Math.pow(curry - mouseY, 2))));

		double xDist = mouseX - currx;
		double yDist = mouseY - curry;
		double k = 1000;
//		double force = (k / currr) / (dist*dist) * (dist > 0 ? 1 : -1);
		double force = (k / currr) / (dist*dist);
		double tempx = xDist * force;
		double tempy = yDist * force;
		double tempr = 0;


		currx -= tempx;
		curry -= tempy;
		currr += tempr;
		implementValues();
	}

	public void callBack() {
		// TODO Auto-generated method stub
		double accelerate = 0.005*(currr*currr);
		currx += (initialx - currx) * accelerate;
		curry += (initialy - curry) * accelerate;
		currr += (initialr - currr) * accelerate;
		implementValues();
	}

	public void implementValues() {
		c.setCenterX(currx);
		c.setCenterY(curry);
		c.setRadius(currr);
		double c1 = Math.abs(currx/ 1200);
		double c2 = Math.abs(curry/ 1200);
		Color color = new Color(c1>1?1:c1,c2>1?1:c2 , 1, 1);
		c.setFill(color);
	}

	public void getValues() {
		currx = c.getCenterX();
		curry = c.getCenterY();
		currr = c.getRadius();
	}

}
