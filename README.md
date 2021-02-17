# async-spigot-database-API
# usage:

`
databaseService.getMongoDatabaseHandler().getAsyncModel("COLLECTION", Filters.eq("KEY", "UUID"));
databaseService.getMongoDatabaseHandler().getAsyncModels("COLLECTION");
databaseService.getMongoDatabaseHandler().insertModel("COLLECTION", new Document());
databaseService.getMongoDatabaseHandler().updateModel("COLLECTION", Filters.eq("KEY", "UUID"), new Document());
`

`       
databaseService.getMySQLDatabaseHandler().getAsyncModel("QUERY");
databaseService.getMySQLDatabaseHandler().getAsyncModels("QUERY");
databaseService.getMySQLDatabaseHandler().insertModel("QUERY");
databaseService.getMySQLDatabaseHandler().updateModel("QUERY");
`
