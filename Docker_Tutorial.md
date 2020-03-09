0050622297 
782987452920
AROPG2050K
------
https://github.com/keethesh/UdemyCourseGrabber/blob/master/functions.py

https://resources.edureka.co/ai-ml-nit-warangal/

1. container vs VM
2. container vs image.
3. windows container vs linux containers
4. what is virtualization, kernal, Hyper-V

-------Section 1: Docker Introduction--------------------
1) Docker(Containerization):---
	mobidock
	GortanTheTurtle

2) Main reason to use it due to fact that it runs in same way fundamentally. 
   No changes need to be done on WIN, Linux or MAC.
   Everything is packed inside container.

3) Docker Edition:----
	docker is no longer just a "container runtime"
	docker moves fast means it version upgrades frequently so it matters how we install it.

4) docker CE version:- free source
	docker EE version: paid version
	EE= enterprise edition 
	EE= support + extra products
	EE = certified on specific platforms
	docker.com/pricing

5) Stable vs Edge:-
	Edge(beta) released monthly, stable released quaterly.
	Edge gets new features first but supported only for month.

6) Three types of install: direct, mac/windows, cloud
 --Direct:- by default linux container were created and used.  
 
 --Docker on windows:-
	After late 2016, docker for windows was created but it works only for enterprise and Pro version.

	-for wind 7/8/8.1 or wind 10 home edition, we need Docker Toolbox software installed.
	-it runs a tiny Linux VM in virtual box 	via docker -machine to start virtual box.
	cmd:- docker-machine start

	-uses bash shell to make it more like Linux/Mac options
	-does not support windows containers.

 --For cloud:-

-------Section 2: The best way to setup docker for your OS-----------
1) Types of containers windows can run: 
   -Linux containers using 'docker toolbox'. 
   -Windows container using 'Docker for Windows'.

2) Software installations:
  i) visual studio code
 ii) Github
iii) Docker for windows: Make sure hyperV is enabled on windows machine
 iv) Setup Tab completion in Powershell:
	-open CMD:- Install-Module -Scope CurrentUser posh-docker
	-To enable it:- cmd: Install-Module  posh-docker 
	-In case security exception occurs 
	  --open windows powershell in admin mode:-
	  --enter command:- Set-ExecutionPolicy Remotesigned

	Now again execute Install-Module posh-docker cmd. It will work but this will not work in all sessions. 
	To overcome this, type cmds and create $PROFILE

  v) To use other powershell for docker install cmder from site:- cmder.net 
     -Use cmder to connect to docker server:-
     -By default, it is not connected.
	 -Execute cmd:- docker-machine env default
     -After that, run cmd: docker version and check. It will show both client and server docker details.

 vi) Now open GIT Bash and execute below cmd to clone repo:-
	 -cmd:- git clone https://github.com/BretFisher/udemy-docker-mastery.git 
	 -Websites: https://chat.bretfisher.com/
                dockermastery.slack.com

NOTE: Code paths enabled for Bind Mounts works in C:\Users only.

3) For windows, Docker installation:-
 I) For windows 10, Pro and Enterpise Edition:
   -Go to store.docker.com and select CE edition and download Docker for Windows.
   -Install the software after downloading.
   -If Hyper-V is not enabled, then post installation it will ask to enable it. On click of enable, it will restart system.
   -After restarting the system, docker will be successfully installed. 

II) For windows 10, Home editions:- 
    -Home editions does not support Hyper-V, so we need to install Docker toolbox for windows.
	-Install all components shown in installation window.
	-Docker Quickstart shortcut will be seen on desktop, open it and hit cmd: docker-machine.
	-It will show running VM which sits behind OS to run docker. Use IP http://192.168.99.100 provided by VM.
	-After installation, we can start and stop docker VM.
	-Open Oracle VM, there is will show running VM. We can configure it and even start stop it.
	-After stopping VM, we can again run it using Docker quickstart cmd,
	  --Hit cmd: docker-machine --start.

