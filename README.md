# Wildfly Server installation Instructions
## Pre Requisites ##
  Install JAVA 17
~~~
sudo  apt update -y
sudo  apt install openjdk-17-jdk -y
~~~

Download and Install Wildfly

```
WILDFLY_VERSION=28.0.0.Final
cd /tmp
wget https://github.com/wildfly/wildfly/releases/download/28.0.0.Final/wildfly-$WILDFLY_VERSION.tar.gz
tar -xf wildfly-28.0.0.Final.tar.gz
mv wildfly-28.0.0.Final wildfly
sudo  mv /opt/wildfly
```
