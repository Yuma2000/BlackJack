package cardgame.blackjack.strategy;

import cardgame.Player;

/**
 * 弱気な状態
 * @author takeda
 */
public class StateBear implements State{
	/**
	 * 状態が変化する戦略
	 */
	private StateStrategy stateStrategy;

	/**
	 * 弱気な戦略
	 */
	private Strategy bearStrategy = new BearStrategy();

	/**
	 * コンストラクタ
	 * @param stateStrategy
	 */
	public StateBear(StateStrategy stateStrategy) {
		this.stateStrategy = stateStrategy;
	}

	@Override
	public void handleState(int chipsValue) {
		if(chipsValue >= 500 && chipsValue <= 2000)
			stateStrategy.setState(stateStrategy.getStateBasic());
		else if(chipsValue > 2000)
			stateStrategy.setState(stateStrategy.getStateBull());
	}

	@Override
	public int decideBetChipsValue(Player player) {
		return bearStrategy.decideBetChipsValue(player);
	}

	@Override
	public boolean isGettingHit(Player player) {
		return bearStrategy.isGettingHit(player);
	}
}
