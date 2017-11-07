package common;

import java.util.List;

public class Chopper {

    public static List<Integer> retrieveSubListFront(List<Integer> list, int indexMiddle) {
        return list.subList(0, indexMiddle);
    }

    public static List<Integer> retrieveSublistTail(List<Integer> list, int indexMiddle) {
        return list.subList(indexMiddle, list.size());
    }

}
