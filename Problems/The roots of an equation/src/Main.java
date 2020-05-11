import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int roots = 0;
        int x = 0;
        while (roots != 2 && x <= 1000) {
            if (a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d == 0) {
                System.out.println(x);
                roots++;
            }
            x++;
        }
    }
}