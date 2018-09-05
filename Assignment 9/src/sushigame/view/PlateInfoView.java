package sushigame.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import comp401.sushi.Plate;
import sushigame.model.Belt;

public class PlateInfoView extends JLabel{
	
	
	public PlateInfoView(String s) {
		super(s);
	}
	
	public void update(Belt b, int position) {
		if(b != null && b.getPlateAtPosition(position) != null) {
			String ingredients = "";
			if(!b.getPlateAtPosition(position).getContents().getName().contains("sashimi") && !b.getPlateAtPosition(position).getContents().getName().contains("nigiri")) {
				for(int i = 0; i < b.getPlateAtPosition(position).getContents().getIngredients().length; i++) {
					ingredients += b.getPlateAtPosition(position).getContents().getIngredients()[i].getName() + ": " +
							b.getPlateAtPosition(position).getContents().getIngredients()[i].getAmount() + " ounces <br>";
				}
			}
			this.setText("Hover here for information about selected plate.");
			
			this.setToolTipText("<html>Age: " + b.getAgeOfPlateAtPosition(position) + "<br>"
					+ b.getPlateAtPosition(position).getContents().getName() + "<br>"
					+ ingredients);
		}
	}
}
