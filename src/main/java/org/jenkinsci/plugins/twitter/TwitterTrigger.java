package org.jenkinsci.plugins.twitter;

import antlr.ANTLRException;
import hudson.Extension;
import hudson.model.Item;
import hudson.model.Project;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TwitterTrigger extends Trigger<Project> {

    @Extension
    public static class Descriptor extends TriggerDescriptor {

        @Override
        public boolean isApplicable(Item item) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Listen Twitter";
        }
    }

    @DataBoundConstructor
    public TwitterTrigger(String spec) throws ANTLRException {
        super(spec);
    }

    @Override
    public void run() {
        Logger.getLogger("Twitter").log(Level.SEVERE, "Running");
    }
}
