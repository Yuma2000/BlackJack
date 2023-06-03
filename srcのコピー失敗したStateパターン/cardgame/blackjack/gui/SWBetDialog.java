package cardgame.blackjack.gui;

import java.awt.event.ActionListener;

import kwing.*;
import kwing.swing.*;

/**
 * SWTバージョンのイズヒットダイアログ
 * 
 * @author Shinji Saito
 * 
 * @version 2.0, 2007/12/05
 */
public class SWBetDialog extends BetDialog {

	@Override
	public Timer createTimer(int time, ActionListener listener) {
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