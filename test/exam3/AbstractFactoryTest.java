package exam3;

import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.gui.BetDialog;
import cardgame.blackjack.gui.BlackJackDialog;
import cardgame.blackjack.gui.factory.AWWidgetFactory;
import cardgame.blackjack.gui.factory.SWWidgetFactory;

public class AbstractFactoryTest {
	public static void main(String args[]) {
		//SWWidgetFactoryのテスト
		BlackJackDialog betDialog = new BetDialog(SWWidgetFactory.getInstance());
		betDialog.displayDialog(new ExtendedBlackJackPlayer());

		//AWWidgetFactoryのテスト
		betDialog = new BetDialog(AWWidgetFactory.getInstance());
		betDialog.displayDialog(new ExtendedBlackJackPlayer());
	}
}
