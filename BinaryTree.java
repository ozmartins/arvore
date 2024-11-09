public class BinaryTree {
    public TreeNode root = null;

    public void insert(int value) {
        if (root == null)
            root = new TreeNode(value);
        else
            root = TreeNode.insert(root, value);
    }

    public int height() {
        return TreeNode.height(root);
    }

    public int quantity() {
        return TreeNode.quantity(root);
    }

    public void remove(int value) {
        root = TreeNode.remove(root, value);
    }
}