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

public class PoisonMainView extends GContainer {
	private PlayArea pa;

	public PoisonMainView() {
		setSize(854, 480);
		this.setBackgroundColor(Color.WHITE);

		pa = new PlayArea();
		pa.setAnchorCenter();
		this.addAtCenter(pa);

		GButton inventory = createButton("Inventory");
		inventory.setAnchorPosition(inventory.getWidth(), 0);
		ButtonListener ibl = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.INVENTORY);
			}

		};
		inventory.addListener(ibl);
		this.addAt(inventory, getWidth() - 10, 10);

		GButton exit = createButton("Exit");
		exit.setAnchorTopLeft();
		ButtonListener ebl = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				System.exit(0);
			}
		};
		exit.addListener(ebl);
		this.addAt(exit, 10, 10);

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
