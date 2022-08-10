# todoapp
 
App to keep track of your current day tasks

# Enviroment
- Install Java 8 or greater
- Install Maven
# How to run
1. Install by running "mvn clean install -Dh2.database.location=C:\yourdirectory" using command line in project directory. By default C:\databases is directory path for h2.
2. Start Payara by running "mvn payara-micro:start -Dpayara.server.http.port=8080" using command line in project directory. By default HTTP port is 8080.
3. Open browser and navigate to http://localhost:8080/todo-app/todolist.xhtml