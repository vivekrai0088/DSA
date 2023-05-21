import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/design-twitter/description/
public class DesignTwitter {
  private static int timestamp = 0;

  private Map<Integer, User> userMap;

  private class Tweet {
    public int id;
    public int time;
    public Tweet next;

    public Tweet(int id) {
      this.id = id;
      time = timestamp++;
      next = null;
    }
  }

  private class User {
    public int id;
    public Set<Integer> followed;
    public Tweet tweetHead;

    public User(int id) {
      this.id = id;
      followed = new HashSet<>();
      follow(id);
      tweetHead = null;
    }

    public void follow(int id) {
      followed.add(id);
    }

    public void unfollow(int id) {
      followed.remove(id);
    }

    public void post(int id) {
      Tweet t = new Tweet(id);
      t.next = tweetHead;
      tweetHead = t;
    }
  }

  public DesignTwitter() {
    userMap = new HashMap<Integer, User>();
  }

  public void postTweet(int userId, int tweetId) {
    if(!userMap.containsKey(userId)) {
      User user = new User(userId);
      userMap.put(userId, user);
    }
    userMap.get(userId).post(tweetId);
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new LinkedList<>();

    if(!userMap.containsKey(userId)) return res;

    Set<Integer> users = userMap.get(userId).followed;
    PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(users.size(), (a, b) -> (b.time - a.time));
    for(int user: users) {
      Tweet tweet = userMap.get(user).tweetHead;
      if(tweet != null) {
        queue.add(tweet);
      }
    }
    int n = 0;
    while(!queue.isEmpty() && n < 10) {
      Tweet tweet = queue.poll();
      res.add(tweet.id);
      n++;
      if(tweet.next != null) {
        queue.add(tweet.next);
      }
    }
    return res;
  }

  public void follow(int followerId, int followeeId) {
    if(!userMap.containsKey(followerId)) {
      User user = new User(followerId);
      userMap.put(followerId, user);
    }
    if(!userMap.containsKey(followeeId)) {
      User user = new User(followeeId);
      userMap.put(followeeId, user);
    }
    userMap.get(followerId).follow(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if(!userMap.containsKey(followerId) || followerId == followeeId) return;
    userMap.get(followerId).unfollow(followeeId);
  }
}
