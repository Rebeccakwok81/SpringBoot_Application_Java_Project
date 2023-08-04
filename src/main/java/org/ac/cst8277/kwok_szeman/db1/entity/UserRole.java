package org.ac.cst8277.kwok_szeman.db1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userrole")
public class UserRole {

    @Id
    @JoinColumn(name = "userID")
    private int UserID;
    @Column(name="roleid")
    private long roleid;
}