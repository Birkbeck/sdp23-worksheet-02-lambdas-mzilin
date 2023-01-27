import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Outline <T extends Comparable<T>> {

  public static void main(String... args) { // varargs alternative to String[]
    String[] names, cities;
    Integer[] numbers;
    String res;


    // Exercise 1
    System.out.println("- Exercise 1");
    System.out.println("- Sorting arrays by length:");
    names = getNames();
    Arrays.sort(names, Comparator.comparingInt(String::length));
    System.out.println(Arrays.toString(names));

    cities = getCities();
    Arrays.sort(cities, Comparator.comparingInt(String::length));
    System.out.println(Arrays.toString(cities));
    System.out.println("--------------------------------");

    System.out.println("- Sorting arrays by reverse length:");
    names = getNames();
    Arrays.sort(names, (s1, s2) -> s2.length() - s1.length());
    System.out.println(Arrays.toString(names));

    cities = getCities();
    Arrays.sort(cities, (s1, s2) -> s2.length() - s1.length());
    System.out.println(Arrays.toString(cities));
    System.out.println("--------------------------------");

    System.out.println("- Sorting arrays by first character:");
    names = getNames();
    Arrays.sort(names, Comparator.comparingInt(Outline::getFirstLetter));
    System.out.println(Arrays.toString(names));

    cities = getCities();
    Arrays.sort(cities, Comparator.comparingInt(Outline::getFirstLetter));
    System.out.println(Arrays.toString(cities));
    System.out.println("--------------------------------");

    System.out.println("- Sorting arrays by strings that contain \"e\" first, everything else second:");
    names = getNames();
    Arrays.sort(names, Outline::containsEFirst);
    System.out.println(Arrays.toString(names));

    cities = getCities();
    Arrays.sort(cities, Outline::containsEFirst);
    System.out.println(Arrays.toString(cities));
    System.out.println("--------------------------------");


    // Exercise 2
    // Already did it in previous example
    System.out.println("- Exercise 2");
    System.out.println("- Sorting arrays by first character:");
    names = getNames();
    Arrays.sort(names, Comparator.comparingInt(Outline::getFirstLetter));
    System.out.println(Arrays.toString(names));
    System.out.println("--------------------------------");


    // Exercise 3
    System.out.println("- Exercise 3");
    System.out.println("- Finding better string:");
    BiFunction<String, String, Integer> TwoStringPredicate = String::compareTo;

    res = Outline.betterString("better", "WORSE", TwoStringPredicate);
    System.out.println(res);

    res = Outline.betterString("WORSE", "better", TwoStringPredicate);
    System.out.println(res);
    System.out.println("--------------------------------");


    // Exercise 4
    System.out.println("- Exercise 4");
    System.out.println("- Finding better string with betterEntry:");
    GenericUtils<String> stringUtils = new GenericUtils<>();

    res = Outline.betterEntry("better", "WORSE", stringUtils.TwoElementPredicate);
    System.out.println(res);

    res = Outline.betterEntry("WORSE", "better", stringUtils.TwoElementPredicate);
    System.out.println(res);


    // Somehow compiler was complaining when I was trying to put this BiFunction inside
    // main method. The only workaround I found is putting this BiFunction
    // inside a static class and initiating it
    //
    // WHAT I WAS DOING WRONG?
    GenericUtils<Integer> intUtils = new GenericUtils<>();

    int res2 = Outline.betterEntry(1, 100, intUtils.TwoElementPredicate);
    System.out.println(res2);

    res2 = Outline.betterEntry(100, 1, intUtils.TwoElementPredicate);
    System.out.println(res2);
    System.out.println("--------------------------------");


    // Exercise 5
    System.out.println("- Exercise 5");
    System.out.println("- Finding all matches:");
    names = getNames();
    List<String> shortNames = Outline.allMatches(Arrays.asList(names), s -> s.length() < 4);
    System.out.println("shortNames: " + shortNames);
    List<String> namesWithB = Outline.allMatches(Arrays.asList(names), s -> s.contains("b"));
    System.out.println("namesWithB: " + namesWithB);
    List<String> evenLengthNames = Outline.allMatches(Arrays.asList(names), s -> (s.length() % 2) == 0);
    System.out.println("evenLengthNames: " + evenLengthNames);

    cities = getCities();
    List<String> shortCities = Outline.allMatches(Arrays.asList(cities), s -> s.length() < 4);
    System.out.println("shortCities: " + shortCities);
    List<String> citiesWithB = Outline.allMatches(Arrays.asList(cities), s -> s.contains("b"));
    System.out.println("citiesWithB: " + citiesWithB);
    List<String> evenLengthCities = Outline.allMatches(Arrays.asList(cities), s -> (s.length() % 2) == 0);
    System.out.println("evenLengthCities: " + evenLengthCities);
    System.out.println("--------------------------------");


    // Exercise 6
    System.out.println("- Exercise 6");
    System.out.println("- Finding all generic matches:");
    names = getNames();
    shortNames = Outline.allGenericMatches(Arrays.asList(names), s -> s.length() < 4);
    System.out.println("shortNames: " + shortNames);
    namesWithB = Outline.allGenericMatches(Arrays.asList(names), s -> s.contains("b"));
    System.out.println("namesWithB: " + namesWithB);
    evenLengthNames = Outline.allGenericMatches(Arrays.asList(names), s -> (s.length() % 2) == 0);
    System.out.println("evenLengthNames: " + evenLengthNames);

    numbers = getNumbers();
    List<Integer> smallNumbers = Outline.allGenericMatches(Arrays.asList(numbers), n -> n < 4);
    System.out.println("smallNumbers: " + smallNumbers);
    List<Integer> bigNumbers = Outline.allGenericMatches(Arrays.asList(numbers), n -> n > 7);
    System.out.println("bigNumbers: " + bigNumbers);
    System.out.println("--------------------------------");


    // Exercise 7
    System.out.println("- Exercise 7");
    System.out.println("- Creating a transformed list:");
    names = getNames();
    List<String> excitingNames = Outline.transformedList(Arrays.asList(names), s -> s + "!");
    System.out.println("excitingNames: " + excitingNames);
    List<String> eyeNames = Outline.transformedList(Arrays.asList(names), s -> s.replace("i", "eye"));
    System.out.println("eyeNames: " + eyeNames);
    List<String> upperCaseNames = Outline.transformedList(Arrays.asList(names), String::toUpperCase);
    System.out.println("upperCaseNames: " + upperCaseNames);

    cities = getCities();
    List<String> excitingCities = Outline.transformedList(Arrays.asList(cities), s -> s + "!");
    System.out.println("excitingCities: " + excitingCities);
    List<String> eyeCities = Outline.transformedList(Arrays.asList(cities), s -> s.replace("i", "eye"));
    System.out.println("eyeCities: " + eyeCities);
    List<String> upperCaseCities = Outline.transformedList(Arrays.asList(cities), String::toUpperCase);
    System.out.println("upperCaseCities: " + upperCaseCities);
    System.out.println("--------------------------------");


    // Exercise 8
    System.out.println("- Exercise 8");
    System.out.println("- Creating a transformed list for generic types:");
    names = getNames();
    excitingNames = Outline.transformedGenericList(Arrays.asList(names), s -> s + "!");
    System.out.println("excitingNames: " + excitingNames);
    eyeNames = Outline.transformedGenericList(Arrays.asList(names), s -> s.replace("i", "eye"));
    System.out.println("eyeNames: " + eyeNames);
    upperCaseNames = Outline.transformedGenericList(Arrays.asList(names), String::toUpperCase);
    System.out.println("upperCaseNames: " + upperCaseNames);

    numbers = getNumbers();
    List<Integer> allOnes = Outline.transformedGenericList(Arrays.asList(numbers), n -> 1);
    System.out.println("allOnes: " + allOnes);
    List<Integer> multipliedByTwo = Outline.transformedGenericList(Arrays.asList(numbers), n -> n * 2);
    System.out.println("multipliedByTwo: " + multipliedByTwo);
  }

  /**
   * For Exercises 1, 2
   */
  static char getFirstLetter(String s) {
    return s.charAt(0);
  }

  static int containsEFirst(String s1, String s2) {
    if (s1.contains("e")) {
      return s2.contains("e") ? 0 : -1;
    }
    return s2.contains("e") ? 1 : 0;
  }

  /**
   * For Exercise 3
   */
  static String betterString(String s1, String s2, BiFunction<String, String, Integer> pred) {
    return pred.apply(s1, s2) > 0 ? s1 : s2;
  }

  /**
   * For Exercise 4
   */
  static <T> T betterEntry(T t1, T t2, BiFunction<T, T, Integer> pred) {
    return pred.apply(t1, t2) > 0 ? t1 : t2;
  }

  static class GenericUtils<T extends Comparable<T>> {
    BiFunction<T, T, Integer> TwoElementPredicate = Comparable::compareTo;
  }

  /**
   * For Exercise 5
   */
  static List<String> allMatches(List<String> ls, Predicate<String> pred) {
    List<String> matches = new ArrayList<>();

    for (String word : ls) {
      if (pred.test(word)) matches.add(word);
    }

    return matches;
  }

  /**
   * For Exercise 6
   */
  static <T> List<T> allGenericMatches(List<T> ls, Predicate<T> pred) {
    List<T> matches = new ArrayList<>();

    for (T word : ls) {
      if (pred.test(word)) matches.add(word);
    }

    return matches;
  }

  /**
   * For Exercise 7
   */
  static List<String> transformedList(List<String> ls, Function<String, String> fn) {
    List<String> list = new ArrayList<>();

    for (String word : ls) {
      list.add(fn.apply(word));
    }

    return list;
  }

  /**
   * For Exercise 8
   */
  static <T> List<T> transformedGenericList(List<T> ls, Function<T, T> fn) {
    List<T> list = new ArrayList<>();

    for (T word : ls) {
      list.add(fn.apply(word));
    }

    return list;
  }


  // ------------------

  static String[] getCities() {
    return new String[]{
            "London", "Cardiff", "Rome", "Birmingham", "Glasgow", "Belfast", "Dublin", "Madrid",
            "Oslo", "Warsaw", "Moscow", "Stockholm", "Bonn", "Berlin", "Paris", "Vienna", "Athens"
    };
  }

  static String[] getNames() {
    return new String[]{
            "Amy", "Bob", "Eddy", "Dave", "Fred", "Mary", "Jane", "Mo", "Julie", "abby", "Bo", "Roger", "peter",
            "Greg", "Steve", "Stu", "Richard", "Jules", "Dee", "Imran", "Ingrid", "Santos", "Raj", "patty", "Eve",
            "Tan", "Stan", "George", "Jerry", "Gustav", "Wendy", "Zoe", "Dan", "Doc", "Po", "Daz", "Cat", "ezzy", "Pru"
    };
  }

  static Integer[] getNumbers() {
    return new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  }
}