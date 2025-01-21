package animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Main {
	public static void main(String[] args) {

		Animal animal = new Animal();
		Animal chien = new Chien();
		Animal chat = new Chat();

		animal.manger();
		chien.manger();
		chat.manger();

	}
}
