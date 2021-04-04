import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        if (isEmpty()) return 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        int size = 1;
        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();
            if (node.getLeftChild() != null) {
                size++;
                q.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                size++;
                q.offer(node.getRightChild());
            }
        }

        return size;
    }

    public boolean contains(int element) {

        if(root == null) return false;
        if(root.getElement() == element) return true;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();
            if (node.getLeftChild() != null)
            {
                if(node.getElement() == element) return true;
                q.offer(node.getLeftChild());
            }

            if (node.getRightChild() != null)
            {
                if(node.getElement() == element) return true;
                q.offer(node.getRightChild());
            }
        }
        return false;
    }

    public ArrayList<BinaryTreeNode> inOrder()
    {
        if(isEmpty()) return null;

    }
}
