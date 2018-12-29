/*
 * define an Exception that ensure no enemy in a team
 * */
public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	public MyException() {
	}
	public MyException(String error) {
		System.out.println("Find a spy: "+error);
	}
}
