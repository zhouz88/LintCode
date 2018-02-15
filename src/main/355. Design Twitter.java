import java.util.*;

class Twitter {
    private Map<Integer, List<Tweet>> userIdTweetsIdMap = new HashMap<>();
    private Map<Integer, Set<Integer>> userIdFollowersMap = new HashMap<>();

    private static int TIME = 0;

    private static class Tweet {
        int time;
        int tweetID;
        int tweetUser;
        int idx;
        public Tweet(int time, int tweetID, int userId, int idx) {
            this.time = time;
            this.tweetID = tweetID;
            this.tweetUser = userId;
            this.idx = idx;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        TIME++;
        userIdTweetsIdMap.putIfAbsent(userId, new ArrayList<>());
        userIdTweetsIdMap.get(userId).add(new Tweet(TIME, tweetId, userId, userIdTweetsIdMap.get(userId).size()));

        userIdFollowersMap.putIfAbsent(userId, new HashSet<>());//very important

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        userIdFollowersMap.putIfAbsent(userId, new HashSet<>());
        Set<Integer> set = userIdFollowersMap.get(userId);

        PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return Integer.compare(o2.time, o1.time);
            }
        });

        for (Map.Entry<Integer, List<Tweet>> e : userIdTweetsIdMap.entrySet()) {
            if (set.contains(e.getKey())) {  //friends' tweets
                pq.add(e.getValue().get(e.getValue().size() - 1));
            }
        }

        if (userIdTweetsIdMap.containsKey(userId)) {
            pq.add(userIdTweetsIdMap.get(userId).get(userIdTweetsIdMap.get(userId).size() - 1));
        }

        List<Integer> ret = new ArrayList<>();
        int cnt = 10;
        while (!pq.isEmpty()) {
            Tweet node = pq.poll();
            cnt--;
            ret.add(node.tweetID);
            if (cnt == 0) {
                break;
            }
            if (node.idx > 0) {
                pq.add(userIdTweetsIdMap.get(node.tweetUser).get(node.idx - 1));
            }
        }

        return ret;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        userIdFollowersMap.putIfAbsent(followerId, new HashSet<>());
        userIdFollowersMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userIdFollowersMap.containsKey(followerId)) {
            return;
        }
        userIdFollowersMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
