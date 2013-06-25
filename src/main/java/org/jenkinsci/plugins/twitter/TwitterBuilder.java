package org.jenkinsci.plugins.twitter;


import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import org.kohsuke.stapler.DataBoundConstructor;

import static org.jenkinsci.plugins.twitter.TwitterJobProperty.CONFIG;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class TwitterBuilder extends Builder {

    @DataBoundConstructor
    public TwitterBuilder() {
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        build.addAction(new TwitterBuildAction(Helpers.getHomeTimeline(
                CONFIG.getConsumerKey(),
                CONFIG.getConsumerSecret(),
                CONFIG.getAccessToken(),
                CONFIG.getAccessTokenSecret()
        ), build));
        return true;
    }

    @Override
    public Collection<? extends Action> getProjectActions(AbstractProject<?, ?> project) {
        return Arrays.asList(new TwitterProjectAction(project));
    }

    @Extension
    public static class Descriptor extends BuildStepDescriptor<Builder> {

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Grab public timeline";
        }
    }
}
