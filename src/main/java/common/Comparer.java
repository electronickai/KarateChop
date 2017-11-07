package common;

public class Comparer {


    public static boolean elementIsBigger(int toSearch, int element) {
        return element > toSearch;
    }

    public static boolean elementIsFound(int toSearch, int element) {
        return toSearch == element;
    }
}
