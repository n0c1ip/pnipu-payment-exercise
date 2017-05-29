package db.exercise.dao.jdbc.payment;

import db.exercise.dao.mapper.payment.ClientMapper;
import db.exercise.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoJdbc {

	private static final String queryAll = "select C.id, C.name as clientName, CR.number as cardNumber,  CR.amount as amount, CR.id as cardId from cards as CR\n" +
			"join client_card as CC on CC.cardId = CR.id\n" +
			"join client as C on C.id = CC.clientId";

	private static final String queryByCard = "select C.id, C.name as clientName, CR.number as cardNumber,  CR.amount as amount, CR.id as cardId from cards as CR\n" +
			"join client_card as CC on CC.cardId = CR.id\n" +
			"join client as C on C.id = CC.clientId where CR.number = ?";

	private static final String updateCardAmount = "UPDATE `payment`.`cards` SET `amount` = ? WHERE `id` = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Client> findAll(){
		return jdbcTemplate.query(queryAll, new ClientMapper());
	}

	public List<Client> findByCard(String cardNumber){
		return jdbcTemplate.query(queryByCard, new ClientMapper(), cardNumber);
	}

	public void updateCardAmount(Long cardId, Integer amount) {
		jdbcTemplate.update(updateCardAmount, amount, cardId);
	}

}
