package db.exercise;

import db.exercise.dao.jdbc.payment.ClientDaoJdbc;
import db.exercise.dao.jdbc.payment.ShopDaoJdbc;
import db.exercise.dao.jdbc.payment.TransactionDaoJdbc;
import db.exercise.entities.Client;
import db.exercise.entities.Response;
import db.exercise.entities.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

	@Autowired
	private ShopDaoJdbc shopDaoJdbc;

	@Autowired
	private ClientDaoJdbc clientDaoJdbc;

	@Autowired
	private TransactionDaoJdbc transactionDaoJdbc;


	@RequestMapping(value = "/rest/payment", method = RequestMethod.GET)
	public Response payment(@RequestParam(value="token") String token,
							@RequestParam(value = "cardNumber") String cardNumber,
							@RequestParam(value="amount") Integer amount,
							@RequestParam(value="orderId") String orderId,
							@RequestParam(value="description", required = false) String description) {

		List<Shop> shopList = shopDaoJdbc.findByToken(token);
		if(shopList.isEmpty()) {
			return new Response("Неверный ключ терминала", HttpStatus.BAD_REQUEST);
		}

		Shop shop = shopList.get(0);

		List<Client> clientList = clientDaoJdbc.findByCard(cardNumber);
		if(clientList.isEmpty()) {
			return new Response("Неверный номер карты", HttpStatus.BAD_REQUEST);
		}

		Client client = clientList.get(0);

		if (client.getAmount() < amount) {
			return new Response("Недостаточно средств для оплаты", HttpStatus.BAD_REQUEST);
		}

		clientDaoJdbc.updateCardAmount(client.getCardId(), client.getAmount() - amount);
		transactionDaoJdbc.makeTransaction(client.getCardId(), shop.getId(),amount,orderId,description);

		return new Response("Оплата произведена",HttpStatus.OK);

	}

}
