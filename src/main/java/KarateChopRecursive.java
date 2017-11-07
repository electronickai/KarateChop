import common.Chopper;
import common.Comparer;

import java.util.List;

/**
 * Call the chop method recursively. The idea is that the task can be performed on each
 * sub list in the same manner as for the complete list (therefore it is probably the first idea of most developers)
 */
public class KarateChopRecursive {
    public int chop (final int toSearch, final List<Integer> list) {
        if (list.isEmpty()){
            return -1;
        }

        if (list.size() == 1) {
            return Comparer.elementIsFound(toSearch, list.get(0)) ? 0 : -1;
        }

        int indexMiddle = list.size() / 2;
        Integer elementMiddle = list.get(indexMiddle);

        if (Comparer.elementIsFound(toSearch, elementMiddle)) {
            return indexMiddle;
        }

        if (Comparer.elementIsBigger(toSearch, elementMiddle)) {
            return searchInFirstHalf(toSearch, list);
        }
        else {
            return searchInSecondHalf(toSearch, list);
        }
    }

    private int searchInFirstHalf(final int toSearch, final List<Integer> list) {
        int indexMiddle = list.size() / 2;
        List<Integer> sublist = Chopper.retrieveSubListFront(list, indexMiddle);
        int indexOfSublist = chop(toSearch, sublist);
        return indexOfSublist == -1 ? -1 : indexOfSublist;
    }

    private int searchInSecondHalf(final int toSearch, final List<Integer> list) {
        int indexMiddle = list.size() / 2;
        List<Integer> sublist = list.subList(indexMiddle, list.size());
        int indexOfSublist = chop(toSearch, sublist);
        return indexOfSublist == -1 ? -1 : indexMiddle + indexOfSublist;
    }
}