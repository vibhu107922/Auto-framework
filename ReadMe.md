# NoWeakParties Web Automation

The general purpose of this repository is to offer automated test
solution for the
[noweakparties](https://noweakparties-staging.azurewebsites.net)
repository.

## **Requirements**

* [Java JDK 1.8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* IDE
  * IntelliJ IDEA (_recommended_)
    * [Mac](https://www.jetbrains.com/idea/download/#section=mac)
    * [Windows](https://www.jetbrains.com/idea/download/#section=windows)
  * Or Eclipse
    * [Mac](https://www.eclipse.org/downloads/eclipse-packages/?osType=macosx)
    * [Windows](https://www.eclipse.org/downloads/eclipse-packages/?osType=win32&release=undefined)
    


## **Running**

This section describes how to run the tests on Mac and
Windows using the _IntelliJ IDEA_ IDE, if using _Eclipse_ the setup
may be different.

The following steps are a general guideline:

### Cloning the Source

  1. Clone this repository

       `> git clone https://github.com/thegauravianid007/NWP`

Setup your all the prerequisites and you are good to go for running the automation. Make sure before running any command you are in the root directory of project.

In this project there is testng file in which we have defined set of tests to be executed. So in order to run our testng file use below command:

		mvn test