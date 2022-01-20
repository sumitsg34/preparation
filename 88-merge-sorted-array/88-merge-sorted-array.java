class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] out = new int[m+n];
        
        int i=0;
        int j=0;
        
        int k = 0;
        
        while( i<m && j<n) {
            
            if(nums1[i] < nums2[j]) {
                out[k] = nums1[i];
                i++;
            }else{
                out[k] = nums2[j];
                j++;
            }
            k++;
            
        }
        
        if(i<m) {
            
            while( i<m ) {
                out[k] = nums1[i];
                i++;
                k++;
            }
        }
        
        if(j<n) {
            
            while( j<n ) {
                out[k] = nums2[j];
                j++;
                k++;
            }
        }
        for(i=0; i<(m+n) ; i++){
            nums1[i]=out[i];
        }
    }
}