package studios.ingot.databaseapi.model.database.credentials;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MySQLDatabaseCredentials {
    private String user = "root";
    private String password = "yoursecurepassword";
    private String database = "database";
    private String host = "localhost";
    private int port = 3306;
}
