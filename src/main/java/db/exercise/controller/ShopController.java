package db.exercise.controller;

import db.exercise.dao.jdbc.payment.ShopDaoJdbc;
import db.exercise.entities.Shop;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShopController {

	@FXML
	public TableView<Shop> tableView;
	public TableColumn<Shop, String> shopTitle;
	public TableColumn<Shop, String> token;

	@FXML
	private void initialize() {
		shopTitle.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		token.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getToken()));
	}

	public void setShopDaoJdbc(ShopDaoJdbc shopDaoJdbc) {
		tableView.setItems(FXCollections.observableArrayList(shopDaoJdbc.findAll()));
	}


}
