# Wildfly Server installation Instructions
## Step 1: Install Java OpenJDK ##
~~~
sudo  apt update -y
sudo  apt install openjdk-17-jdk -y
~~~

## Step 2: Create a User ##

~~~
sudo groupadd -r wildfly
sudo useradd -r -g wildfly -d /opt/wildfly -s /sbin/nologin wildfly
~~~
## Step 3: Download and Install WildFly ##
```
WILDFLY_VERSION=28.0.0.Final
cd /tmp
wget https://github.com/wildfly/wildfly/releases/download/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz
tar -xf wildfly-28.0.0.Final.tar.gz
mv wildfly-28.0.0.Final wildfly
sudo  mv /opt/wildfly
sudo chown -RH wildfly: /opt/wildfly
```
### Step 4: Configure Systemd ###
```
sudo mkdir -p /etc/wildfly
```
Copy the configuration file to the /etc/wildfly directory

```
sudo cp /opt/wildfly/docs/contrib/scripts/systemd/wildfly.conf /etc/wildfly/

```
copy the WildFly launch.sh script to the /opt/wildfly/bin/ directory

```
sudo cp /opt/wildfly/docs/contrib/scripts/systemd/launch.sh /opt/wildfly/bin/

```
The scripts inside bin directory must have executable permission 

```
 sudo sh -c 'chmod +x /opt/wildfly/bin/*.sh'

```
 copy the systemd unit file named to the /etc/systemd/system/ and reload daemon

```
sudo cp /opt/wildfly/docs/contrib/scripts/systemd/wildfly.service /etc/systemd/system/
sudo systemctl daemon-reload
```
Start the WildFly service 
```
sudo systemctl start wildfly
```
Check the service status 
```
sudo systemctl status wildfly
```
## Step 5: Configure WildFly Authentication ##
```
sudo /opt/wildfly/bin/add-user.sh
```
You’ll be asked what type of user do you wish to add:
```
What type of user do you wish to add? 
 a) Management User (mgmt-users.properties) 
 b) Application User (application-users.properties)
(a):

```
