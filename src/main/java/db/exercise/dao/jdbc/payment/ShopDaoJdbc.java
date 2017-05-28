package db.exercise.dao.jdbc.payment;

import db.exercise.dao.mapper.payment.ShopMapper;
import db.exercise.entities.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoJdbc {

	private static final String queryAll = "select * from shop";
	private static final String query = "select * from shop where token = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Shop> findAll(){
		return jdbcTemplate.query(queryAll, new ShopMapper());
	}


	public List<Shop> findByToken(String token){
		return jdbcTemplate.query(query, new ShopMapper(), token);
	}

}
