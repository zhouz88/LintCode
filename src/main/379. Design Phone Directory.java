import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class PhoneDirectory {
    Set<Integer> set = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    int max;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
         for (int i = 0; i < maxNumbers; i++) {
             q.add(i);
         }
         this.max = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
         Integer res = q.poll();
         if (res == null) {
             return -1;
         }
         set.add(res);
         return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= max) {
            return false;
        }
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.remove(number)) {
            q.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
