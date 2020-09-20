# Installing Java

## 1. Installing Java On Mac / Linux

Foobar is a Python library for dealing with word pluralization.

There are two methods to install java on mac/Linux operating systems.

1. Download the installer, install the jdk and set the java_home path.
2. Use missing package manager and run some commands.

I will be demonstrating the second option because it downloads the package, installs it and sets the path as well. Just we need to give some commands. We will be using **Homebrew** as missing package installer.

To continue further we need to [install **Homebrew**](http://brew.sh). Just go through the link and install **homebrew** on your machine.

### Steps to follow along
#### 1.1 Verify homebrew installed correctly.
```bash
brew -v
```

#### 1.2 Tap into [Openjdk](https://openjdk.java.net) formulae.
OpenJDK is the same version of official oracle JDK with free GPL license. If you want mote details please let me know through the comments on our [youtube channel](http://youtube.com/codehooks). I will be more happy to help.

```bash
brew tap adoptopenjdk/openjdk
```

It may take some time for first time as it updates required casks(libraries) needed for homebrew.

#### 1.3 Search for JDK
```bash
brew search jdk
```
It will show you the following results.
```
==> Casks
adoptopenjdk                      adoptopenjdk12-openj9             adoptopenjdk14                    adoptopenjdk8-openj9-jre-large
adoptopenjdk10                    adoptopenjdk12-openj9-jre         adoptopenjdk14-jre                adoptopenjdk8-openj9-large
adoptopenjdk11                    adoptopenjdk12-openj9-jre-large   adoptopenjdk14-openj9             adoptopenjdk9
adoptopenjdk11-jre                adoptopenjdk12-openj9-large       adoptopenjdk14-openj9-jre         jdk-mission-control
adoptopenjdk11-openj9             adoptopenjdk13                    adoptopenjdk14-openj9-jre-large   oracle-jdk
adoptopenjdk11-openj9-jre         adoptopenjdk13-jre                adoptopenjdk14-openj9-large       oracle-jdk-javadoc
adoptopenjdk11-openj9-jre-large   adoptopenjdk13-openj9             adoptopenjdk8                     sapmachine-jdk
adoptopenjdk11-openj9-large       adoptopenjdk13-openj9-jre         adoptopenjdk8-jre
adoptopenjdk12                    adoptopenjdk13-openj9-jre-large   adoptopenjdk8-openj9
adoptopenjdk12-jre                adoptopenjdk13-openj9-large       adoptopenjdk8-openj9-jre
```
#### 1.4 Downloading and installing java
If you want to install the 8 version of java. Run the following command
```bash
brew cask install adopopenjdk8
```
This single command will make your life easy. It performs three steps for you.
```
1. Downloading the JDK
2. Installing JDK
3. Updating the Path environment variables.
```

### Verifying java installation
You can run the following command to verify the java installation.
```bash
java -version
```
If it gives you the similar response like below one then your installation was successful, other wise you can check the next section for detailed info.
```bash
java version "1.8.0_231"
Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.231-b11, mixed mode)
```

#### 1.5 Advanced Steps.
If ***java -version*** command fails to return successful result, then you can follow the next steps.

You can get the installed versions of java and the installed path from the following command.
```bash
/usr/libexec/java_home -V
```
This will result in following statements.
```bash
1.8.0_231, x86_64:	"Java SE 8"	/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home
```
The last part of the string is the actual path where java is installed. One more point here command above will list all the versions of java that you have installed on your machine regardless whether you have installed java Manually or though homebrew.

To get the only path of installation of particular version you can run following command.
```bash
/usr/libexec/java_home -v1.8
```
It will result in
```bash
/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home
```

As a next step you want to set environment paths. So you need to get into the ***bash_profile*** file.
```bash
sudo vim ~.bash_profile
```
It asks for your authentication just go ahead and type in your password. After that you will be landed on bash profile file where you want to setup the path.
```bash
export java_8 =$(/usr/libexec/java_home -v1.8) #It will load the installation path and assign that path to java_8 variable.

# If you have multiple installations then you can add them into separate variables like below.
export java_12=$(/usr/libexec/java_home -v12)

# Now Setup the JAVA_HOME path
#For setting up java 8
export JAVA_HOME=$java_8

# If you want to setup the Java 12 then comment out the java 8 and add following lines.
#export JAVA_HOME=$java_8
export JAVA_HOME=$java_12
``` 

Just save the file. And verify your installation with the command shown above ***java -version***


## 2. Installing Java on Windows
Again you can follow the same steps with chocolatey package manager for windows. (We need to follow [chocolatey](https://chocolatey.org/) instructions). Otherwise you can follow the typical installation on windows.
1. Download the installer (Basically .exe file)
2. Install JDK. This is simple and ***Next***  ***Next*** and ***Finish*** procedure.
3. Then set the java_home path on your environment variables. You can follow this [link](https://youtu.be/p3FF0aDcIg8) to see how to setup the environment variables.



### Congratulations now you have setup the JDK in next step we will see how to Setup the IDE. 