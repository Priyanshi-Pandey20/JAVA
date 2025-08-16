public static void SortArrayInAsending(int[] arr1) { //sort 

        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] > arr1[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }

        }
        for (int j = 0; j < arr1.length; j++) {
            System.out.println(arr1[j]);
        }

    }
