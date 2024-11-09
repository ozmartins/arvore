public class TreePrinter {
    public static void printPreOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void printPostOrder(TreeNode node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    public static void printSimetric(TreeNode node) {
        if (node == null)
            return;
        printSimetric(node.left);
        System.out.println(node.value);
        printSimetric(node.right);
    }

    public static void print(TreeNode node) {
        if (node == null)
            return;

        print(node.right);

        if (node.right == null && node.left == null)
            System.out.println(padding(TreeNode.height(node) * 2) + node.value + "-+");
        else {
            if (node.right != null)
                System.out.println(padding(TreeNode.height(node) * 2) + "|");

            System.out.println(padding(TreeNode.height(node) * 2) + node.value + "-+");

            if (node.left != null)
                System.out.println(padding(TreeNode.height(node) * 2) + "|");
        }

        print(node.left);
    }

    private static String padding(int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += " ";
        }
        return result;
    }
}
