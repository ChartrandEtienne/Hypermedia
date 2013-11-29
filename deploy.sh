#!/bin/sh
ant jar
ant war
sudo cp build/Linx.war /lib/tomcat7/webapps

