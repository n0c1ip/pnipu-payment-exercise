package db.exercise.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Card {

	private long id;
	private String number;
	private Integer amount;

}
