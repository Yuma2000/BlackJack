package cardgame.blackjack.strategy;

import cardgame.Player;

/**
 * 基本的な状態
 * @author takeda
 */
public class StateBasic implements State {
	/**
	 * 状態が変化する戦略
	 */
	private StateStrategy stateStrategy;

	/**
	 * 基本的な戦略
	 */
	private Strategy basicStrategy = new BasicStrategy();

	/**
	 * コンストラクタ
	 * @param stateStrategy
	 */
	public StateBasic(StateStrategy stateStrategy) {
		this.stateStrategy = stateStrategy;
	}

	@Override
	public void handleState(int chipsValue) {
		if(chipsValue < 500)
			stateStrategy.setState(stateStrategy.getStateBear());
		else if(chipsValue > 2000)
			stateStrategy.setState(stateStrategy.getStateBull());
	}

	@Override
	public int decideBetChipsValue(Player player) {
		return basicStrategy.decideBetChipsValue(player);
	}

	@Override
	public boolean isGettingHit(Player player) {
		return basicStrategy.isGettingHit(player);
	}
}
