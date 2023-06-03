package cardgame.blackjack.strategy;

import java.util.Random;

import cardgame.Banner;
import cardgame.Player;
import cardgame.blackjack.BlackJackRule;

/**
 * 新しく作成した戦略
 * @author takeda
 *
 */
public class MyStrategy implements Strategy {

	/**
	 * 前回の賭けチップ
	 */
	private int beforeBetChips;

	/**
	 * 持ちチップ
	 */
	private int chipsValue;

	/**
	 * 今回の賭けチップ
	 */
	private int betChips;

	/**
	 * ヒットまたはスタンド
	 */
	private boolean isHit;

	/**
	 * 手札の合計
	 */
	private int cardTotal;

	/**
	 * ディーラーの表カードの数値
	 */
	private int dealerFaceUpCard;

	/**
	 * 乱数発生
	 */
	private Random random;

	public MyStrategy() {
		random = new Random();
	}

	@Override
	public int decideBetChipsValue(Player player) {
		chipsValue = player.getChipsValue();
		beforeBetChips = player.getBetChips();

		if (chipsValue <= 0) {// チップを持っていないとき
			return 0;
		}

		// 前回の勝敗で、賭けチップを決定する
		if (player.getJudgment() == Banner.WIN) { // 前回勝ったとき
			betChips = beforeBetChips + beforeBetChips / 4;
		} else if (player.getJudgment() == Banner.PUSH) { // 前回引き分けのとき
			betChips = beforeBetChips + beforeBetChips / 5;
		} else if (player.getJudgment() == Banner.LOSE) { // 前回負けたとき
			betChips = chipsValue / (1 + random.nextInt(2));
			// 賭けチップが$0、かつ所持チップがあるときは所持チップを全て賭ける
			if (betChips == 0 && chipsValue > 0) {
				betChips = chipsValue;
			}
		} else { // ゲーム開始時
			betChips = chipsValue / (2 + random.nextInt(2));
		}
		return betChips;
	}

	@Override
	public boolean isGettingHit(Player player) {

		cardTotal = BlackJackRule.totalHand(player.getTable().getHand(
				player.getSeatNumber()));

		dealerFaceUpCard = BlackJackRule.getDealerFaceUpCard(player.getTable()
				.getHand(0));

		if (BlackJackRule.isPair(player.getTable().getHand(
				player.getSeatNumber()))) { // 手札がペアのとき
			pairs(cardTotal / 2);
		} else if (BlackJackRule.isSoft()) {// 手札のA(エース)を11と数える場合
			softTotals();
		} else { // 手札がその他の場合
			HardTotals();
		}

		return isHit;
	}

	/**
	 * 手札がペアのとき
	 *
	 * @param cardNumber
	 *            カードの数字
	 */
	private void pairs(int cardNumber) {
		if (cardNumber >= 9) {
			isHit = false;
		} else {
			isHit = true;
		}
	}

	/**
	 * A(エース)を11と数えるとき
	 */
	private void softTotals() {
		if (cardTotal >= 18
				|| (cardTotal >= 17 && dealerFaceUpCard >= 1 && dealerFaceUpCard <= 9)) {
			isHit = false;
		} else {
			isHit = true;
		}
	}

	/**
	 * A(エース)を1と数えるとき
	 */
	private void HardTotals() {
		if (cardTotal >= 17) {
			isHit = false;
		} else {
			isHit = true;
		}
	}

}
