import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Preference {
    String object;
    double value;

    Preference(String object, double value) {
        this.object = object;
        this.value = value;
    }
}

public class PreferenceSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Preference> preferences = new ArrayList<>();

        System.out.println("Enter the number of preferences:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter object " + (i + 1) + ":");
            String object = scanner.nextLine();
            System.out.println("Enter preference value for " + object + " (0 to 1):");
            double value = scanner.nextDouble();
            scanner.nextLine();

            preferences.add(new Preference(object, value));
        }

        preferences.sort(Comparator.comparingDouble(p -> p.value));

        System.out.println("Sorted preferences:");
        for (Preference p : preferences) {
            System.out.println(p.object + ": " + p.value);
        }

        ArrayList<Preference> favorites = new ArrayList<>();
        for (Preference p : preferences) {
            if (p.value >= 0.5) {
                favorites.add(p);
            }
        }

        System.out.println("For the given preference space P,");
        for (Preference f : favorites) {
            System.out.println(f.object + " is an element of a subset of P, which shall be denoted by the term 'favorites', such that pref(favorites) <= pref(S), for any S ⊆ P with |S| > |favorites|.");
        }

        scanner.close();
    }
}