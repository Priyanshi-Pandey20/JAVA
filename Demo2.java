public class Demo2 {
      
    
    public static void main(String[] args){
        String str = "coding";// revere a string
        String rev = "";
        for(int i =str.length()-1;i>=0;i--){
           rev = rev + str.charAt(i);
        } 
        System.out.println(rev);
  
      
        String str8 = "hellooooo"; // print second repeated charater
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
         
        StringBuilder str1 = new StringBuilder(12); 
        str1.append("helloo hiiii byeeeee");
         
        System.out.println(str1.length());
        System.out.println(str1.capacity());


        
  
    }
}
