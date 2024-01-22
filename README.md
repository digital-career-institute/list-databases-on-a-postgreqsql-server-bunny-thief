# Exercise # 1 - List databases on a PostgreqSQL server

> **Create a Java Application, "DatabaseLister" that connects to the PostgreqSQL database server on localhost and list out names of all databases**

***Hint:*** 
- Download JDBC Driver library for PostgreqSQL
-- Search on internet for the above.
- Add this to the classpath
- Create an instance of *Connection* using *DriverManager* API
-- Specify the URL (with default database), username and password appropriately
- Lookup into "pg_database" table for the "datname" field.
- Iterate through the result and gather the result/values 
- Display the gathered values as the list of databases

