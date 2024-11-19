package bo.Card;

public class Costs {
		private int id;
		private int card_id;
		private int skill_id;
		private EColors color;
		private int quantity;
		
		public Costs(EColors color, int quantity) {
			super();
			this.id++;
			this.color = color;
			this.quantity = quantity;
		}
		
		public void setSkillId (int skill_id) {
			this.skill_id = skill_id;
		}
		
		public void setCardId (int card_id) {
			this.card_id = card_id;
		}
		
		public String getColor() {
			return this.color.getLabel();
		}
		
		public String getQuantity() {
			return String.valueOf(this.quantity);
		}
		
		
}
