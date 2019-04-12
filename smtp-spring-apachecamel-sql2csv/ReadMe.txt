
ApacheCamel-sql2csv Project.

Send email with attached csv file using Spring / Camel Boot / JDBC connection
==================================================================================

Prerequisites:

1. Update create_table_email.sql with your To email addresses.

2. Set JDBC connection resources\spring-contextprops-dir\appcontext-production.properties .

3. Set From email addresses resources\spring-contextprops-dir\appcontext-production.properties (in APP.CAMEL_CONTEXT.ROUTE2_MAIL_FROM=).

4. Set MAIL_SERVER resources\spring-contextprops-dir\appcontext-production.properties (in APP.CAMEL_CONTEXT.ROUTE2_MAIL_SERVER=).

5. Using SQL SELECT Statement to get the record to import in csv file (in appcontext-production.properties (APP.CAMEL_CONTEXT.ROUTE1_SQL=)).



***To build this project***

1. Set JAVA_HOME and ANT_HOME in system variable.
Note: Download and Install the JAVA and ANT if not exists.

2. Open the command prompt and run as administrator. Go to <Drive>\ SpringBootConsoleAppApacheCamelSQLToCSV , and run the following command > ant distribute .

3. *JAR file created.

4. Execute the query to DB to create email table.

5. Edit the .bat file
Note: <Drive>\springboot\apachecamel-sql2csv_csi-report\jar\SpringBootConsoleAppApacheCamelSQLToCSV.jar

6. Run the batch file to run the jar file.

7. Verify the log file.


