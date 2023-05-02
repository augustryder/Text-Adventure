import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Character player;
		
		UserInput user = new UserInput();
		
		System.out.print("Character Name: ");
		String name = user.getInput();
		
		Boolean cont = false;
		while(!cont) {
			
			System.out.println("Choose a role: Engineer, Mathematician, Businessman, Spy");
			String role = user.getInput();
			System.out.println();
			
			switch (role) {
				case "engineer":
					player = new Character(name, role, 100, 8, 4, 10, 3);
					player.display();
					cont = true;
					break;
				case "mathematician": 
					player = new Character(name, role, 100, 10, 3, 6, 5);
					player.display();
					cont = true;
					break;
				case "businessman":
					player = new Character(name, role, 100, 6, 10, 2, 3);
					player.display();
					cont = true;
					break;
				case "spy":
					System.out.println("Hello");
					player = new Character(name, role, 100, 6, 8, 3, 10);
					player.display();
					cont = true;
					break;
				default:
					System.out.println("You must choose one of the given roles!");
					cont = false;
					break;
					// restart
			}
			
		}
		
		// begin game
		
		System.out.println();
		System.out.println();
		System.out.println("You wake up and find yourself in a dimly lit room. What shall you do?");
		
		while(!user.contains("look")) {
			System.out.println("Maybe you should look around.");
		}
		System.out.println("You look around and find a desk drawer, a door, and an air vent.");
		
		while(true) {
			List s = Arrays.asList(user.getInput().split(" ")); 
			if(s.contains("inspect")) {
				if(s.contains("desk") || s.contains("drawer")) {
					System.out.println("You inspect the desk drawer...");
					break;
				} else if(s.contains("door")) {
					System.out.println("You inspect the door...");
					break;
				} else if(s.contains("vent")) {
					System.out.println("You inspect the air vent...");
					break;
				} else {
					System.out.println("Maybe you should inspect something in the room.");
				}
			} else {
				System.out.println("Maybe you should inspect something in the room.");
			}
		}
		
		// to be continued
		
	}
}