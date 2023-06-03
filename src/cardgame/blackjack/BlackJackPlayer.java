package cardgame.blackjack;

import cardgame.Player;
import cardgame.blackjack.gui.BlackJackDialog;
import cardgame.blackjack.gui.ChoiceDialog;

/**
 * ブラックジャックプレイヤー
 *
 * @author Shinji Saito
 * @author Shiro Takata
 *
 * @version 3.0, 2015/12/01
 * @version 3.1, 2018/12/06
 */
public abstract class BlackJackPlayer extends Player {

	/**
	 * プレイヤー情報のダイアログ
	 */
	protected BlackJackDialog joinDialog;

	/**
	 * 賭けチップのダイアログ
	 */
	protected BlackJackDialog betDialog;

	/**
	 * ヒットまたはスタンド選択に関するダイアログ
	 */
	protected BlackJackDialog choiceDialog;

	/**
	 * BlackJackPlayerのコンストラクタ
	 */
	public BlackJackPlayer() {
	}

	/**
	 * BlackJackPlayerをセットアップする
	 */
	@Override
	public void setupPlayer(int seatNumber) {
		super.setupPlayer(seatNumber);
		createDialogs();
		setupBlackJackPlayer();
		displayMyName();
		createStrategy();
	}

	/**
	 * 各種ダイアログを生成する
	 */
	public void createDialogs() {
		joinDialog = createJoinDialog();
		betDialog = createBetDialog();
		choiceDialog = createChoiceDialog();
	}

	/**
	 * JoinDialogを表示して、名前、人間かエージェントか、購入チップ数、戦略などをセットアップする
	 */
	private void setupBlackJackPlayer() {
		joinDialog.displayDialog(this);
		chipsValue.addChipsPack(exchangeChips);
		betDialog.displayDialog(this);
		choiceDialog.displayDialog(this);
	}

	/**
	 * チップを賭ける
	 */
	@Override
	public void betChips() {
		decideBetChipsValue();
		betDialog.redisplayDialog();
		chipsValue.subtractChipsValue(betChips);
		table.putBetChips(betChips, getSeatNumber());
	}

	/**
	 * Hitすると思案しているか
	 */
	public void isGettingHit(){
		choice = strategy.isGettingHit(this);
	}

	/**
	 * ヒットまたはスタンドを返す
	 *
	 * @return ヒット（true）・スタンド（false）
	 */
	public boolean isHitSelected() {
		isGettingHit();
		choiceDialog.redisplayDialog();
		return choice = ((ChoiceDialog)choiceDialog).isHitSelected();
	}

	@Override
	public void takeChips() {
		chipsValue.addChipsPack(table.takeBetChips(getSeatNumber()));
		chipsValue.addChipsPack(table.takeRewardChips(getSeatNumber()));
	}

	@Override
	protected void watchHand(int seatNumber) {
	}

	@Override
	protected void watchCardDeck() {
		;
	}

	@Override
	protected abstract void createStrategy();

//	/**
//	 * Widgetの部品を生成する工場
//	 */
//	public WidgetFactory factory; {
//		String GUI = BlackJack.getGUI();
//		if (GUI.equals(BlackJack.AWT)) {
//			factory = AWWidgetFactory.getInstance();
//		} else if (GUI.equals(BlackJack.SWING)) {
//			factory = SWWidgetFactory.getInstance();
//		}
//	}

	/**
	 * JoinDialogを生成する
	 *
	 * @return ジョインダイヤログ
	 */
	public abstract BlackJackDialog createJoinDialog();

	/**
	 * BetDialogを生成する
	 *
	 * @return BetDialogのインスタンス
	 */
	public abstract BlackJackDialog createBetDialog();

	/**
	 * ChoiceDialogを生成する
	 *
	 * @return choiceDialog
	 */
	public abstract BlackJackDialog createChoiceDialog();

}
