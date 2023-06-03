package cardgame.blackjack.strategy;

import cardgame.Player;
import cardgame.blackjack.ExtendedBlackJackPlayer;

/**
 * 状態が変化する戦略
 * @author takeda
 */
public class StateStrategy implements Strategy {

	/**
	 * 戦略の状態
	 */
	private State state = new BasicStrategy();

	/**
	 * 持ちチップ
	 */
	private int chipsValue;

	/**
	 * 状態遷移を決定する
	 */
	public void handleState() {
		if(chipsValue < 500)
			state = new BearStrategy();
		else if(chipsValue >= 500 && chipsValue <= 2000)
			state = new BasicStrategy();
		else
			state = new BullStrategy();
	}

	@Override
	public int decideBetChipsValue(Player player) {
		chipsValue = player.getChipsValue();
		handleState();
		return state.decideBetChipsValue(player);
	}

	@Override
	public boolean isGettingHit(Player player) {
		return state.isGettingHit(player);
	}

	public static void main(String args[]) {
		Player player = new ExtendedBlackJackPlayer();
		StateStrategy strategy = new StateStrategy();
		player.setChipsValue(400);
		strategy.decideBetChipsValue(player);

		player.setChipsValue(500);
		strategy.decideBetChipsValue(player);

		player.setChipsValue(2000);
		strategy.decideBetChipsValue(player);

		player.setChipsValue(3000);
		strategy.decideBetChipsValue(player);
	}
}
