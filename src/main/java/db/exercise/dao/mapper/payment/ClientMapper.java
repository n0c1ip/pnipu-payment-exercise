package db.exercise.dao.mapper.payment;


import db.exercise.entities.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet resultSet, int i) throws SQLException {
		Client client = new Client();
		client.setId(resultSet.getLong("id"));
		client.setName(resultSet.getString("clientName"));
		client.setCardId(resultSet.getLong("cardId"));
		client.setCardNumber(resultSet.getString("cardNumber"));
		client.setAmount(resultSet.getInt("amount"));
		return client;
	}
}
