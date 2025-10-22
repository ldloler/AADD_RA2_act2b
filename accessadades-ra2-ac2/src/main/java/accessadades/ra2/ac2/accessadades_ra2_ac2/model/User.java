package accessadades.ra2.ac2.accessadades_ra2_ac2.model;

import java.sql.Timestamp;

public class User {
    
    private Long id;
    private String name;
    private String description;
    private String email;
    private String password;
    private Timestamp ultimAccess;
    private Timestamp dataCreated;
    private Timestamp dataUpdated;

    public User() {}

    public User(Long id, String name, String description, String email, String password, Timestamp ultimAccess,
            Timestamp dataCreated, Timestamp dataUpdated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
        this.password = password;
        this.ultimAccess = ultimAccess;
        this.dataCreated = dataCreated;
        this.dataUpdated = dataUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getUltimAccess() {
        return ultimAccess;
    }

    public void setUltimAccess(Timestamp ultimAccess) {
        this.ultimAccess = ultimAccess;
    }

    public Timestamp getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Timestamp dataCreated) {
        this.dataCreated = dataCreated;
    }

    public Timestamp getDataUpdated() {
        return dataUpdated;
    }

    public void setDataUpdated(Timestamp dataUpdated) {
        this.dataUpdated = dataUpdated;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", description=" + description + ", email=" + email + ", password="
                + password + ", ultimAccess=" + ultimAccess + ", dataCreated=" + dataCreated + ", dataUpdated="
                + dataUpdated + "]";
    }
}
