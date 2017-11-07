import common.Comparer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * I had the idea about using streams in order to solve the issue. However, with streams it doesn't seem to be
 * very easy to split the lists in two parts. After my first tries, I can imagine that streams aren't really
 * appropriate in splitting the lists apart. Splitting them is some kind of implementation of the solution.
 * Using Streams is rather declarative, though. Therefore, I abondoned this try for the moment.
 */
public class KarateChopStream {

    public int chop(final int toSearch, final List<Integer> list) {

        if (!contains(list, toSearch)) {
            return -1;
        }

        int element = getElementInTheMiddle(list);
        if (Comparer.elementIsFound(toSearch, element)) {
            return list.size() / 2;
        }

        List<Integer> sublist;
        if (Comparer.elementIsBigger(toSearch, element)) {
            sublist = getFirstHalfOfList(list);
        }
        else {
            sublist = getSecondHalfOfList(list);
        }

        return -1;
    }

    private Integer getElementInTheMiddle(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        return list.get(list.size()/2);
    }

    private List<Integer> getFirstHalfOfList(List<Integer> list) {
        return list.stream().limit(list.size()/2).collect(Collectors.toList());
    }

    private List<Integer> getSecondHalfOfList(List<Integer> list) {
        return null;
    }

    private boolean contains(List<Integer> list, int toSearch) {
        return list.stream().anyMatch((elem) -> elem == toSearch);
    }
}