package exam2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cardgame.Banner;
import cardgame.Player;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.strategy.MyStrategy;
import cardgame.blackjack.strategy.Strategy;

/**
 * MyStrategyの単体テスト
 * @author takeda
 *
 */
public class MyBetChipsTest {

	static Player player;
	static Strategy strategy;

	int beforeBetChips;	// 前回掛けチップ数
	int chipsValue;		// 所持チップ数
	int betChips;		// 今回の掛けチップ数
	int expected;		// 掛けチップ数の期待値

	@BeforeClass
	public static void setUp() {
		player = new ExtendedBlackJackPlayer();
		strategy = new MyStrategy();
	}

	/**
	 * ベットチップ数の境界テスト
	 */
	@Test
	public void 持ちチップが0のbetChipsテスト() {
		expected = 0;
		player.setChipsValue(chipsValue);
		betChips = strategy.decideBetChipsValue(player);
		assertThat(betChips, is(expected));
	}

	@Test
	public void 前回WIN時のbetChipsテスト() {
		chipsValue = 50;
		beforeBetChips = 40;
		expected = beforeBetChips + beforeBetChips / 4;

		player.setChipsValue(chipsValue);
		player.setBetChips(beforeBetChips);
		player.setJudgement(Banner.WIN);
		betChips = strategy.decideBetChipsValue(player);
		assertThat(betChips, is(expected));
	}

	@Test
	public void 前回PUSH時のbetChipsテスト() {
		chipsValue = 50;
		beforeBetChips = 40;
		expected = beforeBetChips + beforeBetChips / 5;

		player.setChipsValue(chipsValue);
		player.setBetChips(beforeBetChips);
		player.setJudgement(Banner.PUSH);
		betChips = strategy.decideBetChipsValue(player);
		assertThat(betChips, is(expected));
	}

	@Test
	public void 前回LOSE時のbetChipsテスト() {
		for (chipsValue =  1; chipsValue <=5; chipsValue++){
			player.setChipsValue(chipsValue);
			player.setJudgement(Banner.LOSE);
			betChips = strategy.decideBetChipsValue(player);
			assertThat(chipsValue / 2 <= betChips && betChips <= chipsValue
					|| betChips == chipsValue, is(true));
		}
	}

	@Test
	public void ゲーム開始時のbetChipsテスト() {
		chipsValue = 50;
		beforeBetChips = 0;
		player.setChipsValue(chipsValue);
		player.setBetChips(beforeBetChips);
		player.setJudgement(Player.READY);
		betChips = strategy.decideBetChipsValue(player);
		assertThat(chipsValue / 3 <= betChips && betChips <= chipsValue / 2, is(true));
	}
}