III) Docker on linux:-
	-3 ways to install:
    	script,store or docker-machine
  i) script:- curl -sSL https://get.docker.com/  | sh

 ii) Steps to install docker:-
   1) install docker. (goto: https//get.docker.com and execute docker install cmd from site.)
	   -add your user to docker group (cmd:- sudo usermod -aG docker <username>)
         --user should be admin or be in docker group or should type sudo with every cmd to work with docker.
   2) After getting docker, we need to install two other tools: docker compose and docker machine
      Copy cmds from section Docker Machine and execute it.
      OR we can get cmds from github:- https://github.com/docker/compose/releases
		        						https://github.com/docker/machine/releases
    Check installation using cmds: docker-compose version
								   docker-machine version
			
   3) clone gitrepo (To install git: cmd: sudo apt install git)
   4) Get code editor like Microsoft VS Code. Add extension docker to VS Code. 
      Use cmd: code . to open VS code having cloned repo code.
   5) Tweak your terminal and shell


--NOTES::
1) Docker Engine is now Docker community Edition.It include cli client and backend demon/service and API.
2) Docker Data Centre is now Docker EE. It has paid products.
3) Docker version is now in form of YY.MM based.
4) There are two releases tracks: Stable and Edge
   -Edge is released monthly and provides support for one month.
   -Stable is released quaterly and provides support for 4 months.
5) On windows, engine is called as Service.
   On linux, engine is called as demon.
   Ideally, docker cli and server version should be same but can be different too.

----------Section 3:Creating and using containers like Boss----------   
1) check installation status of docker:
   -cmd: docker version OR sudo docker version.
   -To check docker information:
     --cmd: docker info
  -To get list of docker commands:-
    --use cmd: docker
  -To organize long list of cmnds, docker created management commands:-
    --Management cmds format: docker < management-command> <sub-command> (options)  
			older way(still works): docker <sub-command>(options)
	 
2) Diff. btwn Image and Container:-
   -An image is a application that we want to run.
   -A container is the instance of the image that runs as a process.
   -You can have many containers running off the same image.
   -Docker default image "registry" is called Docker Hub.(hub.docker.com)
    --registry is same as GitHub to source code.
  
  -For lecture, we will use Nginx web server image.
    --cmd: docker run --publish 80:80 nginx
     Explaination:
	  -'nginx' is the image.
	  -left side 80 is the port no. of host machine on which docker is installed. We can provide any port no. 
	  -But make sure, we can get error if this port is being used by anything else even by other container.
	  -Right side port no. is the port no. of nginx server 

   --To stop container, we use Ctrl+C keys. But in windows, it does not stop container. The container runs in background.
     To stop on windows, after pressing Ctrl+C, hit cmd:-  docker stop <container_Id/name>

   --To avoid running of container fronthand, we can detach it to run in background:-
     cmd: docker run --publish 80:80 --detach nginx

   --To check conatiner list:
     cmd: docker container ls  (ls only shows running containers)
	 cmd: docker container ls -a (shows all containers)

   --By default, docker provides random name to container. To provide name to container:-
     cmd: docker run --publish 80:80 --detach --name webHost nginx 

   --To check logs of background runninng container.
     cmd: docker container logs <container_name>
		Old way: docker logs <container_name>
	 cmd: docker logs --help (For help purpose)

   --To check process running inside container,
     cmd: docker container top <Container_Name>   
  
  --To check all cmds under container:-
     cmd: docker container --help
	 
  --To remove containers:-
    cmd: docker container rm <container_ids seperated by space.>
	cmd to force del runing container: docker container rm -f <container_ids seperated by space.>
	
NOTE: cmd docker run always starts new container.
      cmd docker start starts existing container.
	  we should stop container before removing it otherwise it will give error.
	  
3) What Happens in 'docker container run':--
  -looks locally for the image in the image cache, if it does not find anything.
  -Then it looks for the image in the  remote image repository(default to docker hub) and downloads the latest version(nginx:latest) if no version is provided.   
  -and creates container based on the image and prepares to start
  -gives a virtual IP on private network inside docker engine.
  -Opens up port 80 on host and forwards to port 80 on container.
  -starts container by using CMD in the image dockerfile.
  Eg: docker run --publish 8080:80 --detach --name webHost nginx:1.11 nginx -T
 (8080 port no. of host and 80 port no. on container.
	1.11 is the version of nginx.
	nginx last one is the change CMD run on start)
 
4) Container VS VM:-
	-Container are the process running on host machine.
	-Container have access to limited resources.
	-They exist when process stops.
	Cmd: ps aux (shows all running processes including the cmd run)
		
