public class Patterns {

    public static void main(Demo args[]) {
        for (int i = 1; i <= 5; i++) { // left upper half traingle
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) { // lower left inverted half traingle
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) { // upper praymid
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            for (int p = 1; p < i; p++) {
                System.out.print("*");
            }
            System.out.println();

        }

        System.out.println();

        for (int i = 5; i >= 1; i--) { // lower pyramid
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            for (int p = 1; p < i; p++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = 1; i <= 5; i++) { // hollow square
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || i == 5 || j == 1 || j == 5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= 5; i++) { // aplhabets in upper half traingle
            char ch = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) { // diamond
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            for (int p = 1; p < i; p++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = 5; i >= 1; i--) {
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            for (int p = 1; p < i; p++) {
                System.out.print("*");
            }
            System.out.println();

        }


        

    }

}
