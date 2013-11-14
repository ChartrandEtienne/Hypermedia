#!/bin/sh
ant jar
ant war
sudo cp build/Chess.war /var/lib/tomcat7/webapps

