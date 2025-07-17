public class Demo {

   public static boolean Palindrome(String str1) {// palindrome
      for (int i = 0; i < str1.length(); i++) {
         int n = str1.length() / 2;
         if (str1.charAt(i) != str1.charAt(n - i - 1)) {
            return false;
         }

      }
      return true;

   }

   public static void ComapreString(String str, String str2) { // compare two string

      for (int i = 0; i < str.length(); i++) {
         for (int j = i; j < str2.length(); j++) {
            if (str.charAt(i) == str2.charAt(j)) {
               System.out.println("The strings are equal" + " " + str.charAt(i));
            }
         }
      }

   }

   public static void CountCharacter() {
      String s = "racecar"; // count given charater in string
      int target = 'r';
      char[] arr = s.toCharArray();
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == target) {
            count++;
         }

      }
      System.out.println(count);

   }

   public static void CountVowel() {
      String str3 = "racecarjhdgahaha"; // count no. of vowels in string

      int ct = 0;
      for (int i = 0; i < str3.length(); i++) {
         char ch = str3.charAt(i);
         if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            ct++;
         }
      }
      System.out.println(ct);
   }

   public static void RemoveDuplicates() {
      String str4 = "happy"; // remove dulicates 
      for (int i = 0; i < str4.length(); i++) {
         boolean flag = true;
         for (int j = 0; j < i; j++) {
            if (str4.charAt(i) == str4.charAt(j) && i != j) {
               flag = false;
               break;
            }

         }
         if (flag) {
            System.out.println(str4.charAt(i));
         }

      }
   }

   public static void ReverseString() {
      String str = "coding";// revere a string
      String rev = "";
      for (int i = str.length() - 1; i >= 0; i--) {
         rev = rev + str.charAt(i);
      }
      System.out.println(rev);
   }

   public static void RepeatedString() {
      String str8 = "hellooooo"; // print second repeated charater in string
      String newStr = "";

      int count1 = 0;
      char[] arr1 = str8.toCharArray();
      for (int i = 0; i < arr1.length; i++) {
         for (int j = i + 1; j < arr1.length; j++) {
            if (arr1[i] == arr1[j]) {
               count1++;
               if (count1 == 2) {
                  newStr = newStr + arr1[i];
                  System.out.println(newStr);

               }
            }
         }
      }
   }

   public static void main(String[] args) {

      String str1 = "happy";
      System.out.println(Palindrome(str1));

      String str = "happy";
      String str2 = "hiiii";
      ComapreString(str, str2);

      CountCharacter();
      CountVowel();
      RemoveDuplicates();

      RepeatedString();
      ReverseString();

   }

}
