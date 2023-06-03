package exam4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cardgame.Banner;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.strategy.State;
import cardgame.blackjack.strategy.StateStrategy;

/**
 * DynamicStrategy の単体テスト
 */
public class DynamicStrategyTest {

	ExtendedBlackJackPlayer player;
	StateStrategy strategy;
	State expected;		// 状態遷移先の期待値

	@Before
	public void setUp() {
		player = new ExtendedBlackJackPlayer();
		player.setStrategy(strategy = new StateStrategy());
	}
	@Test
	public void DynamicBearのhandleState境界テスト() {
		strategy.setState(strategy.getStateBear());
		// 前回勝ちの場合
		expected = strategy.getStateBasic();

		player.setJudgement(Banner.WIN);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(), is(expected));

		strategy.setState(strategy.getStateBear());
		// 前回引き分けの場合
		expected = strategy.getStateBear();

		player.setJudgement(Banner.PUSH);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(), is(expected));
	}

	@Test
	public void DynamicBullのhandleState境界テスト() {
		strategy.setState(strategy.getStateBull());
		// 前回負けの場合
		expected = strategy.getStateBasic();

		player.setJudgement(Banner.LOSE);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(), is(expected));

		strategy.setState(strategy.getStateBull());
		// 前回引き分けの場合
		expected = strategy.getStateBull();

		player.setJudgement(Banner.PUSH);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(), is(expected));
	}

	@Test
	public void DynamicBasicのhandleState境界テスト() {
		strategy.setState(strategy.getStateBull());
		// 前回勝ちの場合
		expected = strategy.getStateBull();

		player.setJudgement(Banner.WIN);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(), is(expected));

		strategy.setState(strategy.getStateBasic());
		// 前回負けの場合
		expected = strategy.getStateBear();

		player.setJudgement(Banner.LOSE);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(), is(expected));

		strategy.setState(strategy.getStateBasic());
		// 前回引き分けの場合
		expected = strategy.getStateBasic();

		player.setJudgement(Banner.PUSH);
		strategy.decideBetChipsValue(player);
		assertThat(strategy.getState(),is(expected));
	}
}