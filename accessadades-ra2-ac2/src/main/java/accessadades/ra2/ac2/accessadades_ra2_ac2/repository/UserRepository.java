package accessadades.ra2.ac2.accessadades_ra2_ac2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import accessadades.ra2.ac2.accessadades_ra2_ac2.model.User;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(User user) {
        // INSERT INTO Customers values (id, name, age);
        String sql = "INSERT INTO db_ecomerce.users\n" + //
                        "(name, description, email, password, ultimAcces, dataCreated, dataUpdated)\n" + //
                        "VALUES(?, ?, ?, ?, ?, ?, ?);";
        int numReg = jdbcTemplate.update(sql, user.getName(), user.getDescription(),
                                         user.getEmail(), user.getPassword(), user.getUltimAccess(), 
                                         user.getDataCreated(), user.getDataUpdated());
        return numReg;
    }
}
