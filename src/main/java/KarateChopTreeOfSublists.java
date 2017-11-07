import common.Chopper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The idea of this class is to create a tree of sub lists first and then just navigate through that tree:
 * Tree of [1,2,3,4,5,6,7] would be
 * [1,2,3,4,5,6,7]
 * [1,2,3,4]        [5,6,7]
 * [1,2]    [3,4]   [5,6]   [7]
 * [1] [2]  [3] [4] [5] [6] [7]
 *
 * Though building up that tree from an existing list won't be very performant, it's a good exercise for a Kata.
 */
public class KarateChopTreeOfSublists {

    public int chop(final int toSearch, final List<Integer> list) {
        BinaryTree tree = new BinaryTree(list);
        return -1;

        //TODO KSC: Further implementation needed
    }

    private class BinaryTree {
        private List<Integer> node;
        private BinaryTree left;
        private BinaryTree right;

        public BinaryTree(List<Integer> node) {
            this.node = node;
            populate();
        }

        public void populate() {
            if (node.size() > 1) {
                List<Integer> newNode = new ArrayList<>();
                Collections.copy(newNode, Chopper.retrieveSubListFront(node, node.size()/2));
                addLeft(newNode).populate();
                newNode = new ArrayList<>();
                Collections.copy(newNode, Chopper.retrieveSublistTail(node, node.size()/2));
                addRight(newNode).populate();
            }
        }

        public BinaryTree addLeft(List<Integer> node) {
            left = new BinaryTree(node);
            return left;
        }

        public BinaryTree addRight(List<Integer> node) {
            right = new BinaryTree(node);
            return right;
        }

        public BinaryTree getLeft() {
            return left;
        }

        public BinaryTree getRight() {
            return right;
        }
    }
}