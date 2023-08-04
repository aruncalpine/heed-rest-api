# Wildfly Server installation Instructions
## Pre Requisites ##
  Install JAVA 17
~~~
sudo  apt update -y
sudo  apt install openjdk-17-jdk -y
~~~

Install Wildfly-28.0.0.Final 



```
cd /tmp
wget https://github.com/wildfly/wildfly/releases/download/28.0.0.Final/wildfly-28.0.0.Final.tar.gz
tar -xf wildfly-28.0.0.Final.tar.gz
mv wildfly-28.0.0.Final wildfly
sudo  mv /opt/wildfly
```
