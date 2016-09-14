package gui.QuestionsPackage.questions;

public class currentQuestion {

	String currentQ = "", questions = "", inputs = "", outputs = "",
			constraints = "", examples = "", test_inputs = "",
			test_outputs = "";

	public String getTest_inputs() {
		return test_inputs;
	}

	public void setTest_inputs(String test_inputs) {
		this.test_inputs = test_inputs;
	}

	public String getTest_outputs() {
		return test_outputs;
	}

	public void setTest_outputs(String test_outputs) {
		this.test_outputs = test_outputs;
	}

	QuestionsPanel cp;

	public QuestionsPanel getCp() {
		return cp;
	}

	public void setCp(QuestionsPanel cp) {
		this.cp = cp;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getInputs() {
		return inputs;
	}

	public void setInputs(String inputs) {
		this.inputs = inputs;
	}

	public String getOutputs() {
		return outputs;
	}

	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}

	public String getConstraints() {
		return constraints;
	}

	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}

	public String getExamples() {
		return examples;
	}

	public void setExamples(String examples) {
		this.examples = examples;
	}

	public String getCurrentQ() {
		return currentQ;
	}

	public void setCurrentQ(String currentQ) {
		this.currentQ = currentQ;
	}

}
