package db.exercise.controller;

import db.exercise.dao.jdbc.payment.TransactionDaoJdbc;
import db.exercise.entities.Transaction;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransactionController {

	@FXML
	public TableView<Transaction> tableView;
	public TableColumn<Transaction, String> clientName;
	public TableColumn<Transaction, String> shopTitle;
	public TableColumn<Transaction, Integer> amount;
	public TableColumn<Transaction, String> orderId;
	public TableColumn<Transaction, String> description;

	@FXML
	private void initialize() {
		clientName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getClientName()));
		shopTitle.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getShopTitle()));
		orderId.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getOrderId()));
		description.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDescription()));
		amount.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAmount()));
	}

	public void setShopDaoJdbc(TransactionDaoJdbc transactionDaoJdbc) {
		tableView.setItems(FXCollections.observableArrayList(transactionDaoJdbc.findAll()));
	}

}
