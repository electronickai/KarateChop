import common.Chopper;

import java.util.List;
import java.util.function.Function;

/**
 * The idea is to use a functional approach to chop the list apart and get the correct position of the searched element.
 * Although I still think that this is feasible, it doesn't seem to be easy for a rather procedural thinking mind...
 * I'm hoping to get more into functional programming and get back to this exercise then.
 */
public class KarateChopFunctional {

    @FunctionalInterface
    interface TwoNumbersAndAListToInt {
        Integer applyAsInt (List<Integer> list, Integer number1, Integer number2);
    }

    private static Integer findIntegerInList(final List<Integer> list, Function<List<Integer>, Integer> operation) {
        return operation.apply(list);
    }

    private static Integer findIntegerInListBasedOnTwoNumbers(List<Integer> list, Integer number1, Integer number2, TwoNumbersAndAListToInt operation) {
        return operation.applyAsInt(list, number1, number2);
    }

    public int chop(final int toSearch, final List<Integer> list) {

        Function<List<Integer>, Integer> calculateMedian = (listToEvaluate) -> {
            if (listToEvaluate.size() == 0)
                return null;
            return listToEvaluate.get(listToEvaluate.size()/2);
        };

        Function<List<Integer>, Integer> calculateMedianPosition = (listToEvaluate) -> {
            if (listToEvaluate.size() == 0)
                return null;
            return listToEvaluate.size()/2;
        };

        TwoNumbersAndAListToInt searchInFirstHalf = (listToEvaluate, toFind, currentPosition) -> {
            List<Integer> sublist = Chopper.retrieveSubListFront(listToEvaluate, currentPosition);
            int indexOfSublist = chop(toFind, sublist);
            return indexOfSublist == -1 ? -1 : indexOfSublist;
        };

        TwoNumbersAndAListToInt searchInSecondHalf = (listToEvaluate, toFind, currentPosition) -> {
            List<Integer> sublist = Chopper.retrieveSublistTail(listToEvaluate, currentPosition);
            int indexOfSublist = chop(toFind, sublist);
            return indexOfSublist == -1 ? -1 : currentPosition + indexOfSublist;
        };

        Integer median = findIntegerInList(list, calculateMedian);
        Integer index = findIntegerInList(list, calculateMedianPosition);

        findIntegerInListBasedOnTwoNumbers(list, toSearch, index, searchInFirstHalf);
        findIntegerInListBasedOnTwoNumbers(list, toSearch, index, searchInSecondHalf);

        //TODO KSC: Further implementation needed. Not really satisfied with this approach yet

        return -1;
    }
}