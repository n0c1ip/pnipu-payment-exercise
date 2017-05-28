package db.exercise.dao.mapper.payment;

import db.exercise.entities.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
		Transaction transaction = new Transaction();
		transaction.setId(resultSet.getLong("id"));
		transaction.setClientName(resultSet.getString("clientName"));
		transaction.setShopTitle(resultSet.getString("shopTitle"));
		transaction.setOrderId(resultSet.getString("orderId"));
		transaction.setDescription(resultSet.getString("description"));
		transaction.setAmount(resultSet.getInt("amount"));
		return transaction;
	}
}
