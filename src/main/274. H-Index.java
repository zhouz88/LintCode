274. H-Index
/*
//274. H-Index
DescriptionHintsSubmissionsDiscussSolution
DiscussPick One
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
    
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
