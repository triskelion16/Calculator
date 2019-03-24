package application;

public class Calculator {
	private String operation;
	private String result;
	
	public Calculator() {
		result = "";
		operation = "";
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
