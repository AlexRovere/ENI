import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Personne p1 = new Personne("alex", 18, LocalDate.of(1990, 9, 01));
		Personne p2 = new Personne("bob", 35, LocalDate.of(1985, 1, 01));
		Personne p3 = new Personne("antoine", 25, LocalDate.of(1999, 4, 01));
		
		List<Personne> liste = new ArrayList<Personne>();
		
		for(int i = 0; i < 10000; i++) {
			liste.add(new Personne("alex", 18, LocalDate.of(1990, 9, 01)));
		}

		liste.addAll(Arrays.asList(p1, p2, p3));

		System.out.println(liste);

		liste.sort((Personne a, Personne b) -> a.getAge() - b.getAge());

		List<Personne> listSorted = new ArrayList<>();

		listSorted = liste.stream().sorted(Comparator.comparing(Personne::getNom)).collect(Collectors.toList());

		System.out.println(listSorted);
		long start = System.currentTimeMillis();
		liste.replaceAll(p -> {
		//	Personne newP = new Personne(p.getNom().toUpperCase(), p.getAge() + 1, p.getDateNaissance());
			p.setAge(p.getAge() + 1);
			p.setNom(p.getNom().toUpperCase());

			return p;
		});
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println(timeElapsed);

	}

}
