import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputs = {
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        };

        for (int i : inputs) {
            System.out.println(i);
        }
    }
}