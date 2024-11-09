public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public static TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
        } else if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        node = balanceTreeAfterInsert(node, value);
        return node;
    }

    public static TreeNode remove(TreeNode node, int value) {
        if (node == null)
            return null;
        if (value < node.value) {
            node.left = remove(node.left, value);
            if (hFactor(node) == -2) {
                if (hFactor(node.right) == -1)
                    node = rotateToLeft(node);
                else
                    node = rotateToRightThenLeft(node);
            }
        } else if (value > node.value) {
            node.right = remove(node.right, value);
            if (hFactor(node) == 2) {
                if (hFactor(node.left) == 1)
                    node = rotateToRight(node);
                else
                    node = rotateToLeftThenRight(node);
            }
        } else {
            if (node.left == null && node.right == null)
                return null;
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;

            TreeNode rightestNode = getTheRightest(node.left);

            swapValues(node, rightestNode);

            node.left = remove(node.left, value);
        }
        return node;
    }

    public static boolean exists(TreeNode node, int value) {
        if (node == null)
            return false;
        if (node.value == value)
            return true;
        return exists(node.left, value) || exists(node.right, value);
    }

    public static int height(TreeNode current) {
        if (current == null)
            return -1;
        return 1 + Math.max(height(current.left), height(current.right));
    }

    public static int hFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    public static int quantity(TreeNode current) {
        if (current == null)
            return 0;
        return 1 + quantity(current.left) + quantity(current.right);
    }

    private static TreeNode getTheRightest(TreeNode node) {
        TreeNode currentRighest = node;
        while (currentRighest.right != null) {
            currentRighest = currentRighest.right;
        }
        return currentRighest;
    }

    private static void swapValues(TreeNode firstNode, TreeNode secondNode) {
        int temp = firstNode.value;
        firstNode.value = secondNode.value;
        secondNode.value = temp;
    }

    private static TreeNode rotateToRight(TreeNode node) {
        TreeNode temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private static TreeNode rotateToLeft(TreeNode node) {
        TreeNode temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private static TreeNode rotateToLeftThenRight(TreeNode node) {
        node.left = rotateToLeft(node.left);
        node = rotateToRight(node);
        return node;
    }

    private static TreeNode rotateToRightThenLeft(TreeNode node) {
        node.right = rotateToRight(node.right);
        node = rotateToLeft(node);
        return node;
    }

    private static TreeNode balanceTreeAfterInsert(TreeNode node, int value) {
        if (hFactor(node) == 2) {
            if (value < node.left.value)
                node = rotateToRight(node);
            else
                node = rotateToLeftThenRight(node);
        } else if (hFactor(node) == -2) {
            if (value > node.right.value)
                node = rotateToLeft(node);
            else
                node = rotateToRightThenLeft(node);
        }
        return node;
    }
}
