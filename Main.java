public class Main {
	public static void main(String[] args) {
		
		Character player;
		
		UserInput user = new UserInput();
		
		System.out.print("Character Name: ");
		String name = user.getInput();
		
		System.out.println("Choose a role: Engineer, Mathematician, Businessman, Spy");
		String role = user.getInput();
		System.out.println();
		
		switch (role) {
			case "Engineer":
				player = new Character(name, role, 100, 8, 4, 10, 3);
				player.display();
				break;
			case "Mathemetician": 
				player = new Character(name, role, 100, 10, 3, 6, 5);
				player.display();
				break;
			case "Businessman":
				player = new Character(name, role, 100, 6, 10, 2, 3);
				player.display();
				break;
			case "Spy":
				player = new Character(name, role, 100, 6, 8, 3, 10);
				player.display();
				break;
			default:
				System.out.println("You must choose one of the given roles!");
				// restart
				break;
		}
		
		// begin game
		
		System.out.println();
		System.out.println();
		System.out.println("You wake up and find yourself in a dimly lit room. What shall you do?");
		if(user.contains("look")) {
			System.out.println("You look around and find a desk drawer, a door, and an air vent.");
		}
		
		// to be continued
		
	}
}