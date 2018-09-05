package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel[] belt_labels;
	private PlateInfoView plateInfo;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize() + 2, 1));
		belt_labels = new JLabel[belt.getSize()];
		
		JLabel spacer = new JLabel();
		spacer.setMinimumSize(new Dimension(300, 20));
		spacer.setPreferredSize(new Dimension(300, 20));
		spacer.setOpaque(true);
		spacer.setBackground(Color.WHITE);
		
		this.plateInfo = new PlateInfoView("Click on a roll at any time to select it.");
		plateInfo.setMinimumSize(new Dimension(300, 20));
		plateInfo.setPreferredSize(new Dimension(300, 20));
		plateInfo.setForeground(Color.WHITE);
		plateInfo.setOpaque(true);
		plateInfo.setBackground(Color.MAGENTA);
		
		plateInfo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				plateInfo.setText("Click on a roll at any time to select it.");
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			plabel.setMinimumSize(new Dimension(300, 20));
			plabel.setPreferredSize(new Dimension(300, 20));
			plabel.setOpaque(true);
			plabel.setBackground(Color.GRAY);
			
			plabel.addMouseListener(new MouseListener() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	for(int i = 0; i < belt.getSize(); i++) {					
						if(belt_labels[i].equals(plabel) && belt_labels != null && plateInfo != null && belt != null) {
							
							plateInfo.update(belt, i);
						}
					}
		        }

				@Override
				public void mouseEntered(MouseEvent arg0) {
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		    });
			
			add(plabel);
			belt_labels[i] = plabel;
		}
		add(spacer);
		add(plateInfo);
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		for (int i=0; i<belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JLabel plabel = belt_labels[i];
			
			if (p == null) {
				plabel.setText("");
				plabel.setBackground(Color.GRAY);
			} else {
				plabel.setText(p.getChef().getName());
				switch (p.getColor()) {
				case RED:
					plabel.setBackground(Color.RED); 
					plabel.setForeground(Color.WHITE);
					break;
				case GREEN:
					plabel.setBackground(Color.GREEN); 
					plabel.setForeground(Color.BLACK);
					break;
				case BLUE:
					plabel.setBackground(Color.BLUE); 
					plabel.setForeground(Color.WHITE);
					break;
				case GOLD:
					plabel.setBackground(Color.YELLOW);
					plabel.setForeground(Color.BLACK);
					break;
				}
			}
		}
	}
}
