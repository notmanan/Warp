import java.util.LinkedList;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class parent extends Application {
	Scene mainScene;
	Group dotG;
	LinkedList<dot> dots = new LinkedList<>();
	Stage ps;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Pane p = new Pane();
		ps = arg0;
		mainScene = new Scene(p, 1000, 1000);
		mainScene.setFill(Color.BLACK);
		dotG = new Group();
		p.getChildren().add(dotG);
		ps.setScene(mainScene);
		ps.show();
		initiate();
		
		mainScene.setOnMouseMoved(e -> {
			moveDots(e);
		});
		
		mainScene.setOnMouseClicked(e -> {
			moveDots(e);
		});
		
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				returndots();
			}
		};
		
		timer.start();
	}

	protected void returndots() {
		// TODO Auto-generated method stub
		for(dot d : dots) {
			d.callBack(); 
		}
	}

	private void moveDots(MouseEvent e) {
		// TODO Auto-generated method stub
		for(dot d : dots) {
			d.offset(e);
		}
	}

	private void initiate() {
		// TODO Auto-generated method stub
//		int start = (int) (mainScene.getWidth()/2)  - (int) (mainScene.getWidth()/4);
//		int end = (int) (mainScene.getWidth()/2)  + (int) (mainScene.getWidth()/4) ;
		int border = 200;
		int start  = 0 + border;
		int end = (int) mainScene.getWidth() - border;
		int step = 7;
		for(int i = start ; i <= end ; i+=step) {
			for(int j = start ; j <= end ; j+=step) {
				dots.add(new dot(i,j));
				dotG.getChildren().add(dots.getLast().c);
			}	
		}
	}
	
}
