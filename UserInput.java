import java.util.*;

public class UserInput {
	
	private Scanner s;
	
	public UserInput() {
		s = new Scanner(System.in);
	}
	
	public String getInput() {
		String str = "";
		try {
			str = s.nextLine();
		}
		catch (Exception e) {
			str = "";
			System.out.println("Input Error.");
		}
		return str;
	}
	
	public boolean contains(String str) {
		Boolean b;
		try {
			b = Arrays.asList(s.nextLine().split(" ")).contains(str);
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