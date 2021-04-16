import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinaryTreeNode treeRoot;
    private BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        treeRoot = new BinaryTreeNode(2);

        treeRoot.addLeftChild(new BinaryTreeNode(2));
        treeRoot.addRightChild(new BinaryTreeNode(3));

        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(4));
        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(5));

        tree = new BinarySearchTree(treeRoot);
    }

    @Test
    void findMin() {
        Assertions.assertEquals(2, tree.findMin());
    }

    @Test
    void findMax() {
        Assertions.assertEquals(5, tree.findMax());
    }

    @Test
    void removeElement() {
        tree.removeElement(4);
        tree.rebalance();
        ArrayList<Integer> dummy = tree.inOrder();
        for (Integer integer : dummy) {
            System.out.println(integer);
        }
        //Assertions.assertFalse(tree.contains(4));




//        for (int i = 0; i < dummy.size(); i++) {
//            Assertions.assertEquals(order.get(i).getElement(), dummy.get(i));
//        }
    }

    @Test
    void rebalance() {
        BinaryTreeNode treeRoot1 = new BinaryTreeNode(10);

        treeRoot1.addLeftChild(new BinaryTreeNode(17));
        //treeRoot1.addRightChild(new BinaryTreeNode(12));

        treeRoot1.getLeftChild().addLeftChild(new BinaryTreeNode(32));
        treeRoot1.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(7));
        treeRoot1.getLeftChild().getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(2));

        BinarySearchTree tree1 = new BinarySearchTree(treeRoot1);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(treeRoot);
//        ArrayList<Integer> dummy = tree1.inOrder();
//        for (Integer integer : dummy) {
//            System.out.print(integer + " ");
//        }
//
        tree1.rebalance();
        print.printTree(treeRoot1);
//        System.out.println();
//        ArrayList<Integer> dummy1 = tree1.levelOrder();
//        for (Integer integer : dummy1) {
//            System.out.print(integer + " ");
//        }

    }

    @Test
    void insert() {
    }
}