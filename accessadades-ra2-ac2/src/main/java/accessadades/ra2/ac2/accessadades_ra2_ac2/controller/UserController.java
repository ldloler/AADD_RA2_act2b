package accessadades.ra2.ac2.accessadades_ra2_ac2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accessadades.ra2.ac2.accessadades_ra2_ac2.model.User;
import accessadades.ra2.ac2.accessadades_ra2_ac2.repository.UserRepository;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository ur;

    @PostMapping("/users")
    public ResponseEntity<String> postMethodName(@RequestBody User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setDataCreated(timestamp);
        user.setDataUpdated(timestamp);
        user.setUltimAccess(timestamp);
        
        int saved = ur.save(user);

        String msg = saved + " users have been saved.";

        if (saved == 1) { return new ResponseEntity<String>(msg, HttpStatus.CREATED); }

        return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
    }
    
}
