package cardgame.blackjack.gui.factory;

import java.awt.event.ActionListener;

import kwing.BorderLayout;
import kwing.Button;
import kwing.Dialog;
import kwing.FlowLayout;
import kwing.Frame;
import kwing.Graphics;
import kwing.GridLayout;
import kwing.Label;
import kwing.Panel;
import kwing.RadioButton;
import kwing.TextField;
import kwing.Timer;
import kwing.swing.SWBorderLayout;
import kwing.swing.SWButton;
import kwing.swing.SWDialog;
import kwing.swing.SWFlowLayout;
import kwing.swing.SWFrame;
import kwing.swing.SWGraphics;
import kwing.swing.SWGridLayout;
import kwing.swing.SWLabel;
import kwing.swing.SWPanel;
import kwing.swing.SWRadioButton;
import kwing.swing.SWTextField;
import kwing.swing.SWTimer;

/**
 * Swingバージョンの部品を生成する工場
 *
 * @author Tsuyoshi Iwasaki
 * @author Takuma Torii
 * @author Shiro TAKATA
 *
 * @version 3.0, 2012/02/16
 */
public class SWWidgetFactory implements WidgetFactory {

	/**
	 * SWFactoryクラスの1つのインスタンスを保持するスタティック変数
	 */
	private static WidgetFactory factory = new SWWidgetFactory();

	/**
	 * 他のクラスからは参照できないコンストラクタを定義する
	 */
	private SWWidgetFactory() {
	}

	/**
	 * SWFactoryクラスの唯一のインスタンスの参照変数を返す
	 *
	 * @return ウィジィットファクトリインスタンス
	 */
	public static WidgetFactory getInstance() {
		return factory;
	}

	@Override
	public Timer createTimer(int time, ActionListener listener) {
//		System.out.println("SWWidgetFactoryで生成します。");
		return new SWTimer(time, listener);
	}

	@Override
	public Graphics createGraphics(int WIDTH, int HEIGHT) {
		return new SWGraphics(WIDTH, HEIGHT);
	}

	@Override
	public Frame createFrame() {
		return new SWFrame();
	}

	@Override
	public Panel createPanel() {
		return new SWPanel();
	}

	@Override
	public BorderLayout createBorderLayout() {
		return new SWBorderLayout();
	}

	@Override
	public FlowLayout createFlowLayout() {
		return new SWFlowLayout();
	}

	@Override
	public GridLayout createGridLayout() {
		return new SWGridLayout();
	}

	@Override
	public Label createLabel() {
		return new SWLabel();
	}

	@Override
	public TextField createTextField() {
		return new SWTextField();
	}

	@Override
	public Button createButton() {
		return new SWButton();
	}

	@Override
	public Dialog createDialog() {
		return new SWDialog();
	}

	@Override
	public RadioButton createRadioButton() {
		return new SWRadioButton();
	}

}
