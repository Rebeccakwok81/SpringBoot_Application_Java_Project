package org.ac.cst8277.kwok_szeman.db1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long roleID;
    @Column
    private String role;


    public Long getUserRoleID() {
        return roleID;
    }

    public void setUserRoleID(Long userRoleID) {
        this.roleID = userRoleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
