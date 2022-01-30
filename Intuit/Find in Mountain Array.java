/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr,len-1);
        
        int index = search(mountainArr,0,peakIndex,true,target);
        
        if(index==-1){
            index = search(mountainArr,peakIndex+1,len-1,false,target);
        }
        
        return index;
    }
    
    public int findPeakIndex(MountainArray mountainArr,int high){
        
        int low = 0;
        int peakIndex = 0;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(mid==0 || mountainArr.get(mid) > mountainArr.get(mid-1)){
                peakIndex = mid;
                low = mid + 1;
            }else {
                high=mid-1;
            }
        }
        
        return peakIndex;
    }

    public int search(MountainArray mountainArr, int low, int high, boolean increasing, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }else if(mountainArr.get(mid) > target){
                if(increasing){
                    high=mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(increasing){
                    low = mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        
        return -1;
    }
}
