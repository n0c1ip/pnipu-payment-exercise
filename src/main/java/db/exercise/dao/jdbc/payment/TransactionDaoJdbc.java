package db.exercise.dao.jdbc.payment;

import db.exercise.dao.mapper.payment.TransactionMapper;
import db.exercise.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoJdbc {

	private static final String query = "select C.id, C.name as clientName, " +
			"S.title as shopTitle, T.amount as amount, T.orderId, T.description " +
			"from transactions as T\n" +
			"join shop as S on S.id = T.shop\n" +
			"join client_card as CC on CC.cardId = T.card\n" +
			"join client as C on C.id = CC.clientId";

	private static final String insertTransaction = "INSERT INTO `payment`.`transactions`\n" +
			"(`card`,`shop`,`amount`,`orderId`,`description`) VALUES(?,?,?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Transaction> findAll(){
		return jdbcTemplate.query(query, new TransactionMapper());
	}

	public void makeTransaction(Long cardId, Long shopId, Integer amount, String orderId, String desctiption) {
		jdbcTemplate.update(insertTransaction, cardId, shopId, amount, orderId, desctiption);
	}
}
