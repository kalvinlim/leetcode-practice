import org.junit.Before;
import org.junit.Test;
import trees.Node;
import trees.TreeUtils;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class BinaryTrees {
    Node root;
    @Before
    public void setup() {
        root = generateTree();
        Set<Integer> poo = new HashSet<>();

        poo.stream().findFirst();
    }

    @Test
    public void BFS() {
        TreeUtils.traverseTreeBFS(root);
    }

    @Test
    public void DFS_inOrder() {
        TreeUtils.traverseTreeDFS_inOrder(root);
    }

    @Test
    public void DFS_preOrder() {
        TreeUtils.traverseTreeDFS_preOrder(root);
    }

    @Test
    public void DFS_postOrder() {
        TreeUtils.traverseTreeDFS_postOrder(root);
    }

    @Test
    public void maxLength() {
        int result = TreeUtils.maxDepth(root);
        System.out.println(result);
    }

    @Test
    public void invertTree() {
        System.out.println("BEFORE: " );
        TreeUtils.print(root);
        Node result = TreeUtils.invert(root);
        System.out.println("AFTER: ");
        TreeUtils.print(root);
    }

    @Test
    public void isSubTree() {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        Node subTree = new Node(4);
        subTree.left = new Node(1);
        subTree.right = new Node(2);

        assertTrue(TreeUtils.isSubtree(root, subTree));
    }


    Node generateTree() {
        Node root = new Node(1);

        // Level 2: Children of root
        root.left = new Node(2);
        root.right = new Node(3);

        // Level 3: Children of Level 2
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Level 4: Children of Level 3
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        return root;
    }
}
