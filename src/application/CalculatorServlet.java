package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean newNumber = false;

	/*============ do GET ============= */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Calculator calculator = (Calculator) session.getAttribute("object");
		
		if(calculator == null) {
			session.setAttribute("object", new Calculator());
			calculator = (Calculator) session.getAttribute("object");
		} else {
			if(request.getParameter("btn") != null) {
				
				try { // jeśli niepoprawne działanie to ERROR
					
					try { // sprawdzenie czy została przesłana cyfra
						int number = Integer.parseInt(request.getParameter("btn"));
						
						if(newNumber) {
							calculator.setResult(String.valueOf(number));
							newNumber = false;
						} else {
							calculator.setResult(calculator.getResult() + String.valueOf(number));
						}
					} catch (Exception e) {
						
						switch (request.getParameter("btn")) {
						case "C":
							calculator.setResult("");
							calculator.setOperation("");
							calculator.setOldValue("");
							break;
						case ".":
							if(calculator.getResult().equals("")) {
								calculator.setResult("0.");
							} else if(!calculator.getResult().contains(".")) {
								calculator.setResult(calculator.getResult() + ".");
							}
							break;
						case "%":
							calculator.setResult(Operations.percent(calculator.getResult()));
							break;
						case "+/-":
							calculator.setResult(Operations.changeSign(calculator.getResult()));
							break;
						case "sqrt":
							calculator.setResult(Operations.sqrt(calculator.getResult()));
							break;
						default:
							
							if("+".equals(calculator.getOperation())) {
								calculator.setResult(Operations.addition(calculator.getOldValue(), calculator.getResult()));
							} else if("-".equals(calculator.getOperation())) {
								calculator.setResult(Operations.subtraction(calculator.getOldValue(), calculator.getResult()));
							} else if("*".equals(calculator.getOperation())) {
								calculator.setResult(Operations.multiplication(calculator.getOldValue(), calculator.getResult()));
							} else if("/".equals(calculator.getOperation())) {
								calculator.setResult(Operations.division(calculator.getOldValue(), calculator.getResult()));
							}
							
							calculator.setOldValue(calculator.getResult());
							calculator.setOperation(request.getParameter("btn"));
							newNumber = true;
							break;
						}
					}
				} catch (Exception e) {
					calculator.setResult("ERROR");
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
					requestDispatcher.forward(request, response);
				}
			}
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}

	/*=========== do POST ====================*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
