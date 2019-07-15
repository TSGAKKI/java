package module.view;

import javafx.application.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.*;

public class ListDemo extends Application {
	private String[] flagTitle= {
		"Can","china","Denmark"	
	};
	private String[] Info= {
		"1","2","3"	
	};
//	private ImageView[] imview= {
//			new ImageView("tabBkg.gif"),
//			new ImageView("tabBkg.png"),
//			new ImageView("tabBkg.png")
//	};
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		ListView<String>lv=new ListView<>(FXCollections.observableArrayList(flagTitle));
		lv.setPrefSize(400, 400);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		FlowPane imag=new FlowPane(10,10);
		BorderPane pane=new BorderPane();
		pane.setLeft(new ScrollPane(lv));
		pane.setCenter(imag);
		
//		lv.getSelectionModel().selectedItemProperty().addListener(ov->{
//			imag.getChildren().clear();
//			for(Integer i:lv.getSelectionModel().getSelectedIndices()) {
//				imag.getChildren().add(Info[i]);
//			}
//		});
		Scene scene=new Scene(pane,450,170);
		primaryStage.setTitle("ListView");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
