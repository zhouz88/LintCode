public class Solution {
    public int hIndex(int[] citations) {
        // sorting the citations in ascending order
         Arrays.sort(citations); 
    for (int i = 0; i< citations.length; i++){       
        if ( citations[i] >= (citations.length - i)){
            return citations.length - i;
        }
    }
    
    return 0; 
    }
}
    ///
    
    */
cclass Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (check(mid, citations) >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int check(int mid, int[] citations) {
        int cnt = 0;
        for (int num:citations) {
            if (num >= mid) {
                cnt++;
            }
        }
        return cnt;
    }
}


class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (check(mid, citations) >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int check(int target, int[] citations) {
        int l = 0, r = citations.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (citations[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return citations.length - l;
    }
}

//counting sort
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[citations.length + 1];
        for (int k : citations) {
            if (k >= citations.length) counts[citations.length]++;
            else counts[k]++;
        }
        int sum = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
/*
275. H-Index II
DescriptionHintsSubmissionsDiscussSolution
DiscussPick One
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Seen this question in a real interview before?  YesNo



*/
class Solution {
 public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length;
        int n = citations.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(citations[mid] == n - mid) return n - mid;
            if(citations[mid] < citations.length - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}
