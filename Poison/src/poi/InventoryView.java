package poi;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;
import poi.Poison.Views;

public class InventoryView extends GContainer {
	private Inventory inventory;

	public InventoryView() {
		setSize(854, 480);

		inventory = new Inventory();
		inventory.setAnchorTopLeft();
		addAt(inventory, 10, 47);

		this.setBackgroundColor(Color.WHITE);
		GButton menu = createButton("Back");
		menu.setAnchorTopLeft();
		ButtonListener mbl = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.MAIN);
			}
		};
		menu.addListener(mbl);
		addAt(menu, 10, 10);
	}

	public GButton createButton(String buttonText) {
		final GButton btn = new GButton();
		btn.setStateSprite(ButtonState.NONE,
				createButtonSprite("buttonnone.png"));
		btn.setStateSprite(ButtonState.HOVERED,
				createButtonSprite("buttonhovered.png"));
		btn.setStateSprite(ButtonState.PRESSED,
				createButtonSprite("buttonpressed.png"));

		btn.setSize(102, 27);

		GMessage gm = new GMessage(buttonText);
		gm.setSize(btn.getWidth(), btn.getHeight());
		gm.setAlignmentX(0.5);
		gm.setAlignmentY(0.5);
		gm.setFontSize(15);
		gm.setColor(Color.BLACK);
		btn.addAtCenter(gm);
		return btn;

	}

	public static GSprite createButtonSprite(String fn) {
		BufferedImage img = ImageCache.forClass(Poison.class).get(fn);
		GSprite gs = new GSprite(img);

		Rectangle nineSliceCenter = new Rectangle(15, 15, 6, 6);
		gs.setNineSliceCenter(nineSliceCenter);
		return gs;
	}

}
