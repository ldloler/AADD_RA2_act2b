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
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository ur;

    // Save 1 user from RequestBody param.
    @PostMapping("/users")
    public ResponseEntity<String> postUser(@RequestBody User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setDataCreated(timestamp);
        user.setDataUpdated(timestamp);
        user.setUltimAccess(timestamp);
        
        int saved = ur.save(user);

        String msg = saved + " users have been saved.";

        if (saved == 1) { return new ResponseEntity<String>(msg, HttpStatus.CREATED); }

        return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        String msg = ur.findAll().toString();
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
    
    
}
