public class Character {
	
	private String name;
	private String role;
	private int health;
	private int intelligence;
	private int charisma;
	private int engineering;
	private int stealth;
	
	public Character(String n, String r, int h, int i, int c, int e, int s) {
		name = n;
		role = r;
		health = h;
		intelligence = i;
		charisma = c;
		engineering = e;
		stealth = s;
	}
	
	public void display() {
		System.out.println(name + " the " + role);
		System.out.println();
		System.out.println("Stats:");
		System.out.println("Health: " + health);
		System.out.println("Intelligence: " + intelligence);
		System.out.println("Charisma: " + charisma);
		System.out.println("Engineering: " + engineering);
		System.out.println("Stealth: " + stealth);
	}
	
	public void setHealth(int h) {
		health = h;
	}
	
	public void setIntelligence(int i) {
		intelligence = i;
	}
	
	public void setCharisma(int c) {
		charisma = c;
	}
	
	public void setEngineering(int e) {
		engineering = e;
	}
	
	public void setStealth(int s) {
		stealth = s;
	}
	
	// add getters
}