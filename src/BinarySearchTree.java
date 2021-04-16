import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree extends BinaryTree{

    private BinaryTreeNode root;

    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
    }

    public int findMin(){
        if (isEmpty()) return 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        ArrayList<Integer> valueList = new ArrayList<>();

        while (!q.isEmpty()) {

            BinaryTreeNode node = q.poll();

            valueList.add(node.getElement());

            if (node.getLeftChild() != null) {
                q.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                q.offer(node.getRightChild());
            }
        }
        return Collections.min(valueList);
    }

    public int findMax(){
        if (isEmpty()) return 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        ArrayList<Integer> valueList = new ArrayList<>();

        while (!q.isEmpty()) {

            BinaryTreeNode node = q.poll();

            valueList.add(node.getElement());

            if (node.getLeftChild() != null) {
                q.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                q.offer(node.getRightChild());
            }
        }
        return Collections.max(valueList);
    }
}
