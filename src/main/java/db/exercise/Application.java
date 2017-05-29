package db.exercise;

import db.exercise.controller.MainController;
import db.exercise.integration.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {

    @Value("${ui.title:JavaFX приложение}")
    private String windowTitle;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void start(Stage stage) throws Exception {
        MainController mainController = new MainController();
        mainController.setPrimaryStage(stage);
        mainController.setApplicationContext(applicationContext);
        mainController.setMainWindowTitle(windowTitle);
        mainController.show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }
}