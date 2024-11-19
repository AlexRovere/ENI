package bo.Card;

import java.util.List;

public class Formats {
	private int id;
	private int card_id;
	private int deck_id;
	private String name;
	private List<Decks> decks;
	private List<Cards> cards;
	
	public Formats(String name) {
		super();
		this.id++;
		this.name = name;
	}
	
	public void setCardId(int card_id) {
		this.card_id = card_id;
	}
	
	public void setDeckId(int deck_id) {
		this.deck_id = deck_id;
	}
	
	public void addDecks(List<Decks> decks) {
		if (decks != null) {
			for (Decks deck : decks) {
				this.decks.add(deck);
			}
		}
	}
	
	public void addCards(List<Cards> cards) {
		if (cards != null) {
			for (Cards card : cards) {
				this.cards.add(card);
			}
		}
	
	}
	
	public String getName() {
		return this.name;
	}
	
}
