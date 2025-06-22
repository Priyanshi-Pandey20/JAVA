 public static void Palindrome(int n) {// palindrome
        int original = n;
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        if (original == rev) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

    }