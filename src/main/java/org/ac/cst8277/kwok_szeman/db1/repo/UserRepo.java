package org.ac.cst8277.kwok_szeman.db1.repo;

import org.ac.cst8277.kwok_szeman.dto.AllRoles;
import org.ac.cst8277.kwok_szeman.db1.entity.User;
import org.ac.cst8277.kwok_szeman.dto.MsgFromSubscriber;
import org.ac.cst8277.kwok_szeman.dto.MsgFromUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    @Query("select new org.ac.cst8277.kwok_szeman.dto.AllRoles(u.username, r.role) from UserRole ur join User u ON ur.UserID = u.userID join Role r ON ur.roleid = r.roleID")
    public List<AllRoles> getAllRoles();


}


