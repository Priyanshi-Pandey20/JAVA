public class SegmentTrees {

    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int[] arr, int i, int start, int end) { // build segment tree
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 2, mid + 1, end);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];

    }

    static int Cst(int ss, int se, int si, int[] arr, int[] tree) { // cst
        if (ss == se) {
            tree[si] = arr[ss];
            return tree[si];

        }
        int mid = (ss + se) / 2;
        tree[si] = Cst(ss, mid, 2 * si + 1, arr, tree) + Cst(mid + 1, se, 2 * si + 2, arr, tree);
        return tree[si];
    }

    static int getSumRec(int qs, int qe, int ss, int se, int si, int[] tree) {
        if (se < qs || ss > qe) {
            return 0;
        }
        if (qs <= ss && qe >= se) {
            return tree[si];
        }
        int mid = (ss + se) / 2;

        return getSumRec(qs, qe, ss, mid, 2 * si + 1, tree) + getSumRec(qs, qe, mid + 1, se, 2 * si + 2, tree);
    }

    static void updateRec(int ss, int se, int i, int si, int diff, int[] tree) { // update
        if (i < ss || i > se) {
            return;
        }
        tree[si] = tree[si] + diff;

        if (se > ss) {
            int mid = (ss + se) / 2;
            updateRec(ss, mid, i, 2 * si + 1, diff, tree);
            updateRec(mid + 1, se, i, 2 * si + 2, diff, tree);
        }
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) { // sum of numbers in range ,
        if (qj <= si || qi >= sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

     public static void buildTree(int i, int si, int sj, int[] arr) { // build segment tree to find max no.
        if (si == sj) {
            tree[i] = arr[si];
            return ;
        }

        int mid = (si + sj) / 2;
        buildTree(2*i+1,si,mid,arr);
        buildTree(2*i+2,mid+1,sj,arr);
        tree[i] = Math.max(tree[2 * i + 1] , tree[2 * i + 2]);
    }

    public static int getMax(int[] arr,int qi,int qj){
        int n = arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);
    }

    public static int getMaxUtil(int i ,int si,int sj,int qi,int qj){
         if(si > qj || sj<qi){
            return Integer.MIN_VALUE;
         }
         else if(si>=qi && sj<= qj){
            return tree[i];
         }
         else{
            int mid = (si+sj)/2;
            int leftAns = getMaxUtil(2*i+1, si, mid,qi,qj);
            int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftAns,rightAns);
         }
    }

   

    public static void main(String[] args) {

        int[] arr = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };

        int n = arr.length;
        init(n);
        buildTree(0, 0, n-1, arr);
        // for(int i = 0;i<tree.length;i++){
        //     System.out.print(tree[i] + " ");
        // }

        int max = getMax(arr, 2, 5);
        System.out.println(max);

      

        // int[] arr1 = { 10, 20, 30, 40 };
        // int n2 = 4;
        // int[] tree = new int[4 * n];
        // System.out.println(Cst(0, n - 1, 0, arr, tree));

        // System.out.println(getSumRec(0, 2, 0, 3, 0, tree));

        // System.out.println(getSum(arr, 2, 5));
    }
}
