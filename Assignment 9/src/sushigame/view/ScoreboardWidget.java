package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	public enum type {BALANCE, SOLD, SPOILED};
	private ScoreboardWidget.type current = ScoreboardWidget.type.BALANCE;
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		refresh();
	}

	public void reset1() {
		removeAll();
		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(display);
		display.setText("<html><h1>Scoreboard</h1></html>");
		validate();
		repaint();
	}
	
	public void reset2() {
		JButton balance = new JButton("Sort by balance");
		balance.setActionCommand("balance");
		balance.addActionListener(this);
		add(balance);
		
		JButton sold = new JButton("Sort by amount sold");
		sold.setActionCommand("eaten");
		sold.addActionListener(this);
		add(sold);
		
		JButton spoiled = new JButton("Sort by amount spoiled");
		spoiled.setActionCommand("spoiled");
		spoiled.addActionListener(this);
		add(spoiled);
	}
	
	

	public void refresh() {
		if(current == ScoreboardWidget.type.BALANCE) {
			sortBalance();
		} else if(current == ScoreboardWidget.type.SOLD) {
			sortEaten();
		} else if(current == ScoreboardWidget.type.SPOILED) {
			sortSpoiled();
		}
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "balance":
			current = ScoreboardWidget.type.BALANCE;
			sortBalance();
			break;
		case "eaten":
			current = ScoreboardWidget.type.SOLD;
			sortEaten();
			break;
		case "spoiled":
			current = ScoreboardWidget.type.SPOILED;
			sortSpoiled();
			break;
		}
	}

	private void sortSpoiled() {
		reset1();
		
		String sb_html = "<html>";
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new LowToHighSpoiledComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " (" + Math.round(c.getSpoiled()*100.0)/100.0 + " ounces spoiled) <br>";
		}
		
		JLabel balance = new JLabel(sb_html);
		add(balance);
		
		reset2();
	}

	private void sortEaten() {
		reset1();
		
		String sb_html = "<html>";
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowSoldComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " (" + Math.round(c.getEaten()*100.0)/100.0 + " ounces sold) <br>";
		}
		
		JLabel balance = new JLabel(sb_html);
		add(balance);
		
		reset2();
	}

	private void sortBalance() {
		reset1();
		
		String sb_html = "<html>";
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
		}
		
		JLabel balance = new JLabel(sb_html);
		add(balance);
		
		reset2();
	}

}
