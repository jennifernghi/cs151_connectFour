package application;
/**
 * 
 * 
 *
 */
public abstract class AbstractPlayer {
	//fields
	private Integer playerId;
	private Chip chip;
	/**
	 * default constructor
	 * no player with chip of value 0 and color of white
	 */
	public AbstractPlayer(){
		this(0,new Chip());
	}
	/**
	 * constructor
	 * @param playerId - player number
	 * @param chip - chip
	 */
	public AbstractPlayer(Integer playerId, Chip chip){
		this.playerId = playerId;
		this.chip = chip;
	}
	/**
	 * set playerId
	 * @param playerId - player number
	 */
	public void setPlayerId(Integer playerId){
		this.playerId=playerId;
	}
	/**
	 * get playerId
	 * @return playerId
	 */
	public Integer getPlayerId() {
		return this.playerId;
	}
	/**
	 * set Chip
	 * @param chip - a Chip
	 */
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	/**
	 * get Chip
	 * @return chip
	 */
	public Chip getChip() {
		return this.chip;
	}
}
