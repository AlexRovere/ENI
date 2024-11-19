package bo.Card;

import java.util.ArrayList;
import java.util.List;

public class Decks {
	private int id;
	private String name;
	private String sleeve;
	private String avatar;
	private List<Formats> formats = new ArrayList<Formats>();
	private List<Deck_card> deck_cards = new ArrayList<Deck_card>();

	public Decks(int id, String name, String sleeve, String avatar, List<Formats> formats, List<Deck_card> deck_cards) {
		super();
		this.id = id;
		this.name = name;
		this.sleeve = sleeve;
		this.avatar = avatar;
		this.addFormats(formats);
		this.addDeckCard(deck_cards);
	}

	public void addFormats(List<Formats> formats) {
		if (formats != null) {
			for (Formats format : formats) {
				this.formats.add(format);
			}
		}
	}
	
	public void addDeckCard(List<Deck_card> deck_cards) {
		if (deck_cards != null) {
			for (Deck_card deck_card : deck_cards) {
				this.deck_cards.add(deck_card);
			}
		}
	}

}
