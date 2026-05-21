package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) return false;
        if(isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean isIdentical(Node a, Node b) {
        if(a == null && b == null) return true;
        if(a == null || b == null || a.data != b.data) return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }


    public static void traverseTreeBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            Node next = queue.poll();
            System.out.println("Node value: " + next.data);

            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
    }

    //Left root, right
    public static void traverseTreeDFS_inOrder(Node root) {
        if (root != null) {
            traverseTreeDFS_inOrder(root.left);
            System.out.println("ROOT VAL: " + root.data);
            traverseTreeDFS_inOrder(root.right);
        }
    }

    //Root, left, right
    public static void traverseTreeDFS_preOrder(Node root) {
        if (root != null) {
            System.out.println("ROOT VAL: " + root.data);
            traverseTreeDFS_inOrder(root.left);
            traverseTreeDFS_inOrder(root.right);
        }
    }

    //left right root
    public static void traverseTreeDFS_postOrder(Node root) {
        if (root != null) {
            traverseTreeDFS_inOrder(root.left);
            traverseTreeDFS_inOrder(root.right);
            System.out.println("ROOT VAL: " + root.data);
        }
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static Node invert(Node root) {
        Node p = root;
        if (p == null) {
            return root;
        }
        invertHelper(p);

        return p;
    }

    public static void invertHelper(Node n) {
        if (n != null) {
            Node temp = n.left;
            n.left = n.right;
            n.right = temp;
            invertHelper(n.left);
            invertHelper(n.right);
        }

    }

    public static void print(Node root) {
        int maxLevel = maxDepth(root);
        printNodeInternal(List.of(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printSpaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printSpaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printSpaces(endgeLines * 2 + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printSpaces(1);
                }

                printSpaces(i * 2 - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printSpaces(1);
                }

                printSpaces(endgeLines * 2 - i);
            }
            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static boolean isAllElementsNull(List<Node> list) {
        for (Object object : list) {
            if (object != null) return false;
        }
        return true;
    }
}
