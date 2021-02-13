package studios.ingot.databaseapi.model.database.credentials;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MongoDatabaseCredentials {
    private String user = "admin";
    private String password = "gusosasi123";
    private String host = "localhost";
    private int port = 27017;
    private String database = "database";
}
