package application;

public class Operations {

	public static String addition(String value1, String value2) {
		return String.valueOf(Integer.parseInt(value1) + Integer.parseInt(value2));
	}
	
	public static String subtraction(String value1, String value2) {
		return String.valueOf(Integer.parseInt(value1) - Integer.parseInt(value2));
	}
	
	public static String multiplication(String value1, String value2) {
		return String.valueOf(Integer.parseInt(value1) * Integer.parseInt(value2));
	}
	
	public static String division(String value1, String value2) { // dzielenie przez zero obsłużone w servlecie -> erroe.jsp
		return String.valueOf(Integer.parseInt(value1) / Integer.parseInt(value2));
	}
}
