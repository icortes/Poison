package poi;

import java.awt.Color;
import java.util.ArrayList;

import jgame.GContainer;
import jgame.GMessage;

public class Inventory extends GContainer {

	private ArrayList<String> items = new ArrayList<String>();
	private ArrayList<Integer> itemCount = new ArrayList<Integer>();

	public Inventory() {
		setSize(732, 420);
		setBackgroundColor(Color.LIGHT_GRAY);
		items.add("food");
		items.add("torch");
		items.add("gun");

		for (int i = 0; i < items.size(); i++) {
			GMessage itemName = new GMessage(items.get(i) + ":");
			itemName.setAnchorTopLeft();
			itemName.setFontSize(15);
			this.addAt(itemName, 5, (i * 18) + 5);
		}
	}
}
