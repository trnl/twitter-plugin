package org.jenkinsci.plugins.twitter;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import twitter4j.Status;

import java.util.List;

public class TwitterBuildAction implements Action {
    public final List<Status> statuses;
    public final AbstractBuild<?,?> build;

    public TwitterBuildAction(List<Status> statuses, AbstractBuild<?, ?> build) {
        this.statuses = statuses;
        this.build = build;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public AbstractBuild<?, ?> getBuild() {
        return build;
    }

    public String getIconFileName() {
        return "/plugin/twitter/img/square.png";
    }

    public String getDisplayName() {
        return "Timeline";
    }

    public String getUrlName() {
        return "timeline";
    }
}
