package cardgame.blackjack.strategy;

import cardgame.Player;

/**
 * 強気な状態
 * @author takeda
 */
public class StateBull implements State {
	/**
	 * 状態が変化する戦略
	 */
	private StateStrategy stateStrategy;

	/**
	 * 強気な戦略
	 */
	private Strategy bullStrategy = new BullStrategy();

	/**
	 * コンストラクタ
	 * @param stateStrategy
	 */
	public StateBull(StateStrategy stateStrategy) {
		this.stateStrategy = stateStrategy;
	}

	@Override
	public void handleState(int chipsValue) {
		if(chipsValue < 500)
			stateStrategy.setState(stateStrategy.getStateBear());
		else if(chipsValue >= 500 && chipsValue <= 2000)
			stateStrategy.setState(stateStrategy.getStateBasic());
	}

	@Override
	public int decideBetChipsValue(Player player) {
		return bullStrategy.decideBetChipsValue(player);
	}

	@Override
	public boolean isGettingHit(Player player) {
		return bullStrategy.isGettingHit(player);
	}
}
