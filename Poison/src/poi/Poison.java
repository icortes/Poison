package poi;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;

public class Poison extends Game {

	public Poison() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);
		PoisonMainView pmv = new PoisonMainView();
		InventoryView iv = new InventoryView();

		root.addView(Views.MAIN, pmv);
		root.addView(Views.INVENTORY, iv);
	}

	public static void main(String[] args) {
		ImageCache.create(Poison.class, "/rsc/");
		Poison p = new Poison();
		p.startGame("Poison");
	}

	public enum Views {
		// These are all of the views for this game
		MAIN, INVENTORY;
	}

}
