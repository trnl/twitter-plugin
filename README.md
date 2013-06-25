#Jenkins Twitter Sample Plugin

A plugin created as a part of Jenkins Training I've given in the EPAM Systems.
Rather basic and will be updated later. 

![Screenshot](http://f.cl.ly/items/3l191j3B383v1g3S241f/Image%202013.06.25%203%3A36%3A45%20PM.png)

#Guide

##Prerequisites

Before proceeding with exercise you need to do the following:

- [Java 1.6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6u35-downloads-1836443.html)
- [Maven 3.0.5](http://maven.apache.org/docs/3.0.5/release-notes.html)


##Alternative ways test plugin in Jenkins
If you are not using Intellij IDEA for your plugin development you have 2 options:
- Use Maven console form your IDE (can't provide you much help here).
- Invoke Maven from shell. The following command (if you added $M2_HOME/bin to your $PATH) will compile, package and start Jenkins with your plugin installed.
```
mvn hpi:run
```

    
##Twitter connection
I've provided you with a keys in email for a [@jenkibot](https://twitter.com/jenkibot) account. If you experience any problems like 'too much requests', please just create a new account and register app in [dev.twitter.com](http://dev.twitter.com). You need:

- Consumer key
- Consumer secret
- Access token
- Access token secret



Good luck!
