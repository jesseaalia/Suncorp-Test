WebApp
=========

Test Spring MVC REST application

SOFTWARES : java 8 , Apache Maven 3.x , Tomcat 8, Mysql 5, mysql workbench, sts spring

1 .  Download Apache Maven from link http://maven.apache.org/download.cgi 
apache-maven-3.2.2-bin.zip

2. unzip C:\Program Files\Apache\maven

3. set environment variables JAVA_HOME , M2_HOME =C:\Program Files\Apache\maven, MAVEN_HOME =C:\Program Files\Apache\maven

4. Add To PATH

Update PATH variable, append Maven bin folder – %M2_HOME%\bin, so that you can run the Maven’s command everywhere.

5. verify maven 

	1. Open cmd prompt 
           2.  C:\myproject\ ATMCashMan> mvn -version


Build Commands : 

C:\myproject\ ATMCashMan> mvn clean install

Deploy : Above command generates War file  CashMan.war in target folder.

Copy war file to tomcat webapps location.

Running Application: Run tomcat 

Home Page URL:  http://localhost:8080/cashman