5) Docker is not just linux:-
  Today Docker is much more than Linux. When you think of images, which are kernel specific, we're now talking about Linux x64,
  Linux x86 (32-bit), Windows 64bit, and a bunch more. This course still largely focuses on Linux x64 images because 90% of the concepts are the same, 
  but "Windows Containers" are the new hotness! Technically, they are Native Windows .exe binaries running in Docker containers on a Windows kernel,
  and have no Linux installed.

  If you check the course Description, I mention at bottom in "Course Launch Notes" about Windows Containers as a future Section I plan to add.
  When making this course in 2017, I didn't know anyone really using them because Swarm Overlay networking didn't work on Windows, Secrets didn't work yet,
  and there were lots of rough edges that people wouldn't find very useful.

  But with the release of 17.09 stable, the story for Windows Containers is much better and I plan on a new section for this. Until then, 
  here's some recent getting started videos from Docker and Microsoft:
	i) Windows Containers and Docker 101
	ii) Windows and Linux Parity with Docker
	iii) Docker + Microsoft - Investing in the Future of your Applications	

6) Assignment: run and manage multiple containers
	Cmds:-
	docker container run -d -p 3306:3306 --name db -e MYSQL_RANDOM_ROOT_PASSWORD=yes mysql
	docker container run -d --name webserver -p 8080:80 httpd
	docker container run -d --name proxy -p 80:80 nginx
	
	NOTE: docker container ls -a & docker ps -a gives same result.
	
7) what's going inside container: CLI Monitor processing.
	cmd: docker inspect <containerName>(old way): shows metadata(configuration) about the container(startup,config,volumes,networking etc)
	cmd: docker container stats --help (shows live performance data for all containers)
	cmd: docker container stats <containerName> (shows live performance data for container)
	
8) 	Getting shell inside contianer: No need of SSH
	-Docker CLI is a great substitute to add SSH to containers
	cmd: docker container run -it (-t = allocate a pseudo --TTY= stimulates a real SSH like what SSH does)
	
	-To go inside image present in running contianer, '-it' is used.
	Eg:- to go inside the container of nginx.
	  cmd: docker run -it --name nginx <containerName> bash
	  Here, 2nd nginx is the name of the image. 'bash' is used to open SSH inside contianer.
	  After hitting run cmd, bash terminal opens up. root@containerId:/#
		--To exit from container, type 'exit'
	  After this cmd, container stops as the container runs as long as the cmd that run on startup. 
	  The default cmd is to run nginx program itself. "nginx g demon ..."
	  But we types bash so it opens bash shell.
		--If container is stopped, then to start same container in interactive mode,use below cmd:-
			cmd: docker container start -ai <containerName>
	 
	  -To open another linux distrubution,
	  cmd: docker container run -it --name ubuntu ubuntu (Here,bash is default cmd of ubuntu)
	
	-To run additional process in already runnning container:-
	cmd: docker container exec -it <containerName> <command>
	Eg: docker container exec -it mysql bash (ps command is not included by default in mysql image)(mysql will run inside.)
	It will run a additional process in the root container.
	On exit, it will not stop running container mysql.
	
9) Docker network: Concepts
	-check open port for the container.
	cmd: docker container port <containername>
	-It explains that two containers can talk to each other without the need of publishing port.
	-There is a virtual network called bridge/docker-0 to which containers are connected.
	-So if we write -p 8080:80, then it means the requested URL will conect through 8080 port and it will map to 80 port of the container using virtual network.
	-For Ex: if we have two containers mysql and ubuntu then mysql can be run inside ubuntu container. Thus, they can connect each other directly without using ports.

10)	In 2017, 'nginx' image has removed ping from its release. So in case of nginx image name, we should use 'nginx:alpine' image name.

