package cardgame.blackjack.strategy;

import cardgame.Player;

/**
 * 状態用インターフェース
 * @author takeda
 */
public interface State {
	/**
	 * 状態遷移を決定する
	 */
	public void handleState(int chipsValue);

	/**
	 * 賭けチップを決定する
	 * @param player プレーヤー
	 * @return 賭けチップ
	 */
	public int decideBetChipsValue(Player player);

	/**
	 * ヒットまたはスタンドを決定する
	 * @param player プレーヤー
	 * @return ヒット：真、スタンド：偽
	 */
	public boolean isGettingHit(Player player);
}