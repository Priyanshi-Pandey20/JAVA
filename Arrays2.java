import java.util.Arrays;
class Arrays2{

    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{1,2,3,4}}; // sum of array
        int sum = 0;
        for(int i = 0;i <arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                // System.out.print(arr[i][j] +" ");
                sum = sum +arr[i][j];
            }
        }
        System.out.println(sum);


         int[] l = {1,2,3,4,5,6};    //maximum element between two array
         int[] r ={1,2,3,4,5,6};
         int max = Integer.MIN_VALUE;
         for(int i = 0;i<l.length;i++){
            if(l[i]>max){
                max = l[i];
            }
         }
         for(int j = 0;j<r.length;j++){
            if(r[j]>max){
                max = r[j];
            }
         }
         System.out.println("max element : " + max);


         int[] o = {1,2,3,4,5};  //copy elements of one array into another
         int[] w = new int[5];
 
         for(int i = 0; i < o.length;i++){
                w[i] = o[i];
         }
 
         for(int j = 0;j<w.length;j++){
             System.out.print(w[j]);
         }


         int[] y = {1,2,3,2,0}; // unique elements
        int[] z = {5,9,4,1,0};
        boolean found = false;
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < z.length; j++) {
                if (y[i] == z[j]) {
                    System.out.println(y[i] );
                    found = true;
                    break;
                }

                if(!found){
                    System.out.println(z[j]);
                }

            }
        }


        int[] d = { 3, 6, 0, 1, 4 }; // common elements
        int[] e = { 13, 6, 7, 9, 2 };
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < e.length; j++) {
                if (d[i] == e[j]) {
                    System.out.println( d[i]);
                    break;
                }

            }
        }

        int[] s = { 2, 3 }; // merge two array
        int[] p = { 5, 4 };
        int[] merge = new int[s.length + p.length];
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            merge[index++] = s[i];
        }

        for (int j = 0; j < s.length; j++) {
            merge[index++] = p[j];
        }

        for (int num : merge) {
            System.out.print(num + " ");

        }


        int[] a = { 1, 2, 3, 4, 5 }; // compare two array
        int[] b = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.equals(a, b));


 

    }
}