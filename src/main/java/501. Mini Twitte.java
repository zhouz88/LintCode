import java.util.*;

import com.Tweet;
/**
 * Definition of Tweet:

 */


public class MiniTwitter {

    public MiniTwitter() {
        // do intialization if necessary
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    List<Tweet> tweets = new ArrayList<>();

    Map<Integer, Set<Integer>> userMap = new HashMap<>();

    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        tweets.add(tweet);
        userMap.putIfAbsent(user_id, new HashSet<>());
        if (userMap.size() == 0) {
            userMap.get(user_id).add(user_id);
        }
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Tweet> ret = new ArrayList<>();

        if (!userMap.containsKey(user_id)) {
            return ret;
        }

        Set<Integer> set = userMap.get(user_id);

        int cnt = 0;

        for (int i = tweets.size() - 1; i >= 0; i--) {
            if (set.contains(tweets.get(i).user_id)) {
                cnt++;
                ret.add(tweets.get(i));
            }
            if (cnt == 10) {
                break;
            }
        }

        return ret;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> ret = new ArrayList<>();

        if (!userMap.containsKey(user_id)) {
            return ret;
        }

        int cnt = 0;

        for (int i = tweets.size() - 1; i >= 0; i--) {
            if (tweets.get(i).user_id == user_id) {
                cnt++;
                ret.add(tweets.get(i));
            }
            if (cnt == 10) {
                break;
            }
        }

        return ret;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if (userMap.containsKey(from_user_id)) {
            userMap.get(from_user_id).add(to_user_id);
        } else {
            userMap.put(from_user_id, new HashSet<>());
            userMap.get(from_user_id).add(from_user_id);
            userMap.get(from_user_id).add(to_user_id);
        }
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if (userMap.containsKey(from_user_id)) {
            userMap.get(from_user_id).remove(to_user_id);
        } else {
            return;
        }
    }
    
}

public class Tweet {
    public int id;
    public int user_id;
    public String text;

    public static Tweet create(int user_id, String tweet_text) {
        Tweet t = new Tweet();
        t.id = 1;
        t.user_id = user_id;
        t.text = tweet_text;
        return t;
    }
}
