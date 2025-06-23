public class SegmentTrees {
    static int Cst(int ss,int se,int si,int[] arr,int[] tree){
        if(ss== se){
            tree[si] = arr[ss];
            return tree[si];

        }
        int mid = (ss+se)/2;
        tree[si]= Cst(ss, mid, 2*si+1, arr, tree) + Cst(mid+1, se, 2* si+2, arr, tree);
        return tree[si];
    }
    
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
       int n = 4;
        int[] tree = new int[4*n];
        System.out.println(Cst(0, n-1, 0, arr, tree));

        for(int i =0;i<4*n;i++){
            System.out.println(tree[i]);
        }
    }
}
