package bo.Card;

public class Deck_card {
	private int id;
	private int card_id;
	private int deck_id;
	
	Deck_card(int card_id, int deck_id) {
		this.id += 1;
		this.card_id = card_id;
		this.deck_id = deck_id;
	}
}
