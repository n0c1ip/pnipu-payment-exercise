package db.exercise.controller;

import javafx.scene.control.TextArea;

public class ResultCardController {

	public TextArea resultText;

	public void setResultText(String resultText) {
		this.resultText.setText(resultText.replace("\\n", System.lineSeparator()));
		this.resultText.setEditable(false);
	}

}
