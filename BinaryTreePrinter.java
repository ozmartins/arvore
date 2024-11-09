import java.io.PrintStream;

public class BinaryTreePrinter {
    public String traversePreOrder(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.value + "(" + TreeNode.hFactor(root) + ")");

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null, true);
        traverseNodes(sb, "", pointerRight, root.right, false, false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
            boolean hasRightSibling, boolean isLeft) {
        if (node != null) {
            String leftOrRigth = isLeft ? "(L)" : "(R)";
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value + leftOrRigth + "(" + TreeNode.hFactor(node) + ")");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null, true);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false, false);
        }
    }

    public void print(PrintStream os, TreeNode tree) {
        System.out.println("\n");
        os.print(traversePreOrder(tree));
    }
}
