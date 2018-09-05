package a2jedi;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	String name;
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public MenuItem(String name) {
		this.name = name;
	}
}
