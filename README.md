# GTFSParser
============
The goal of this project is to build a parser in Java which reads GTFS files and creates an engineered suitable POJO structure filled with the data.
GTFS specifications can be found here : "https://developers.google.com/transit/gtfs".
Maven project tool is also used here.
MySql is used to create a database and populate it with the pieces of information extracted from the GTFS.
IntelliJ IDEA IDE has been used to implement this project.

=============================================================================================================================

PROJECT LAYOUT:
===============
pom.xml : As maven is used, pom.xml is an XML file that contains information about the project and configuration details used by Maven to build the project.

goto src/main/java/com/waynaut/parser. Here there are 3 packages and an Application.java class.

The package "modal" defines various classes for storing the data objects from the GTFS files.
Basically, classes inside "model" provide a blueprint for object creation.

The package "saveCsvToSQLDatabase":
"UnzipUtility" static class is used to extract the "data/GTFS.zip" file into "data/GTFS".
Now this complete data gets saved in database using "ReadAndSave" class. This data from database would be used for appropriate objects creation in "makeObjectsFromGTFS" package.
"MySQLConnection" java class is used to get connection to MYSQL database.

The package "makeObjectsFromGTFS":
Classes in this package get data from MYSQL database and create objects of respective classes of "modal" package.

Application.java is the main controller class which contains main() for execution of this project.

Folder "data" has been used to put GTFS.zip file inside it for processing. It must be noted that GTFS.zip file must contain ".txt" files as per the GTFS specification.

=============================================================================================================================

PROJECT SETUP AND RUNNING THE PROJECT:
======================================
Some initial setup is required to run this project.

Clone this repository and put it into a directory.

Make sure that Java 8 and MySql database has been properly installed onto your system.

Now, put the GTFS zip file inside the "data" folder and rename the zip file as "GTFS.zip". The file name is case sensitive.

 Thus, project directory would be something like:

.
+ pom.xml
+ Readme.md
+ data
   + GTFS.zip
      + agency.txt
      + calendar.txt
      + .....
      + .....
      + .....

All these ".txt" files are literally text CSV files which are a part of GTFS data feed.

Now, run Application.main() to view the output.
To give a meaningful representation to the created objects from GTFS.zip, Json printing format is used because Json is a good way for the purpose.

=============================================================================================================================
