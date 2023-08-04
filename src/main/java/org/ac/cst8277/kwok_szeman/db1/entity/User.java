package org.ac.cst8277.kwok_szeman.db1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private long userID;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinColumn(name="roleid", referencedColumnName = "userID")
    @JsonIgnore
    private List<Role> roles;

    @OneToMany(targetEntity = UserRole.class, cascade = CascadeType.ALL)
    @JoinColumn(name="UserID", referencedColumnName = "userID")
    @JsonIgnore
    private List<UserRole> allRoles;


    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

}
