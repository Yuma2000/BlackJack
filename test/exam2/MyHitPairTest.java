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

public class MyHitPairTest {

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
	public void ペアカード時のchoiceテスト01() {
		// テスト条件： cardNumber >= 9
		// Playerの手札: 9, 10: stand
		expected = false;
		for (int i = 8; i < 10; i++){
			table.putCard(new Card(ranks[i], SUIT.Club), 1);	// テストPlayerの座席番号を1とする
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);
			player.isGettingHit();	// Basic Strategy戦略を用いてHit（true）かStand（false）とする
			assertThat(player.getChoice(),is(expected));
			table.clearObject(); // Tableのカードを片付ける
		}
	}

	@Test
	public void ペアカード時のchoiceテスト02() {
		// テスト条件： cardNumber <= 8
		// Playerの手札: {1,...,8}: hit
		expected = true;
		for (int i = 0; i < 8; i++){
			table.putCard(new Card(ranks[i], SUIT.Club), 1);	// テストPlayerの座席番号を1とする
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);
			player.isGettingHit();	// Basic Strategy戦略を用いてHit（true）かStand（false）とする
			assertThat(player.getChoice(),is(expected));
			table.clearObject(); // Tableのカードを片付ける
		}
	}

}
