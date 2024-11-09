import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryTree tree = new BinaryTree();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                printScreen(tree);

                String option = scanner.nextLine();

                if (option.equals("3")) {
                    running = false;
                } else {
                    printScreen(tree);
                    System.out.print("Valor:");
                    int value = Integer.parseInt(scanner.nextLine());
                    if (option.equals("1"))
                        tree.insert(value);
                    else if (option.equals("2"))
                        tree.remove(value);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void printScreen(BinaryTree tree) throws IOException {
        clearScreen();

        new BinaryTreePrinter().print(System.out, tree.root);
        // TreePrinter.print(tree.root);

        System.out.println("\n\nAltura: " + tree.height());
        System.out.println("Quantidade: " + tree.quantity());

        System.out.println("\nMenu:");
        System.out.println("1-Inserir");
        System.out.println("2-Remover");
        System.out.println("3-Sair\n");
    }

    public static void clearScreen() throws IOException {
        System.out.print("\033\143");
    }
}
