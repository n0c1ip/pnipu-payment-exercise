package db.exercise.dao.mapper.payment;

import db.exercise.entities.Shop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopMapper implements RowMapper<Shop> {

	@Override
	public Shop mapRow(ResultSet resultSet, int i) throws SQLException {
		Shop shop = new Shop();
		shop.setId(resultSet.getLong("id"));
		shop.setTitle(resultSet.getString("title"));
		shop.setToken(resultSet.getString("token"));
		return shop;
	}
}
