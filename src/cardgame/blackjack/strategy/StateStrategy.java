package cardgame.blackjack.strategy;

import cardgame.Player;
import cardgame.blackjack.ExtendedBlackJackPlayer;

/**
 * 状態が変化する戦略
 * @author takeda
 */
public class StateStrategy implements Strategy {

	/**
	 * 弱気な状態
	 */
	private State stateBear;

	/**
	 * 基本的な状態
	 */
	private State stateBasic;

	/**
	 * 強気な状態
	 */
	private State stateBull;

	/**
	 * 戦略の状態
	 */
	private State state;

	/**
	 * 持ちチップ
	 */
	private int chipsValue;

	/**
	 * コンストラクタ
	 */
	public StateStrategy() {
		stateBear = new StateBear(this);
		stateBasic = new StateBasic(this);
		stateBull = new StateBull(this);
		state = stateBasic;
	}

	/**
	 * stateのセッター
	 * @param state 新たな状態
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * stateBearのゲッター
	 * @return stateBear
	 */
	public State getStateBear() {
		return stateBear;
	}

	/**
	 * stateBasicのゲッター
	 * @return stateBasic
	 */
	public State getStateBasic() {
		return stateBasic;
	}

	/**
	 * stateBullのゲッター
	 * @return stateBull
	 */
	public State getStateBull() {
		return stateBull;
	}

	@Override
	public int decideBetChipsValue(Player player) {
		chipsValue = player.getChipsValue();
		state.handleState(chipsValue);
		return state.decideBetChipsValue(player);
	}

	@Override
	public boolean isGettingHit(Player player) {
		return state.isGettingHit(player);
	}

	/**
	 * 結合テスト用メインメソッド
	 * @param args
	 */
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
