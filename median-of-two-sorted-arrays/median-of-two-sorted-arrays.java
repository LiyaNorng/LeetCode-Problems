class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize =  nums1.length + nums2.length;
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int [] nums3 = new int[totalSize];
        int i = 0,j = 0,k = 0;
        while (true){
            if (i < nums1Size && j < nums2Size){
                if (nums1[i] < nums2[j]){
                    nums3[k++] = nums1[i++];
                }
                else if (nums1[i] == nums2[j]){
                    nums3[k++] = nums1[i++];
                    nums3[k++] = nums2[j++];
                }
                else if (nums1[i] > nums2[j]){ nums3[k++] = nums2[j++]; }
            }
            else if (i >= nums1Size && j < nums2Size){ nums3[k++] = nums2[j++]; }
            else if (i < nums1Size && j >= nums2Size){ nums3[k++] = nums1[i++]; }   
            if (k == totalSize){ break; }   
        }
        if (totalSize % 2 == 0){
            return (double)(nums3[(int)(totalSize/2) - 1] + nums3[(int)(totalSize/2)])/2; 
        }
        else { return (double)nums3[(int)(totalSize/2)];}
    }     
}