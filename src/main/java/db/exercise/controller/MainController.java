package db.exercise.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class MainController {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ApplicationContext applicationContext;

	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/root.fxml"));
			rootLayout = loader.load();
			RootController rootController = loader.getController();
			rootController.setApplicationContext(applicationContext);
			rootController.setMainController(this);
			primaryStage.setScene(new Scene(rootLayout));
			primaryStage.show();

		} catch (IOException e) {
			e.getMessage();
		}
	}

	private void initTabLayout() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/tabPane.fxml"));
			TabPane tabPane = loader.load();
			rootLayout.setCenter(tabPane);
		} catch (IOException e) {
		}
	}

	public void setMainWindowTitle(String title){
		this.primaryStage.setTitle(title);
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void show() {
		initRootLayout();
		initTabLayout();
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
