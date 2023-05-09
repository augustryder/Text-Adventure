import java.util.*;

public class Main {
	
	static UserInput user = new UserInput();
	
	static Boolean doorLocked = true;
	static Boolean hasCanister = false;
	static Boolean hasClothing = false;
	static Boolean securityClear = false;
	static Boolean alarm = true;
	
	static Stack<String> position = new Stack<String>();
				
	public static void main(String[] args) {
		
		System.out.println("You wake up and find yourself in a dimly lit room. What shall you do?");
	
		position.push("You are in the starting cell.");
		startingRoom();
		
	}
	
	public static void startingRoom() {
		
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}
			
			if(s.contains("look")) {
				System.out.println("You look around and find a desk drawer, a door, and an air vent.");
			}
			
			if(s.contains("inspect")) {
				
				if(s.contains("desk") || s.contains("drawer")) {
					
					System.out.println("You open the desk drawer and find a book on algorithms.");
					
					while(true) {
						if(user.contains("read")) {
							System.out.println("The book is marked on a page about the Sieve of Eratosthenes. You read that the sieve of Eratosthenes is an ancient algorithm for finding prime numbers.");
							break;
						}
						System.out.println("Maybe you should read the book.");
					}
					
				} else if(s.contains("door")) {
					
					if(doorLocked) {
						
						System.out.println("You inspect the door and find it has a keypad that needs a four digit code.");
						System.out.print("Enter Code: ");
						
						if(user.contains("2357")) {
							System.out.println("The keypad blinks green.");
							doorLocked = false;
						} else {
							System.out.println("The door is still locked.");
						}
						
					} else {
						
						System.out.println("You inspect the door and find it is unlocked.");
						
						if(user.contains("open")) {
							System.out.println("You open the door and exit the room.");
							position.push("You are in the hallway.");
							hall();
						}
						
					}
					
				} else if(s.contains("vent")) {
					System.out.println("You inspect the air vent and open it. It looks like you could fit inside.");
					if(user.contains("enter")) {
						System.out.println("You enter the air vent.");
						position.push("You are in an air vent.");
						airVent();
					}
				}
				
			}
			
			
		}
	}
	
	public static void airVent() {
		
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}
			
			if(s.contains("look")) {
				System.out.println("You approach the end of the air vent and see it leads into a security room with a security officer inside.");
			}
			
			if(s.contains("back")) {
				System.out.println("You go back into your cell.");
				position.pop();
				startingRoom();
			}
			
			if(hasCanister && user.contains("canister")) {
				System.out.println("You drop the gas canister into the room and it releases sleeping gas, knocking the security guard out.");
				securityClear = true;
			}
			
			if(s.contains("enter")) {
				if(securityClear) {
					System.out.println("You enter the security room.");
					position.push("You are in the security room.");
					securityRoom();
				} else {
					System.out.println("You enter the security room and the guard locks you back into your cell.");
					restart();
				}
			}
			
		}
		
	}
	
	public static void hall() {
		
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}
			
			if(s.contains("look")) {
				System.out.println("You are in a hallway. You see a nearby cell is unlocked. The hallway continues around a corner.");
			}
			
			if(s.contains("back")) {
				System.out.println("You go back into your cell.");
				position.pop();
				startingRoom();
			}
			
			if(s.contains("cell")) {
				System.out.println("You enter the nearby cell.");
				position.push("You are in an empty cell.");
				emptyCell();
			}
			
			if(s.contains("continue") || s.contains("corner")) {
				System.out.println("You continue around the corner.");
				System.out.println("You come across a guard.");
				if(hasClothing) {
					System.out.println("The guard greets you. You walk past and go outside onto the deck.");
					position.push("You are on the deck.");
					deck();
				} else {
					System.out.println("The guard arrests you and locks you back in your cell.");
					restart();
				}
			}
		}
		
	}
	
	public static void emptyCell() {
		
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}		
			
			if(s.contains("look")) {
				System.out.println("The cell seems to be empty. There is an air vent in the corner.");
			}
			
			if(s.contains("hall")) {
				System.out.println("You go back to the hallway.");
				position.push("You are in a hallway.");
				hall();
			}
			
			if(s.contains("vent") && s.contains("inspect")) {
				System.out.println("You inspect the air vent and open it. It looks like you could fit inside.");
				if(user.contains("enter")) {
					System.out.println("You enter the air vent.");
					System.out.println("You crawl to the end of the air vent and enter a room that appears to be an armory.");
					position.push("You are in an armory.");
					armory();
				}
			}
			
		}
	}
	
	public static void armory() {
		
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}	
			
			if(s.contains("look")) {
				System.out.println("You look around the armory and find a sleeping gas canister and crew member clothing.");
			}
			
			if(s.contains("take")) {
				if(s.contains("clothing")) {
					System.out.println("You take the crew member clothing and put it on.");
					hasClothing = true;
				}
				if(s.contains("canister")) {
					System.out.println("You take the sleeping gas canister.");
					hasCanister = true;
				}
			}
			
			if(s.contains("back")) {
				System.out.println("You enter the air vent and go back to the empty cell.");
				position.pop();
				emptyCell();
			}
			
		}
		
	}
	
	public static void deck() {
		
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}
			
			if(s.contains("look")) {
				System.out.println("You look around the deck for a means of escape. You see a jet ski attached the side of the boat. You also see the entrance to the security room. Looking through the window you see a security guard.");
			}
			
			if(s.contains("jet")) {
				System.out.println("You hop on the jetski and drive off.");
				if(alarm) {
					System.out.println("The alarm sounds and a security boat catches up to you. You are captured and locked back in your cell.");
					restart();
				} else {
					end();
				}
			}
			
			if(s.contains("canister") && hasCanister) {
				System.out.println("You throw the sleeping gas canister into the security room, incapacitating the officer.");
				securityClear = true;
			}
			
			if(s.contains("enter") && s.contains("security")) {
				if(securityClear) {
					System.out.println("You enter the security room.");
					position.push("You are in the security room.");
					securityRoom();
				} else {
					System.out.println("You enter the security room and the officer becomes suspicious. He blows your cover and arrests you, locking you back in your cell.");
					restart();
				}
			}
			
		}
	}
	
	public static void securityRoom() {
		while(true) {
			
			List s = Arrays.asList(user.getInput().split(" ")); 
			
			if(s.contains("location") || s.contains("position")) {
				location();
			}
			
			if(s.contains("look")) {
				System.out.println("You look around and see a whole bunch of controls and buttons. You see a switch that is flipped to |ALARM ON|. There is also a door that leads to the deck.");
			}
			
			if(s.contains("switch")) {
				System.out.println("You flip the switch to |ALARM OFF|.");
				alarm = false;
			}
			
			if(s.contains("vent")) {
				System.out.println("You go back into the air vent.");
				position.push("You are in an air vent.");
				airVent();
			}
			
			if(s.contains("deck")) {
				System.out.println("You enter onto the deck.");
				position.push("You are on the deck.");
				deck();
			}
		}
	}
	
	public static void location() {
		System.out.println(position.peek());
	}
	
	public static void restart() {
		doorLocked = true;
		hasCanister = false;
		hasClothing = false;
		securityClear = false;
		alarm = true;
		position.clear();
		position.push("You are in the starting cell.");
		startingRoom();
	}
	
	public static void end() {
		System.out.println("You successfully escaped!");
	}
	
}

