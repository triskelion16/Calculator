package application;

public class Operations {
	
	public static String changeSign(String value) {
		return String.valueOf(Integer.parseInt(value) * -1);
	}
	
	public static String percent(String value) {
		return String.valueOf((Double)Double.parseDouble(value) /100);
	}
	
	public static String sqrt(String value) throws Exception{
		if(Double.parseDouble(value) < 0) throw new Exception();
		return String.valueOf(Math.sqrt(Double.parseDouble(value)));
	}

	public static String addition(String value1, String value2) {
		return String.valueOf(Double.parseDouble(value1) + Double.parseDouble(value2));
	}
	
	public static String subtraction(String value1, String value2) {
		return String.valueOf(Double.parseDouble(value1) - Double.parseDouble(value2));
	}
	
	public static String multiplication(String value1, String value2) {
		return String.valueOf(Double.parseDouble(value1) * Double.parseDouble(value2));
	}
	
	public static String division(String value1, String value2) throws Exception { 
		if(Double.parseDouble(value2) == 0) throw new Exception();
		return String.valueOf(Double.parseDouble(value1) / Double.parseDouble(value2));
	}
}
