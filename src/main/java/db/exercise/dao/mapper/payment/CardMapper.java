package db.exercise.dao.mapper.payment;

import db.exercise.entities.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Card> {

	@Override
	public Card mapRow(ResultSet resultSet, int i) throws SQLException {
		Card doctor = new Card();
		doctor.setId(resultSet.getLong("id"));
		doctor.setAmount(resultSet.getInt("amount"));
		doctor.setNumber(resultSet.getString("number"));
		return doctor;
	}
}
