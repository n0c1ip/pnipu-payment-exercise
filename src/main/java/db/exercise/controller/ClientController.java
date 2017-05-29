package db.exercise.controller;

import db.exercise.dao.jdbc.payment.ClientDaoJdbc;
import db.exercise.entities.Client;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientController {

	@FXML
	public TableView<Client> tableView;
	public TableColumn<Client, String> name;
	public TableColumn<Client, String> cardNumber;
	public TableColumn<Client, Integer> amount;

	@FXML
	private void initialize() {
		name.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getName()));
		cardNumber.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCardNumber()));
		amount.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAmount()));
	}

	public void setSchedulerDaoJdbc(ClientDaoJdbc clientDaoJdbc) {
		tableView.setItems(FXCollections.observableArrayList(clientDaoJdbc.findAll()));
	}


}
