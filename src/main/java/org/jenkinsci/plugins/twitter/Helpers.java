package org.jenkinsci.plugins.twitter;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helpers {

    private static final Logger LOGGER = Logger.getLogger("org.jenkinsci.plugins.twitter");

    private static long latestMention = -1;

    static boolean isMentioned(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret)
                .setUseSSL(true)
                .build();
        Twitter twitter = new TwitterFactory(configuration).getInstance();
        try {
            Status s = twitter.getMentionsTimeline(new Paging(1, 1)).get(0);
            if (latestMention != s.getId()) {
                latestMention = s.getId();
                return true;
            }
        } catch (TwitterException e) {
            LOGGER.log(Level.SEVERE, e.getErrorMessage());
        }
        return false;
    }

    static List<Status> getHomeTimeline(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        try {
            Configuration configuration = new ConfigurationBuilder()
                    .setOAuthConsumerKey(consumerKey)
                    .setOAuthConsumerSecret(consumerSecret)
                    .setOAuthAccessToken(accessToken)
                    .setOAuthAccessTokenSecret(accessTokenSecret)
                    .setUseSSL(true)
                    .build();
            Twitter twitter = new TwitterFactory(configuration).getInstance();
            return twitter.getHomeTimeline(new Paging(1, 50));


        } catch (TwitterException e) {
            LOGGER.log(Level.SEVERE, e.getErrorMessage());
        }
        return null;
    }

    static void publishMessage(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, String message) {
        try {
            Configuration configuration = new ConfigurationBuilder()
                    .setOAuthConsumerKey(consumerKey)
                    .setOAuthConsumerSecret(consumerSecret)
                    .setOAuthAccessToken(accessToken)
                    .setOAuthAccessTokenSecret(accessTokenSecret)
                    .setUseSSL(true)
                    .build();
            Twitter twitter = new TwitterFactory(configuration).getInstance();
            char[] chars = new char[(int) (Math.random() * 5)];
            Arrays.fill(chars, 'z');
            twitter.updateStatus(message + "\nClient: " + InetAddress.getLocalHost().getHostName() + ". Time:" + new Date() +". "+ new String(chars) + "...");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
}