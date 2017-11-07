import common.Comparer;
import common.Chopper;

import java.util.List;

/**
 * Check the list elements iteratively using a do-while loop. Within this loop it is checked which sub list
 * has to be processed next and the position is updated simultaneously.
 */
public class KarateChopLoop {

    public int chop(final int toSearch, final List<Integer> list) {

        if (list.size() == 0) {
            return -1;
        }

        if (list.size() == 1) {
            return Comparer.elementIsFound(toSearch, list.get(0)) ? 0 : -1;
        }
        return findByCheckingAllRelevantSublists(toSearch, list);
    }

    private static int findByCheckingAllRelevantSublists(int toSearch, List<Integer> list) {
        List<Integer> nextSublist = list;
        int position = 0;

        do {
            int indexMiddle = nextSublist.size()/2;
            int elementMiddle = nextSublist.get(indexMiddle);

            if (Comparer.elementIsFound(toSearch, elementMiddle)) {
                position += indexMiddle;
                return position;
            }

            if (Comparer.elementIsBigger(toSearch, elementMiddle)) {
                nextSublist = Chopper.retrieveSubListFront(nextSublist, indexMiddle);
            }
            else {
                nextSublist = Chopper.retrieveSublistTail(nextSublist, indexMiddle);
                position += indexMiddle;
            }
        } while (nextSublist.size() > 1);

        if (!Comparer.elementIsFound(toSearch, nextSublist.get(0))) {
            position = -1;
        }
        return position;
    }
}