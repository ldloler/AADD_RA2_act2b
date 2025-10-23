package accessadades.ra2.ac2.accessadades_ra2_ac2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import accessadades.ra2.ac2.accessadades_ra2_ac2.model.User;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setDescription(rs.getString("description"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setUltimAccess(rs.getTimestamp("ultimAcces"));
            user.setDataCreated(rs.getTimestamp("dataCreated"));
            user.setDataUpdated(rs.getTimestamp("dataUpdated"));

            return user;
        }

    }

    /*
     * Metodes
     */

    // Find All Users.
    public List<User> findAll() {
        String sql = "Select * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // Get 1 user from id
    public List<User> findOne(int id) {
        String sql = "Select * FROM users where id = '" + id + "'";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // Insert 1 User
    public int save(User user) {
        String sql = "INSERT INTO db_ecomerce.users\n" + //
                        "(name, description, email, password, ultimAcces, dataCreated, dataUpdated)\n" + //
                        "VALUES(?, ?, ?, ?, ?, ?, ?);";
        int numReg = jdbcTemplate.update(sql, user.getName(), user.getDescription(),
                                         user.getEmail(), user.getPassword(), user.getUltimAccess(), 
                                         user.getDataCreated(), user.getDataUpdated());
        return numReg;
    }
}
