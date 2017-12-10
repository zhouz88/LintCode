/*
744. Find Smallest Letter Greater Than Target My SubmissionsBack to Contest
User Accepted: 1368
User Tried: 1406
Total Accepted: 1415
Total Submissions: 2505
Difficulty: Easy
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
*/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r == letters.length - 1) {
            return letters[0];
        } else {
            return letters[r + 1];
        }
    }
}
