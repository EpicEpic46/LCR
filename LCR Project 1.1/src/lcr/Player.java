package lcr;

public class Player {
	private int chips;
	private String name;
	
	
	public Player(int startChips, String n) {
		chips = startChips;
		name = n;
	}
	
	public void giveChips(Player p, int n) {
		for (int i = 0; i < n; i++) {
			giveChip(p);
		}
	}
	
	public void giveChip(Player p) {
		chips--;
		p.setChips(p.getChips()+1);
	}
	
	public boolean hasChips() {
		if (chips < 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public int getChips() {
		return chips;
	}
	
	public void setChips(int chips) {
		this.chips = chips;
	}
	
	public void loseChip() {
		chips--;
	}
	
	public String getName() {
		return name;
	}
	
}
