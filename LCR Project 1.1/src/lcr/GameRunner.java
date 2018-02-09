package lcr;

public class GameRunner {
	public static void main(String[] args) {
		final int PLAYER_COUNT = 5;
		final int CHIPS_PER_PLAYER = 5;
		LCR game = new LCR(PLAYER_COUNT, CHIPS_PER_PLAYER);
		System.out.println("Game Results:");
		game.run();
	}
}