11) Docker networks: CLI management commands:-
	-To list networks: cmd: docker network ls
	-To inspect a prticular network: cmd: docker network inspect <network name>
	-To create a new network: cmd: docker network create <network name>
	-Network drivers: built in or 3rd party extensions that give your virtual networks featueres.
    -To connect a container to newly created network: cmd:
	  docker rn -d --name nginx_new --network <network_name> <image_name>
	-to perform operations on network, check cmd: docker network --help
	It will show options to create,connect, disconnect,inspect containers from networks
	
	-Docker network connect:- dynamically creates a NIC in container on an existing virtual network.
	 It connects a container to a virtual network which means a container can be connected to two diff. virtual networks.
	 cmd: docker network connect <network_name> <container_name>
	 
	-docker network disconnect: to disconnect the container from network  
	 cmd: docker network disconnect <network_name> <container_name>
	 
	Docker networks: Default security:-
	-If all applications containers are running on single server, then it will be more secure as we don't have to over expose ports and virtual networks.
	-create apps so that frontend/backend sits on same docker network.
	-the inter communication never leaves host.
	-all external exposed ports are closed by default. You must manually expose via -p, which is better default security.
	-this get better with overlay and swarm networks.
	-Keeping virtual networks and app. containers on same server is more secure.
	
	NOTE: we used default driver 'bridge' to create new network. To use another driver,use --driver <driver_name> while creating network.
	
12) docker networks: DNS
	-DNS is key to easy inter-container communication.
	 We cannot rely on IP address inside container as IP's are always dynamic.
	-Use --link to enable DNS on default bridge network. 
    -Forget IP's: static IP's and using IP for talking to containers is anti-pattern.Use your best to avoid it.
	-Docker DNS: docker daemon has built it DNS server that containers use by default.
	-Docker Default Names: docker uses by defaults the hostname to container name,but you can also set alias.
	  Docker uses container name by default as we use host name to connect to another container.
	
	-To ping a container from another container:
	cmd: docker container exec -it <container_name> ping <container_name>
	
	-Default virtual network 'bridge' does not have DNS server in it.
	 We can create it using --link while creating container.But instead it is much easier to create network and then link container to that network to
	 avoid extra overhead.
	 
13) DNS Round Robin testing:-
    DNS Round robin: having two diff. host with DNS alias repsonding to same DNS address.
	
	Steps for DNS Round Robin testing:-
	1.create network: docker network create dude.
	2. run two container for image elasticsearch:2 
	  --network-alias or --net-alias both works.
	 cmd: docker run -d -network due --net-alias search elasticsearch:2
		  docker run -d -network due --net-alias search elasticsearch:2
	
	3. Search for network DNS alais assigned:-
     cmd: docker container run --net dude alpine nslookup search (It will show containers assigned to network dude and both will have same DNS names)
	  	  
	 
----------Section 4:----------------------------
1) What is an Image?
	• An Image is an ordered collection of root filesystem changes and the corresponding execution parameters for use within a container runtime.
  	• App binaries and dependencies.
	• Metadata about the image data and how to run the image.
	• Not a complete OS. No kernel, kernel modules (e.g. drivers).
	• Small as one file (your app binary) like a golang static binary.
	• Big as a Ubuntu distro with apt, and Apache, PHP, and more installed.

2) Using Docker Hub: Using Registry Images:
	• Docker Hub, "the apt package system for Containers"
    -Alpine:- 
	• small distribution of linux. approx. 5 MB.
	• Image Id is based upon the cryptographic shaw of docker in  docker hub.
	
3) Images and Layers: Discovering the image caches:-
   -To know about layers in an image:
    use cmd: docker history <image_name> (It will show complete layers starting from 1st one called as scratch)
	• Each layer has unque identiy.
	• Images are made up of file system changes.
	• Each layer is uniquely identified and stored once on a host.

   -Use inspect cmd on image to get metadata of image:-
    cmd: docker image inspect <image name>
	    Ex: docker image inspect nginx
	  
	• A container is just a single read/write layer on top of image.
	• Docker image history and inspect commands can teach us.	

4) Image tagging and push to Docker Hub:-	
   to tag a image:-
   cmd: docker image tag --help
	
   -default tag is latest if not specified:
     <user>/<repo>:<tag>
	-If we are dealing with official images of docker hub then user/organization name is not needed.
	-Tag is same like GIT tags used for tagging a particular commit.
	-'latest' tag should be given by image owners to stable version of image.
	-Tags are just labels which may point to same Image Id.
	
	-Re-tag already existing image having tag(retagging a image)
		cmd: docker image tag <source_image:tag> <new_image:tag>
		Ex: to re-tag nginx image: docker image tag nginx akhil/nginx (this will add a new image showing akhil/nginx under repo. section. both having same Image_Id)
	
	-You can push this image re-tagged to docker hub using push cmd:
     cmd: 	docker image push <imageId>
	 
	-If same image is re-tagged, then image_Id remains same.
