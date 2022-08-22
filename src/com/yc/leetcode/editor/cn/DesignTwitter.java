package com.yc.leetcode.editor.cn;

import java.util.*;

class DesignTwitter {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Twit {
        int time;
        int id;
        Twit next;
        public Twit(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }

    class Twitter {
        private final HashMap<Integer, Twit> postLists;
        private final HashMap<Integer, HashSet<Integer>> followerLists;
        private int time;

        public Twitter() {
            postLists = new HashMap<>();
            followerLists = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {
            if (!followerLists.containsKey(userId)) {
                HashSet<Integer> set = new HashSet<>();
                followerLists.put(userId, set);
                set.add(userId);
            }
            if (!postLists.containsKey(userId)) {
                postLists.put(userId, new Twit(time, tweetId));
            } else {
                Twit t = postLists.get(userId);
                Twit newHead = new Twit(time, tweetId);
                newHead.next = t;
                postLists.put(userId, newHead);
            }
            time++;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> posts = new ArrayList<>();
            HashSet<Integer> followers = followerLists.get(userId);
            if (followers == null || followers.size() == 0)
                return posts;
            PriorityQueue<Twit> queue = new PriorityQueue<>(followers.size(), (a, b)->(b.time - a.time));
            for (Integer follower : followers) {
                if (postLists.containsKey(follower)) {
                    Twit t = postLists.get(follower);
                    if (t != null)
                        queue.offer(t);
                }
            }
            while (!queue.isEmpty() && posts.size() < 10) {
                Twit t = queue.poll();
                posts.add(t.id);
                if (t.next != null) {
                    queue.offer(t.next);
                }
            }
            return posts;
        }

        public void follow(int followerId, int followeeId) {
            HashSet<Integer> followerList;
            if (!followerLists.containsKey(followerId)) {
                followerList = new HashSet<>();
                followerList.add(followerId);
                followerLists.put(followerId, followerList);
            } else {
                followerList = followerLists.get(followerId);
            }
            followerList.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            HashSet<Integer> followerList = followerLists.get(followerId);
            followerList.remove(followeeId);
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
//leetcode submit region end(Prohibit modification and deletion)

}