package cardgame.blackjack;

import cardgame.blackjack.gui.BetDialog;
import cardgame.blackjack.gui.BlackJackDialog;
import cardgame.blackjack.gui.ChoiceDialog;
import cardgame.blackjack.gui.JoinDialog;
import cardgame.blackjack.gui.factory.AWWidgetFactory;
import cardgame.blackjack.gui.factory.SWWidgetFactory;
import cardgame.blackjack.gui.factory.WidgetFactory;
import cardgame.blackjack.strategy.BasicStrategy;
import cardgame.blackjack.strategy.BearStrategy;
import cardgame.blackjack.strategy.BullStrategy;
import cardgame.blackjack.strategy.HumanStrategy;
import cardgame.blackjack.strategy.MyStrategy;
import cardgame.blackjack.strategy.RandomStrategy;
import cardgame.blackjack.strategy.SimpleStrategy;
import cardgame.blackjack.strategy.StateStrategy;
import cardgame.blackjack.strategy.Strategy;

/**
 * 戦略拡張用のブラックジャックプレイヤー
 * @author takeda
 */
public class ExtendedBlackJackPlayer extends BlackJackPlayer {

	/**
	 * Widgetの部品を生成する工場
	 */
	public WidgetFactory factory;

	/**
	 * ExtendedBlackJackPlayerのコンストラクタ
	 */
	public ExtendedBlackJackPlayer() {
		String GUI = BlackJack.getGUI();
		if (GUI.equals(BlackJack.AWT)) {
			this.factory = AWWidgetFactory.getInstance();
		} else if (GUI.equals(BlackJack.SWING)) {
			this.factory = SWWidgetFactory.getInstance();
		}
	}

	@Override
	public BlackJackDialog createJoinDialog() {
		return new JoinDialog(factory);
	}

	@Override
	public BlackJackDialog createBetDialog() {
		return new BetDialog(factory);
	}

	@Override
	public BlackJackDialog createChoiceDialog() {
		return new ChoiceDialog(factory);
	}

	@Override
	protected void createStrategy() {
		/**
		 * このメソッドを使用しているかの確認文
		 */
//		System.out.println("ExtendedBlackJackPlayerにて各戦略を生成します。");

		if (human) {
			strategy = new HumanStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.BasicStrategy.name())) {
			strategy = new BasicStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.BearStrategy.name())) {
			strategy = new BearStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.BullStrategy.name())) {
			strategy = new BullStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.SimpleStrategy.name())) {
			strategy = new SimpleStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.RandomStrategy.name())) {
			strategy = new RandomStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.MyStrategy.name())) {
			strategy = new MyStrategy();
		}	else if (strategyName.equals(Strategy.STRATEGY.StateStrategy.name())) {
				strategy = new StateStrategy();
		} else {
			strategy = null;
			System.err.println(strategyName + "が存在しません");
			System.exit(1);
		}
	}

}
