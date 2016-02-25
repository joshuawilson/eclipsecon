# Arqillian Cube Docker & OpenShift demo


## Set-up Instructions

1. Add tcp settings to docker config  
   *  You will need to use TCP/IP to connect to the Docker server. You will need to make sure that your Docker server is listening on TCP port. To allow Docker server to use TCP add the following line to `/etc/default/docker` or `/etc/sysconfig/docker`:   
   
        DOCKER_OPTS="-H tcp://127.0.0.1:2375 -H unix:///var/run/docker.sock"

        OPTIONS='--selinux-enabled --log-driver=journald -H tcp://127.0.0.1:2375 -H unix:///var/run/docker.sock'
   
   *  After restarting the Docker daemon you need to make sure that Docker is up and listening on TCP. Run this command, if no errors return then you are ok.
   
        $ docker -H tcp://127.0.0.1:2375 version


2. Change the url for OpenShift  
    *  Open the `arquillian.xml` file and around line 25 is a `originServer` property  
    *  Update the URL to the URL of the running instance of OpenShift that you want to deploy to  

3. Add a project to OpenShift  
    *  Open the `arquillian.xml` file and around line 26 is a `namespace` property that is set to `demo`  
    *  Create a project in OpenShift to match the name of the namespace  


## Running it

### In Eclipse/JBDS

1. Confirm that everything is imported and builds.  
2. Ensure that it is a Maven project (if not right click the project, select Configure, select Convert to Maven)  
3. Open the JUnit view  
    1. Select Window  
    2. Point to Show View  
    3. Select Other  
    4. Expand Java  
    5. Select JUnit  
    
4. Run the test  
    1. Right click the project  
    2. Point to Run As  
    3. Select JUnit test  
    4. Change to the JUnit view  

### To run on OpenShift

1. Go to the project in the terminal to the level the pom.xml is at (should be the project root).  
2. Login to OpenShift at the cli  
    *  oc login [URL for OpenShift]  

3. Run this command:  
    *  `mvn clean install -P openshift`
    
4. Go to the OpenShift web console and open the project you created for this demo and watch the pod get created for the test. 
