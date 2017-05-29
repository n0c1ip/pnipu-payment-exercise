package db.exercise.controller;


import db.exercise.dao.jdbc.payment.ClientDaoJdbc;
import db.exercise.dao.jdbc.payment.ShopDaoJdbc;
import db.exercise.dao.jdbc.payment.TransactionDaoJdbc;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class RootController {

	private MainController mainController;
	private TabPane tabLayout;
	private ApplicationContext applicationContext;


	public void showClientsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/clients.fxml"));
			Pane table = loader.load();
			ClientController controller = loader.getController();
			controller.setSchedulerDaoJdbc(applicationContext.getBean(ClientDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Клиенты");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showShopTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/shops.fxml"));
			Pane table = loader.load();
			ShopController controller = loader.getController();
			controller.setShopDaoJdbc(applicationContext.getBean(ShopDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Терминалы");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showTransactionTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/transactions.fxml"));
			Pane table = loader.load();
			TransactionController controller = loader.getController();
			controller.setShopDaoJdbc(applicationContext.getBean(TransactionDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Транзакции");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void closeAllTabs(){
		tabLayout.getTabs().remove(0, tabLayout.getTabs().size());

	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}


}


