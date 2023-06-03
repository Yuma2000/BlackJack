package exam3;

import org.junit.Test;

import cardgame.Player;
import cardgame.blackjack.BlackJack;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.gui.JoinDialog;
import cardgame.blackjack.gui.factory.AWWidgetFactory;
import cardgame.blackjack.gui.factory.SWWidgetFactory;
import cardgame.blackjack.gui.factory.WidgetFactory;


public class DisplayJoinDialogTest {

	/**
	 * Widgetの部品を生成する工場
	 */
	public WidgetFactory factory; {
		String GUI = BlackJack.getGUI();
		if (GUI.equals(BlackJack.AWT)) {
			factory = AWWidgetFactory.getInstance();
		} else if (GUI.equals(BlackJack.SWING)) {
			factory = SWWidgetFactory.getInstance();
		}
	}

	/**
	 * JoinDialog表示テスト
	 */
	@Test
	public void JoinDialog表示テスト() {
		JoinDialog joinDialog = new JoinDialog(factory);
		Player player = new ExtendedBlackJackPlayer();
		player.setSeatNumber(1);
		joinDialog.displayDialog(player);
		System.out.printf("JoinDialog表示テスト： 座席番号 = %d, 名前 = %s, 購入チップ数 = %d, 人間 = %s, 戦略名 = %s\n",
				player.getSeatNumber(), player.getName(), player.getExchangeChips(), player.isHuman(),
				player.getStrategyName());
	}

}
