
import java.util.ArrayList;import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TestsStreamApi {

	public static void main(String[] args) {
		List<Chanson> chansons = new ArrayList<Chanson>(List.of(new Chanson("Space Oddity", "David Bowie", 5.17),
				new Chanson("Paint It, Black", "The Rolling Stones", 3.22),
				new Chanson("Smoke On The Water", "Deep Purple", 5.40), new Chanson("Cocaine", "Eric Clapton", 3.36),
				new Chanson("Englishman In New York", "Sting", 4.26), new Chanson("Mojo", "M", 3.16),
				new Chanson("Battez-vous", "Brigitte", 4.04), new Chanson("Frida", "Sanseverino", 4.08),
				new Chanson("Demons", "Imagine Dragons", 2.57), new Chanson("Supersonic", "Oasis", 4.44),
				new Chanson("Boulevard of Broken Dreams", "Green Day", 4.21),
				new Chanson("Come Out and Play", "The Offspring", 3.17),
				new Chanson("Under the Bridge", "Red Hot Chili Peppers", 4.25),
				new Chanson("Come As You Are", "Nirvana", 3.38), new Chanson("Nothing Else Matters", "Metallica", 6.28),
				new Chanson("Sympathy For The Devil", "Motorhead", 5.26),
				new Chanson("You Really Got Me", "Van Halen", 2.36),
				new Chanson("Knockin' On Heaven's Door", "Guns N' Roses", 5.36)));

		
		//Enoncés
		System.out.println("Afficher les chansons de M, Brigitte et Sanseverino");
		List<Chanson> chansonsBrigitte = chansons.stream()
				.filter(c -> c.getChanteur().equals("M") ||  c.getChanteur().equals("Brigitte") ||  c.getChanteur().equals("Sanseverino"))
				.collect(Collectors.toList());
				
				System.out.println(chansonsBrigitte);
		
		System.out.println("Est-ce que toutes les chansons durent minimum 2 minutes?");
		
		Boolean allSongSuperiorTo2mn = chansons.stream()
.mapToDouble(c -> c.getDuree()).allMatch(n -> n > 2D);
		System.out.println(allSongSuperiorTo2mn);

		System.out.println("Est-ce que toutes les chansons durent minimum 3 minutes?");
		Boolean allSongSuperiorTo3mn = chansons.stream()
.mapToDouble(c -> c.getDuree()).allMatch(n -> n > 3D);
		System.out.println(allSongSuperiorTo3mn);

		System.out.println("Est-ce qu'au moins une chanson dure plus de 6 minutes?");
		Boolean oneSongMoreThan6mn = chansons.stream()
				.mapToDouble(c -> c.getDuree()).anyMatch(n -> n > 6);
		System.out.println(oneSongMoreThan6mn);

		System.out.println("Quelle est la durée moyenne d'une chanson?");
		OptionalDouble averageSongDuration = chansons.stream()
				.mapToDouble(c -> c.getDuree()).average();
		if (averageSongDuration.isPresent()) {
			System.out.println(averageSongDuration);

		}
		System.out.println("Quelle est la chanson la plus courte?");
		Chanson shortSong = chansons.stream().mapToDouble(c -> c.getDuree())
				.min().collect(Collectors.toList());

	}

}
