package poi;

import java.awt.Color;

import jgame.GContainer;

public class PlayArea extends GContainer {

	public PlayArea() {
		setSize(610, 440);
		setBackgroundColor(Color.LIGHT_GRAY);

		TextBox tb = new TextBox();
		tb.setAnchorTopLeft();
		addAt(tb, 0, 260);
	}
}
