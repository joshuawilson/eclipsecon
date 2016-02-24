Add tcp settings to docker config  

If you want to use TCP/IP to connect to the Docker server, you’ll need to make sure that your Docker server is listening on TCP port. To allow Docker server to use TCP add the following line to /etc/default/docker or /etc/:

	DOCKER_OPTS="-H tcp://127.0.0.1:2375 -H unix:///var/run/docker.sock"

After restarting the Docker daemon you need to make sure that Docker is up and listening on TCP.

	$ docker -H tcp://127.0.0.1:2375 version
	
set up jboss.org in settings.xml  
change the url for openshift in the arquillian.xml  
add a "demo" project to openshift  
