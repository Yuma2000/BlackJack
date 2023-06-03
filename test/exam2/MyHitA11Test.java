package exam2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cardgame.Card;
import cardgame.Card.RANK;
import cardgame.Card.SUIT;
import cardgame.CardGame;
import cardgame.Table;
import cardgame.blackjack.BlackJackPlayer;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.gui.UITable;

public class MyHitA11Test {

	static Table table;
	static BlackJackPlayer player;
	RANK[] ranks = Card.getRanks();		// カードランクの集合 ACE("A"),...,KING("K")
	boolean expected;	// Hit(true) or Stand(false) 期待値

	@BeforeClass					// TableとPlayerの準備として1回だけ実行する
	public static void setUp() {
		table = new UITable();
		CardGame.setTable(table);
		table.setupTable(); 	// Tableの準備
		player = new ExtendedBlackJackPlayer();
		player.setupPlayer(1);	// 座席番号1のPlayerの準備
	}
	/**
	 * A(エース)を11と数えるとき
	 */
	@Test
	public void  Aを11と数えた時のchoiceテスト01() {
		// テスト条件: cardTotal >= 18
		// Playerの手札: A, {7,...,10}; stand
		expected = false;

		for (int i = 6; i < 10; i++){
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}
	}

	@Test
	public void  Aを11と数えた時のchoiceテスト02() {
		// テスト条件: cardTotal = 17 && dealerFaceUpCard >= 1 && dealerFaceUpCard <= 9
		// Playerの手札: A, 6; Dealerの手札: 1,..,9: stand
		expected = false;

		for (int i = 0; i < 9; i++){
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(RANK.SIX, SUIT.Diamond), 1);
			table.putCard(new Card(ranks[i], SUIT.Spade), 0);
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}
		// Playerの手札: A, 6; Dealerの手札: 10: hit
		expected = true;

		int i = 9;
		table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
		table.putCard(new Card(RANK.SIX, SUIT.Diamond), 1);
		table.putCard(new Card(ranks[i], SUIT.Spade), 0);
		player.isGettingHit();
		assertThat(player.getChoice(),is(expected));
		table.clearObject();
	}

	@Test
	public void  Aを11と数えた時のchoiceテスト03() {
		// Playerの手札: A, {2,...,5} （cardTotal <=16）
		expected = true;

		for (int i = 1; i < 5; i++){
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}
	}
}
