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
```

