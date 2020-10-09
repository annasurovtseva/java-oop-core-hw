package ru.surovtseva.hw8;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.surovtseva.hw8.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static ru.surovtseva.hw8.db.JDBC.*;

public class testJDBC {

    private static Connection connection;

    @BeforeAll
    public static void createDBConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("Anna");
        dataSource.setPassword("Password!@#");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hw8");
        dataSource.setServerTimezone("UTC");

        connection = dataSource.getConnection();
    }

    @Test
    public void getUsersInfoTest() throws SQLException {
        List<User> actualData = getUsersInfo(connection);

        org.assertj.core.api.Assertions.assertThat(actualData)
                .startsWith(new User(1,"Petr",27,"petr@mail.com"))
                .contains(new User(2,"Anton",40,"anton@hotmail.ru"),
                        new User(3,"Ivan",35,"ivan@mail.ru"));
    }

    @Test
    public void  showUsersByAgeTest() throws SQLException {
        List<User> actualData = showUsersByAge(connection,25,37);

        org.assertj.core.api.Assertions.assertThat(actualData)
                .containsOnly(new User(1,"Petr",27,"petr@mail.com"),
                        new User(4,"Roman",29,"Roman29@mail.ru"),
                        new User(3,"Ivan",35,"ivan@mail.ru")
                );
    }

    @Test
    public void searchUserByEmailTest() throws SQLException {
        User actualData = searchUserByName(connection,"Ivan");
        User expectedData = new User(3,"Ivan",35,"ivan@mail.ru");

        Assertions.assertEquals(expectedData, actualData);
    }

    @Test
    public void addUserTest() throws SQLException {
        addUser(connection,"Konstantin 41 Konstantin@hotmail.ru");

        org.assertj.core.api.Assertions.assertThat(getUsersInfo(connection))
                .contains(searchUserByName(connection,"Konstantin"));
    }

    @Test
    public void deleteUserByNameTest() throws SQLException {
        deleteUserByName(connection,"Konstantin");
        Assertions.assertNull(searchUserByName(connection,"Konstantin"));
    }

    @AfterAll
    public static void closeDBConnection() throws SQLException {
        connection.close();
    }
}
