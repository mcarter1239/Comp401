package sushigame.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import comp401.sushi.AvocadoPortion;
import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.RicePortion;
import comp401.sushi.Roll;
import comp401.sushi.SalmonPortion;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private String color;
	private double price;
	private Sushi sushi;
	private int belt_size;
	private String rollName = null;
	private double avocado = 0;
	private double crab = 0;
	private double eel = 0;
	private double rice = 0;
	private double salmon = 0;
	private double seaweed = 0;
	private double shrimp = 0;
	private double tuna = 0;
	private int rollIngredientsCount = 0;
	
	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		reset();
	}

	public void reset() {
		this.removeAll();
		
		JButton redPlateButton = new JButton("Make red plate");
		redPlateButton.setActionCommand("red");
		redPlateButton.addActionListener(this);
		add(redPlateButton);
		
		JButton bluePlateButton = new JButton("Make blue plate");
		bluePlateButton.setActionCommand("blue");
		bluePlateButton.addActionListener(this);
		add(bluePlateButton);
		
		JButton greenPlateButton = new JButton("Make green plate");
		greenPlateButton.setActionCommand("green");
		greenPlateButton.addActionListener(this);
		add(greenPlateButton);
		
		JButton goldPlateButton = new JButton("Make gold plate");
		goldPlateButton.setActionCommand("gold");
		goldPlateButton.addActionListener(this);
		add(goldPlateButton);
		
		this.validate();
		this.repaint();
	}
	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}
	
	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "red":
			this.color = "red";
			buttonChangeColor();
			break;
		case "blue":
			this.color = "blue";
			buttonChangeColor();
			break;
		case "green":
			this.color = "green";
			buttonChangeColor();
			break;
		case "gold":
			this.color = "gold";
			buttonChangeColor();
			break;
		case "sashimi":
			makeSashimi();
			break;
		case "nigiri":
			makeNigiri();
			break;
		case "roll":
			makeRoll();
			break;
		case "sashimiEel":
			sushi = new Sashimi(Sashimi.SashimiType.EEL);
			buttonChangeSushi();
			break;
		case "sashimiCrab":
			sushi = new Sashimi(Sashimi.SashimiType.CRAB);
			buttonChangeSushi();
			break;
		case "sashimiSalmon":
			sushi = new Sashimi(Sashimi.SashimiType.SALMON);
			buttonChangeSushi();
			break;
		case "sashimiShrimp":
			sushi = new Sashimi(Sashimi.SashimiType.SHRIMP);
			buttonChangeSushi();
			break;
		case "sashimiTuna":
			sushi = new Sashimi(Sashimi.SashimiType.TUNA);
			buttonChangeSushi();
			break;
		case "nigiriEel":
			sushi = new Nigiri(Nigiri.NigiriType.EEL);
			buttonChangeSushi();
			break;
		case "nigiriCrab":
			sushi = new Nigiri(Nigiri.NigiriType.CRAB);
			buttonChangeSushi();
			break;
		case "nigiriSalmon":
			sushi = new Nigiri(Nigiri.NigiriType.SALMON);
			buttonChangeSushi();
			break;
		case "nigiriShrimp":
			sushi = new Nigiri(Nigiri.NigiriType.SHRIMP);
			buttonChangeSushi();
			break;
		case "nigiriTuna":
			sushi = new Nigiri(Nigiri.NigiriType.TUNA);
			buttonChangeSushi();
			break;
		}
	}
	
	public void buttonChangeColor() {
		this.removeAll();

		JButton sashimiButton = new JButton("Sashimi");
		sashimiButton.setActionCommand("sashimi");
		sashimiButton.addActionListener(this);		
		add(sashimiButton);
		
		JButton nigiriButton = new JButton("Nigiri");
		nigiriButton.setActionCommand("nigiri");
		nigiriButton.addActionListener(this);
		add(nigiriButton);
		
		JButton rollButton = new JButton("Roll");
		rollButton.setActionCommand("roll");
		rollButton.addActionListener(this);
		add(rollButton);
		
		this.validate();
		this.repaint();
	}
	
	public void buttonChangeSushi() {
		this.removeAll();
		
	
		JLabel prompt = new JLabel("<html>Enter a number from 0 to " + (belt_size - 1) + " and your roll will be placed there.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Integer.parseInt(textField.getText()) >= 0 && Integer.parseInt(textField.getText()) < belt_size) {
					reset();
					finalRollAtPosition(Integer.parseInt(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();	    
	}
	
	protected void finalRollAtPosition(int i) {
		if(this.color.equals("red")) {
			this.makeRedPlateRequest(sushi, i);
			reset();
		} else if(this.color.equals("blue")) {
			this.makeBluePlateRequest(sushi, i);
			reset();
		} else if(this.color.equals("green")) {
			this.makeGreenPlateRequest(sushi, i);
			reset();
		} else {
			priceChooser(i);
		}
	}
	
	public void priceChooser(int i) {
		this.removeAll();
				
		JLabel prompt = new JLabel("<html>Enter a number from 5.00 to 10.00 and your plate will cost that much.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(5);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 5.00 && Double.parseDouble(textField.getText()) <= 10.00) {
					goldPlateMaker(Double.parseDouble(textField.getText()), i);
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
	}

	protected void goldPlateMaker(double d, int i) {
		this.makeGoldPlateRequest(sushi, i, d);
		reset();
		
	}

	public void makeSashimi() {
		this.removeAll();
		
		JButton eelButton = new JButton("Eel");
		eelButton.setActionCommand("sashimiEel");
		eelButton.addActionListener(this);		
		add(eelButton);
		
		JButton tunaButton = new JButton("Tuna");
		tunaButton.setActionCommand("sashimiTuna");
		tunaButton.addActionListener(this);		
		add(tunaButton);
		
		JButton salmonButton = new JButton("Salmon");
		salmonButton.setActionCommand("sashimiSalmon");
		salmonButton.addActionListener(this);		
		add(salmonButton);
		
		JButton crabButton = new JButton("Crab");
		crabButton.setActionCommand("sashimiCrab");
		crabButton.addActionListener(this);		
		add(crabButton);
		
		JButton shrimpButton = new JButton("Shrimp");
		shrimpButton.setActionCommand("sashimiShrimp");
		shrimpButton.addActionListener(this);		
		add(shrimpButton);
	
		this.validate();
		this.repaint();
	}
	
	public void makeNigiri() {
		this.removeAll();
		
		JButton eelButton = new JButton("Eel");
		eelButton.setActionCommand("nigiriEel");
		eelButton.addActionListener(this);		
		add(eelButton);
		
		JButton tunaButton = new JButton("Tuna");
		tunaButton.setActionCommand("nigiriTuna");
		tunaButton.addActionListener(this);		
		add(tunaButton);
		
		JButton salmonButton = new JButton("Salmon");
		salmonButton.setActionCommand("nigiriSalmon");
		salmonButton.addActionListener(this);		
		add(salmonButton);
		
		JButton crabButton = new JButton("Crab");
		crabButton.setActionCommand("nigiriCrab");
		crabButton.addActionListener(this);		
		add(crabButton);
		
		JButton shrimpButton = new JButton("Shrimp");
		shrimpButton.setActionCommand("nigiriShrimp");
		shrimpButton.addActionListener(this);		
		add(shrimpButton);
	
		this.validate();
		this.repaint();
	}
	
	public void makeRoll() {
		promptRollName();
	}

	private void promptRollName() {
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter a name for your roll.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(50);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				avocado(textField.getText());
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
		
	}

	protected void avocado(String text) {
		this.rollName = text;
		
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of avocado from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					crab(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
		
	}

	protected void crab(double parseDouble) {
		this.avocado = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of crab from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					eel(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
	}

	protected void eel(double parseDouble) {
		this.crab = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of eel from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					rice(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
		
	}

	protected void rice(double parseDouble) {
		this.eel = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of rice from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					salmon(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
		
	}

	protected void salmon(double parseDouble) {
		this.rice = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of salmon from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					seaweed(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
		
	}

	protected void seaweed(double parseDouble) {
		this.salmon = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of seaweed from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					shrimp(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
		
	}

	protected void shrimp(double parseDouble) {
		this.seaweed = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of shrimp from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					tuna(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
	}

	protected void tuna(double parseDouble) {
		this.shrimp = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		this.removeAll();
		
		JLabel prompt = new JLabel("<html>Enter an amount of tuna from 0 to 1.5 ounces.</html>");
	    add(prompt);
		JTextField textField = new JTextField("");
		textField.setColumns(3);

	    textField.setVisible(true);
	    add(textField);
	    
	    JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("position");
		submitButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent ae) {
				if(Double.parseDouble(textField.getText()) >= 0 && Double.parseDouble(textField.getText()) <= 1.5) {
					roll(Double.parseDouble(textField.getText()));
				}
	        }
		});
		add(submitButton);
	    
		this.validate();
		this.repaint();
	}

	@SuppressWarnings("unused")
	protected void roll(double parseDouble) {
		this.tuna = parseDouble;
		if(parseDouble > 0) {
			this.rollIngredientsCount++;
		}
		if(rollIngredientsCount == 0) {
			reset();
		}
		IngredientPortion[] temp = null;
		if(avocado > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new AvocadoPortion(avocado)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new AvocadoPortion(avocado);
			}
		}
		if(crab > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new CrabPortion(crab)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new CrabPortion(crab);
			}
		}
		if(eel > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new EelPortion(eel)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new EelPortion(eel);
			}
		}
		if(rice > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new RicePortion(rice)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new RicePortion(rice);
			}
		}
		if(salmon > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new SalmonPortion(salmon)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new SalmonPortion(salmon);
			}
		}
		if(seaweed > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new SeaweedPortion(seaweed)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new SeaweedPortion(seaweed);
			}
		}
		if(shrimp > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new ShrimpPortion(shrimp)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new ShrimpPortion(shrimp);
			}
		}
		if(tuna > 0) {
			if(temp == null) {
				temp = new IngredientPortion[] {new TunaPortion(tuna)};
			} else {
				int tempIndex = temp.length;
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[tempIndex] = new TunaPortion(tuna);
			}
		}
		this.sushi = new Roll(rollName, temp);
		
		buttonChangeSushi();
	}
	
}