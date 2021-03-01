# Asynchronous Spigot Database-API

This is an asynchronous database framework/API that allows quick and easy use of MySQL (MariaDB) and MongoDB. To add this framework as a dependency, follow the instructions in
[Gradle](#gradle-dependency) or [Maven](#maven-dependency).


# Usage MongoDB

Get DatabaseHandler instance
```java
MongoDatabaseHandler databaseHandler = databaseService.getMongoDatabaseHandler();
```
Get single `Document`
```java
Document mongoDocument = databaseHandler.getAsyncModel("CollectionName", Filters.eq("UUID", player.getUniqueId().toString()));
```
Get `List` of `Document`
```java
List<Document> mongoDocumentList = databaseHandler.getAsyncModels("CollectionName");
```
Insert `Document`
```java
Document mongoDocument = new Document();
mongoDocument.put("UUID", player.getUniqueId().toString());
databaseHandler.insertModel("CollectionName", mongoDocument);
```
Update `Document`
```java
Document mongoDocument = new Document();
mongoDocument.put("UUID", player.getUniqueId().toString());
mongoDocument.put("Kills", 10);
databaseHandler.updateModel("CollectionName", Filters.eq("UUID", player.getUniqueId().toString()), mongoDocument);
```
```java
databaseHandler.deleteModel("CollectionName", Filters.eq("UUID", player.getUniqueId().toString()));
```

# Usage MySQL (MariaDB)

Get DatabaseHandler instance
```java
MySQLDatabaseHandler databaseHandler = databaseService.getMySQLDatabaseHandler();
```
Get single `ResultSet`
```java
String queryStatement = "SELECT * FROM `player_stats`";
ResultSet resultSet = databaseHandler.getAsyncModel(queryStatement);
```
Get `List` of `ResultSet`
```java
String queryStatement = "SELECT * FROM `player_stats`";
List<ResultSet> resultSetList = databaseHandler.getAsyncModels(queryStatement);
```
Execute Insert-Statement
```java
String insertStatement = "INSERT INTO `player_stats` (`UUID`, `KILLS`, `DEATHS`) VALUES ('" + player.getUniqueId.toString() + "', '0', '0')";
databaseHandler.insertModel(insertStatement);
```
Execute Update-Statement
```java
String updateStatement = "UPDATE `player_stats` SET `KILLS`='" + kills + "' WHERE `UUID`='" + player.getUniqueId.toString() + "'";
databaseHandler.updateModel(updateStatement);
```
Execute Delete-Statement
```java
String deleteStatement = "DELETE FROM `player_stats` WHERE `UUID`='" + player.getUniqueId.toString() + "'";
databaseHandler.deleteModel(updateStatement);
```

# Gradle Dependency 

Add [JitPack](https://jitpack.io) as repository:
```kotlin
repositories {
    maven { 
      url 'https://jitpack.io' 
    }
}
```
Add the API as dependency:
```kotlin
dependencies {
    implementation 'com.github.IngotStudios:async-spigot-database-api:master-SNAPSHOT'
}
```

**ATTENTION: `master-SNAPSHOT` always pulls the newest version from the repository!**

# Maven Dependency 

Add [JitPack](https://jitpack.io) as repository:
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
Add the API as dependency:
```xml
<dependency>
    <groupId>com.github.IngotStudios</groupId>
    <artifactId>async-spigot-database-api</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

**ATTENTION: `master-SNAPSHOT` always pulls the newest version from the repository!**
