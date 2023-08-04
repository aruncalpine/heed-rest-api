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
Select a and hit Enter:
Next, the script will prompt you to enter the details of the new user:
```
Enter the details of the new user to add.
Using realm 'ManagementRealm' as discovered from the existing property files.
Username : wildfly
Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should be different from the username
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
Password : 
Re-enter Password : 
What groups do you want this user to belong to? (Please enter a comma-separated list, or leave blank for none)[  ]: 
About to add user 'wildfly' for realm 'ManagementRealm'
Is this correct yes/no? yes
Added user 'wildfly' to file '/opt/wildfly-16.0.0.Final/standalone/configuration/mgmt-users.properties'
Added user 'wildfly' to file '/opt/wildfly-16.0.0.Final/domain/configuration/mgmt-users.properties'
Added user 'wildfly' with groups  to file '/opt/wildfly-16.0.0.Final/standalone/configuration/mgmt-groups.properties'
Added user 'wildfly' with groups  to file '/opt/wildfly-16.0.0.Final/domain/configuration/mgmt-groups.properties'
Is this new user going to be used for one AS process to connect to another AS process? 
e.g. for a slave host controller connecting to the master or for a Remoting connection for server-to-server EJB calls.
yes/no? yes
To represent the user add the following to the server-identities definition <secret value="UGFuMjNkZWo3NyNA" />

```
Step 6: Test the WildFly Installation
```
http://<your_domain_or_IP_address>:8080

```
