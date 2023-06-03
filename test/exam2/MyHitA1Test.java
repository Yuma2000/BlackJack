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

public class MyHitA1Test {
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

	@Test
	public void  Aを1と数えた時のchoiceテスト01() {

		// テスト条件: cardTotal >= 17
		// Playerの手札: 10, {6,...,10}, A: stand
		expected = false;
		for (int i = 5; i < 10; i++){
			table.putCard(new Card(RANK.TEN, SUIT.Spade), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}
	}

	@Test
	public void  Aを1と数えた時のchoiceテスト02() {

		// テスト条件: cardTotal <= 16
		// Playerの手札: A,4,6,{A,...,10}: stand

		for (int i = 6; i < 10; i++){

			expected = true;
			table.putCard(new Card(RANK.FIVE, SUIT.Diamond), 1);
			table.putCard(new Card(ranks[i], SUIT.Heart), 1);
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();

		}
	}
}
