import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        if (root == null) return false;
        if (root.getElement() == element) return true;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();
            if (node.getLeftChild() != null) {
                if (node.getElement() == element) return true;
                q.offer(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                if (node.getElement() == element) return true;
                q.offer(node.getRightChild());
            }
        }
        return false;
    }

    public ArrayList<BinaryTreeNode> inOrder() {

        if (isEmpty()) return null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> finalTraversal = new ArrayList<>();
        BinaryTreeNode current = root;

        while (!stack.isEmpty() || current != null) {

           while(current != null)
           {
               stack.push(current);
               current = current.getLeftChild();
           }

           current = stack.pop();
           finalTraversal.add(current);
           current = current.getRightChild();


//            if(current != null)
//            {
//                q.offer(current);
//                current = current.getLeftChild();
//            }
//            else
//            {
//                finalTraversal.add(q.poll());
//                current = current.getRightChild();
//            }
        }
        return finalTraversal;
    }

    public ArrayList<BinaryTreeNode> preOrder()
    {
        if(isEmpty()) return null;

        Stack<BinaryTreeNode> q = new Stack<BinaryTreeNode>();
        q.push(root);

        ArrayList<BinaryTreeNode> preList = new ArrayList<>();

        while (!q.isEmpty())
        {
            BinaryTreeNode node = q.pop();
            preList.add(node);

            if (node.getRightChild() != null)
            {
                q.push(node.getRightChild());
            }
            if (node.getLeftChild() != null)
            {
                q.push(node.getLeftChild());
            }
        }

        return preList;
    }

    public ArrayList<BinaryTreeNode> levelOrder()
    {
        if(isEmpty()) return null;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        ArrayList<BinaryTreeNode> levelOrder = new ArrayList<>();
        levelOrder.add(root);

        while (!q.isEmpty())
        {
            BinaryTreeNode node = q.poll();
            int index = levelOrder.indexOf(node);

            if (node.getRightChild() != null)
            {
                levelOrder.add(2*(index + 1), node.getRightChild());
                q.offer(node.getRightChild());
            }
            if (node.getLeftChild() != null)
            {
                levelOrder.add(2*index + 1, node.getLeftChild());
                q.offer(node.getLeftChild());
            }
        }

        return levelOrder;
    }

    public ArrayList<BinaryTreeNode> postOrder() {

        if (root == null) return null;
        ArrayList<BinaryTreeNode> postList = new ArrayList<>();


        Stack stack1 = new Stack<>();
        Stack stack2 = new Stack<>();


        stack1.push(root);


        while (!stack1.isEmpty()) {

            BinaryTreeNode temp = (BinaryTreeNode) stack1.pop();
            stack2.push(temp);

            if (temp.getLeftChild() != null)
                stack1.push(temp.getLeftChild());
            if (temp.getRightChild() != null)
                stack1.push(temp.getRightChild());
        }


        while (!stack2.isEmpty()) {
            BinaryTreeNode temp = (BinaryTreeNode) stack2.pop();
            postList.add(temp);
        }
        return postList;
    }

    private int height(BinaryTreeNode node)
    {
        if (node == null || (node.getLeftChild() == null && node.getRightChild() == null))
        {
            return 0;
        }
        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public int height()
    {
        return height(getRoot());
    }
}
