class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //find the shortest array:
        int[] arrayA = nums1;
        int[] arrayB = nums2;
        if (nums2.length < nums1.length){
            int[] temp = arrayA;
            arrayA = arrayB;
            arrayB = temp;
        }
        int half = (nums1.length + nums2.length) / 2;
        int l = -1, r = arrayA.length - 1;
        while (true){
            int partitionA = l + (r - l) / 2;
            int partitionB = half - partitionA - 2;

            int Aleft = partitionA >= 0 ? arrayA[partitionA] : Integer.MIN_VALUE;
            int Bleft = partitionB >=0 ? arrayB[partitionB] : Integer.MIN_VALUE;
            int Aright = (partitionA + 1) < arrayA.length ? arrayA[partitionA + 1] : Integer.MAX_VALUE;
            int Bright = (partitionB + 1) < arrayB.length ? arrayB[partitionB + 1] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright){
                if ((arrayA.length + arrayB.length) % 2 != 0){
                    return Math.min(Aright, Bright);
                } else {
                    return (Math.max(Aleft, Bleft)  + Math.min(Aright, Bright))/2.0;
                }
            } else if (Aleft > Bright){
                r = partitionA - 1;
            } else {
                l = partitionA + 1;
            }
        }
        
    }
}
