    public static void main(String []args){
        int[] a = new int[]{3,4,5,2,1,6,7,8};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
     }
     
     public static int[] mergeSort(int[] theArray){
         if(theArray.length == 1){
             return theArray;
         }
         
         int[] firstHalf = new int[theArray.length/2];
         int[] secondHalf = new int[theArray.length/2];
         
         System.arraycopy(theArray, 0, firstHalf, 0, firstHalf.length);
         System.arraycopy(theArray, firstHalf.length, secondHalf, 0, secondHalf.length);
         
         mergeSort(firstHalf);
         mergeSort(secondHalf);
         merge(firstHalf, secondHalf, theArray);
         
         return theArray;
     }
     
     public static void merge(int[] firstHalf, int[] secondHalf, int[] result){
         int first = 0;
         int second = 0;
         int resultIndex = 0;
         
         while(first < firstHalf.length && second < secondHalf.length){
             if(firstHalf[first] < secondHalf[second]){
                 result[resultIndex] = firstHalf[first];
                 first++;
             }
             else{
                 result[resultIndex] = secondHalf[second];
                 second++;
             }
             resultIndex++;
         }
         
         System.arraycopy(firstHalf, first, result, resultIndex, firstHalf.length-first);
         System.arraycopy(secondHalf, second, result, resultIndex, secondHalf.length-second);
         
     }