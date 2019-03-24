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
							break;
						case ".":
							calculator.setResult("."); // TO DO
							break;
						case "%":
							calculator.setResult(String.valueOf((Double)Double.parseDouble(calculator.getResult()) /100));
							break;
						case "+/-":
							calculator.setResult(String.valueOf(Integer.parseInt(calculator.getResult()) * -1));
							break;
						case "=":
							calculator.setOperation(String.valueOf(Integer.parseInt(calculator.getResult())));
							//calculator.setResult(String.valueOf(Integer.parseInt(calculator.getResult() + Integer.parseInt(request.getParameter("btn")))));
							break;
						default:
							calculator.setOperation(request.getParameter("btn"));
							calculator.setResult(calculator.getResult());
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
