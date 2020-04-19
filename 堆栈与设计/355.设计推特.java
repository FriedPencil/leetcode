/*
���һ���򻯰������(Twitter)���������û�ʵ�ַ������ģ���ע/ȡ����ע�����û����ܹ�������ע�ˣ������Լ��������ʮ�����ġ���������Ҫ֧�����µļ������ܣ�

postTweet(userId, tweetId): ����һ���µ�����
getNewsFeed(userId): ���������ʮ�����ġ�ÿ�����Ķ��������ɴ��û���ע���˻������û��Լ������ġ����ı��밴��ʱ��˳��������Ŀ�ʼ����
follow(followerId, followeeId): ��עһ���û�
unfollow(followerId, followeeId): ȡ����עһ���û�
ʾ��:

Twitter twitter = new Twitter();

// �û�1������һ�������� (�û�id = 1, ����id = 5).
twitter.postTweet(1, 5);

// �û�1�Ļ�ȡ����Ӧ������һ���б����а���һ��idΪ5������.
twitter.getNewsFeed(1);

// �û�1��ע���û�2.
twitter.follow(1, 2);

// �û�2������һ�������� (����id = 6).
twitter.postTweet(2, 6);

// �û�1�Ļ�ȡ����Ӧ������һ���б����а����������ģ�id�ֱ�Ϊ -> [6, 5].
// ����id6Ӧ��������id5֮ǰ����Ϊ������5֮���͵�.
twitter.getNewsFeed(1);

// �û�1ȡ����ע���û�2.
twitter.unfollow(1, 2);

// �û�1�Ļ�ȡ����Ӧ������һ���б����а���һ��idΪ5������.
// ��Ϊ�û�1�Ѿ����ٹ�ע�û�2.
twitter.getNewsFeed(1);

*/
import java.util.*;
class Twitter {
    class Tweet{
        int tweetId;
        int time;
        Tweet(int tweetId,int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    int time;
    HashMap<Integer,LinkedList<Tweet>> news;
    HashMap<Integer,Set<Integer>> foll;
    PriorityQueue<Tweet> queue = new PriorityQueue<>((o1,o2)->{return o2.time-o1.time;});
    /** Initialize your data structure here. */
    public Twitter() {
        news = new HashMap<>();
        foll = new HashMap<>();
        time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!news.containsKey(userId)){
            news.put(userId,new LinkedList<Tweet>());
        }
        LinkedList<Tweet> list = news.get(userId);
        list.addFirst(new Tweet(tweetId,time++));
        if(list.size() > 10) list.removeLast();

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        queue.clear();
        if(news.containsKey(userId)) {
            for (Tweet t : news.get(userId)) {
                queue.offer(t);
            }
        }
        if(foll.containsKey(userId)){
            for(int id : foll.get(userId)){
                if(news.containsKey(id)) {
                    for (Tweet t : news.get(id)) {
                        queue.offer(t);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10 && !queue.isEmpty();i++){
            list.add(queue.poll().tweetId);

        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if(!foll.containsKey(followerId)){
            foll.put(followerId,new HashSet<>());

        }
        foll.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if(!foll.containsKey(followerId)){
            foll.put(followerId,new HashSet<>());
        }
        foll.get(followerId).remove(followeeId);
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