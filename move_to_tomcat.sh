#! /bin/sh
#
# bat.sh
# Copyright (C) 2020 kalipy <kalipy@debian>
#
# Distributed under terms of the MIT license.
#


rm ~/下载/apache-tomcat-9.0.38/webapps/01Servlet/* -rf

cp ~/bak2/gradle_javaweb/src/main/webapp/* ~/下载/apache-tomcat-9.0.38/webapps/01Servlet/. -rf

mkdir ~/下载/apache-tomcat-9.0.38/webapps/01Servlet/WEB-INF/classes 

cp ~/bak2/gradle_javaweb/build/classes/java/main/com ~/下载/apache-tomcat-9.0.38/webapps/01Servlet/WEB-INF/classes/. -rf

cp ~/bak2/gradle_javaweb/build/distributions/gradle_javaweb/lib ~/下载/apache-tomcat-9.0.38/webapps/01Servlet/WEB-INF/. -rf

cp ~/bak2/gradle_javaweb/src/test/resources/c3p0-config.xml ~/下载/apache-tomcat-9.0.38/webapps/01Servlet/WEB-INF/classes/. -rf


