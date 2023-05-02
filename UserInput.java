import java.util.*;

public class UserInput {
	
	private Scanner s;
	
	public UserInput() {
		s = new Scanner(System.in);
	}
	
	public String getInput() {
		String str = "";
		try {
			str = s.nextLine().toLowerCase();
		}
		catch (Exception e) {
			str = "";
			System.out.println("Input Error.");
		}
		return str;
	}
	
	public boolean contains(String str) {
		String inpt = str.toLowerCase();
		Boolean b;
		try {
			b = Arrays.asList(s.nextLine().toLowerCase().split(" ")).contains(str);
		}
		catch (Exception e) {
			b = false;
		}
		return b;
	}
	
	public void end() {
		s.close();
	}
}