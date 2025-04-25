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

   public static void main(String[] args) {

      String str1 = "happy";
      System.out.println(Palindrome(str1));

      String str = "happy";
      String str2 = "hiiii";
      ComapreString(str, str2);

      String s = "racecar"; // Count given char
      int target ='e';
      char[] arr = s.toCharArray();
      int count =0;
      for(int i =0;i<arr.length;i++){
      if(arr[i]==target){
      count++;
      }

      }
      System.out.println(count);

      String str3 = "racecarjhdgahaha"; // count vowel

      int ct = 0;
      for (int i = 0; i < str3.length(); i++) {
         char ch = str3.charAt(i);
         if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            ct++;
         }
      }
      System.out.println(ct);

      String str4 = "happy"; // remove duplicate
      for (int i = 0; i < str4.length(); i++) {
         boolean flag = true;
         for (int j = 0; j < i; j++) {
            if (str4.charAt(i) == str4.charAt(j) && i != j) {
               flag = false;
               break;
            }

         }
         if (flag) {
            System.out.println(str.charAt(i));
         }

      }

     
      


    
   }

} 
