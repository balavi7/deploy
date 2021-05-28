# To build and deploy the helloWorld application using jenkins
## Steps to create a java program and run it
### Step 1 
Created a helloWorld program using spring initializer.It will generate a zip file, unzip in your local folder.
### Step 2
Open sts and start SpringToolSuite, we will have to provide the workspace to it.
### Step 3
Click on file,import and select the location where your java project is residing.
### Step 4
In the package explorer section we get our project, in src/main/java we have our application.java file, controller.java file and in target we have our pom.xml file.
## Steps to push it to github (github is used as code repository)
### Before that we have to create a repository in github. after creating it will provide us a path or location.
### Click on the project name then click on properties and go to the location of our project. Open command line on this location and initialize git command.
#### commands
* git init
* git status
* git add
* git commit - m "comment about the adds"
* git remote add origin "give the path url of github"
* git push - u origin master
#### we have configured
### Next is to create a EC2 instance ( we will have to create an AWS account for it )
Create an account and log in using the id and password.
## Steps to create an ec2 instance
### Step 1
Click on all services and select EC2 service.
### Step 2
Click on launch instance then we will get a page where it has total 7 steps following:
* choose AMI (select free tier)
* choose instance type (t2.micro)
* choose instance details
* add storage
* add tags
* security groups
* review and launch
* we have to select existing key pair or create one new key pair (pem file)
### once the instance is launched we have our instance running and we get our public ipv4 address.
To connect to our instance through SSH we need to get connected through putty
### Open puttygen, generate, load and select the pem file. It will convert it into ppk file then save private key.
### Open putty, provide the public ip, click on SSH, auth and put the ppk file in it.
Once we are logged in as ec2-user we are inside VM. We can perform linux commands.
#### Commands to install jenkins on AWS
 * sudo yum update (to check for the updates)
 we have to install java before installing jenkins
 * sudo yum install java-1.8.0
 * sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo ( to download latest jenkins code package )
 * sudo rpm --import https://pkg.jenkins.io./redhat.jenkins.io.key ( import a key file from jenkins CI to enable installation from the package
 * sudo yum install jenkins -y
 * sudo service jenkins start
 * http://public ip:8080  ( access jenkins using public IP of ec2 on port 8080
 * sudo su -  ( to get into root user)
 * ls -l
 * initial admin password 
 * cat initial admin password
  ### Now we are inside our jenkins 
  ### we can create a job and configure it by clicking new item.
  once the job is created we can click on configure, click on SCM add your github url and then in poll SCM we can set the cron expression to build the trigger every minute. Then in the build section select execute batch command or execute top level maven command and write the command as clean compile test package.
  this command will build the jar compile the test and run our project.
  We can deploy through post build steps.
  
  link :  * https://github.com/balavi7/deploy.git
  
  ![New Doc 2021-05-28 16 56 03_1](https://user-images.githubusercontent.com/82412177/119977917-99d96580-bfd6-11eb-9b77-9020c399ec8f.jpg)
     
