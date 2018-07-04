package ua.com.firstTask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.firstTask.entety.User;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final String USER_ID = "user_id";
    static final String FIRST_NAME = "first_name";
    static final String LAST_NAME = "last_name";
    private static final String ROLE_NAME = "name";

    @Autowired
    public UserDaoImpl(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAll() {
        String query = "select * from users";
        return jdbcTemplate.query(query, (resultSet, i) -> new User.Builder().
                setUserId(resultSet.getInt(USER_ID)).
                setFirstName(resultSet.getString(FIRST_NAME)).
                setLastName(resultSet.getString(LAST_NAME)).getInstance());
    }

    @Override
    public User getByID(long id) {
        String query = "SELECT * FROM Users WHERE idUsers = id";
        return jdbcTemplate.query(query, (ResultSetExtractor<User>) result -> new User.Builder().
                setUserId(result.getInt(USER_ID)).
                setFirstName(result.getString(FIRST_NAME)).
                setLastName(result.getString(LAST_NAME)).getInstance());
    }

    @Override
    public int save(User user) {
        String query = "UPDATE Users " +
                "first_name = :first_name, " +
                "last_name = :last_name, " +
                "WHERE idUsers = :user_id";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(FIRST_NAME, user.getFirstName());
        parameters.addValue(LAST_NAME, user.getLastName());;
        parameters.addValue(ROLE_NAME, user.getRole().name());
        parameters.addValue(USER_ID, user.getUserId());

        return jdbcTemplate.update(query, parameters);
    }

    @Override
    public void remove(long id) {
        String query = "DELETE USER FROM Users WHERE idUsers = id";

//        jdbcTemplate.query();
    }
}
