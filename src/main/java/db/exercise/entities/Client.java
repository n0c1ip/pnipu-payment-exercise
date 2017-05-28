package db.exercise.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Client {

	private long id;
	private String name;
	private String cardNumber;
	private long cardId;
	private Integer amount;

}
