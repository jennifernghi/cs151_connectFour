package application;


public class Players extends AbstractPlayer {
	/**
	 * constructor
	 * @param playerId - playerNumber
	 * @param chip
	 */
	public Players(Integer playerId, Chip chip) {
		super(playerId, chip);
		System.out.println("player" + playerId);
	}
	/**
	 * @return playerId - String
	 */
	public String toString() {
		String str = getPlayerId().toString();
		return str;
	}
}
