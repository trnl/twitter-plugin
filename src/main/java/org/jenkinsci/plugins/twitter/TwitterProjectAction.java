package org.jenkinsci.plugins.twitter;

import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import twitter4j.Status;

import java.util.List;

public class TwitterProjectAction implements Action {

    private final AbstractProject<?, ?> project;

    public TwitterProjectAction(AbstractProject<?, ?> project) {
        this.project = project;
    }

    public String getIconFileName() {
        return null; //Hiding it from side panel
    }

    public String getDisplayName() {
        return "Twitter";
    }

    public String getUrlName() {
        return "twitter";
    }

    public List<Status> getTweets() {

        for (AbstractBuild<?, ?> build : project.getBuilds()) {
            TwitterBuildAction action = build.getAction(TwitterBuildAction.class);
            if (action != null && action.getStatuses() != null) {
                return action.getStatuses().subList(0, 3);
            }
        }
        return null;
    }

    public boolean hasTweets() {
        return getTweets() != null;
    }
}
