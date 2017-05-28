package db.exercise.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Transaction {

	private long id;
	private String clientName;
	private String shopTitle;
	private String orderId;
	private String description;
	private Integer amount;

}
