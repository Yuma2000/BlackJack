package cardgame.blackjack.gui;

import java.awt.event.ActionListener;

import kwing.*;
import kwing.awt.*;

/**
 * AWTバージョンのイズヒットダイアログ
 * 
 * @author Shinji Saito
 * 
 * @version 2.0, 2007/12/05
 */
public class AWBetDialog extends BetDialog {

	@Override
	public Timer createTimer(int time, ActionListener listener) {
		return new AWTimer(time, listener);
	}

	@Override
	public Graphics createGraphics(int WIDTH, int HEIGHT) {
		return new AWGraphics(WIDTH, HEIGHT);
	}

	@Override
	public Frame createFrame() {
		return new AWFrame();
	}

	@Override
	public Panel createPanel() {
		return new AWPanel();
	}

	@Override
	public BorderLayout createBorderLayout() {
		return new AWBorderLayout();
	}

	@Override
	public FlowLayout createFlowLayout() {
		return new AWFlowLayout();
	}

	@Override
	public GridLayout createGridLayout() {
		return new AWGridLayout();
	}

	@Override
	public Label createLabel() {
		return new AWLabel();
	}

	@Override
	public TextField createTextField() {
		return new AWTextField();
	}

	@Override
	public Button createButton() {
		return new AWButton();
	}

	@Override
	public Dialog createDialog() {
		return new AWDialog();
	}

	@Override
	public RadioButton createRadioButton() {
		return new AWRadioButton();
	}
}