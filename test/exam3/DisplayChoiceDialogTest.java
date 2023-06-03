package exam3;

import org.junit.Test;

import cardgame.Player;
import cardgame.blackjack.BlackJack;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.gui.ChoiceDialog;
import cardgame.blackjack.gui.factory.AWWidgetFactory;
import cardgame.blackjack.gui.factory.SWWidgetFactory;
import cardgame.blackjack.gui.factory.WidgetFactory;

public class DisplayChoiceDialogTest {

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
	 * ChoiceDialog表示テスト
	 */
	@Test
	public void ChoiceDialog人間Hit表示テスト() {

		boolean human = true;
		boolean choice = true;
		int exchangeChips = 1024;
		int chipsValue = 500;
		int betChips = 100;

		ChoiceDialog choiceDialog = new ChoiceDialog(factory);

		Player player = new ExtendedBlackJackPlayer();
		player.setSeatNumber(1);
		player.setName("伊之助");
		player.setStrategyName("テスト");
		player.setHuman(human);
		player.setChoice(choice);
		player.setExchangeChips(exchangeChips);
		player.setChipsValue(chipsValue);
		player.setBetChips(betChips);

		choiceDialog.displayDialog(player);
		choiceDialog.redisplayDialog();
		choice = choiceDialog.isHitSelected();
		System.out.printf("ChoiceDialog人間Hit表示テスト： 座席番号 = %d, 名前 = %s, 人間 = %s, 戦略名 = %s, 購入チップ数 = %d, 所持チップ = %d, ベット数 = %d, isHit = %s\n",
				player.getSeatNumber(), player.getName(), player.isHuman(), player.getStrategyName(), player.getExchangeChips(),
				player.getChipsValue(), player.getBetChips(), choice);
	}

	@Test
	public void ChoiceDialog人間Stand表示テスト() {

		boolean human = true;
		boolean choice = false;
		int exchangeChips = 1024;
		int chipsValue = 500;
		int betChips = 100;

		ChoiceDialog choiceDialog = new ChoiceDialog(factory);

		Player player = new ExtendedBlackJackPlayer();
		player.setSeatNumber(1);
		player.setName("伊之助");
		player.setStrategyName("テスト");
		player.setHuman(human);
		player.setChoice(choice);
		player.setExchangeChips(exchangeChips);
		player.setChipsValue(chipsValue);
		player.setBetChips(betChips);

		choiceDialog.displayDialog(player);
		choiceDialog.redisplayDialog();
		choice = choiceDialog.isHitSelected();
		System.out.printf("ChoiceDialog人間Stand表示テスト： 座席番号 = %d, 名前 = %s, 人間 = %s, 戦略名 = %s, 購入チップ数 = %d, 所持チップ = %d, ベット数 = %d, isHit = %s\n",
				player.getSeatNumber(), player.getName(), player.isHuman(), player.getStrategyName(), player.getExchangeChips(),
				player.getChipsValue(), player.getBetChips(), choice);
	}

	@Test
	public void ChoiceDialogエージェントHit表示テスト() {

		boolean human = false;
		boolean choice = true;
		int exchangeChips = 1024;
		int chipsValue = 500;
		int betChips = 100;

		ChoiceDialog choiceDialog = new ChoiceDialog(factory);

		Player player = new ExtendedBlackJackPlayer();
		player.setSeatNumber(1);
		player.setName("伊之助");
		player.setStrategyName("テスト");
		player.setHuman(human);
		player.setChoice(choice);
		player.setExchangeChips(exchangeChips);
		player.setChipsValue(chipsValue);
		player.setBetChips(betChips);

		choiceDialog.displayDialog(player);
		choiceDialog.redisplayDialog();
		choice = choiceDialog.isHitSelected();
		System.out.printf("ChoiceDialogエージェントHit表示テスト： 座席番号 = %d, 名前 = %s, 人間 = %s, 戦略名 = %s, 購入チップ数 = %d, 所持チップ = %d, ベット数 = %d, isHit = %s\n",
				player.getSeatNumber(), player.getName(), player.isHuman(), player.getStrategyName(), player.getExchangeChips(),
				player.getChipsValue(), player.getBetChips(), choice);
	}

	@Test
	public void ChoiceDialogエージェントStand表示テスト() {

		boolean human = false;
		boolean choice = false;
		int exchangeChips = 1024;
		int chipsValue = 500;
		int betChips = 100;

		ChoiceDialog choiceDialog = new ChoiceDialog(factory);

		Player player = new ExtendedBlackJackPlayer();
		player.setSeatNumber(1);
		player.setName("伊之助");
		player.setStrategyName("テスト");
		player.setHuman(human);
		player.setChoice(choice);
		player.setExchangeChips(exchangeChips);
		player.setChipsValue(chipsValue);
		player.setBetChips(betChips);

		choiceDialog.displayDialog(player);
		choiceDialog.redisplayDialog();
		choice = choiceDialog.isHitSelected();
		System.out.printf("ChoiceDialogエージェントStand表示テスト： 座席番号 = %d, 名前 = %s, 人間 = %s, 戦略名 = %s, 購入チップ数 = %d, 所持チップ = %d, ベット数 = %d, isHit = %s\n",
				player.getSeatNumber(), player.getName(), player.isHuman(), player.getStrategyName(), player.getExchangeChips(),
				player.getChipsValue(), player.getBetChips(), choice);
	}

}
