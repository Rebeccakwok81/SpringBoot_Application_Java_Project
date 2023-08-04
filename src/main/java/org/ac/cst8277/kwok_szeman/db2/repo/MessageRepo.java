package org.ac.cst8277.kwok_szeman.db2.repo;

import org.ac.cst8277.kwok_szeman.db2.entity.Message;
import org.ac.cst8277.kwok_szeman.dto.AllRoles;
import org.ac.cst8277.kwok_szeman.dto.MsgFromSubscriber;
import org.ac.cst8277.kwok_szeman.dto.MsgFromUser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan("org.ac.cst8277.kwok_szeman.db1.Subscription")
public interface MessageRepo extends JpaRepository<Message, Long> {

    @Query("select new org.ac.cst8277.kwok_szeman.dto.MsgFromUser(m.UserID, m.content, m.timestamp) from Message m WHERE m.UserID = 4")
    public List<MsgFromUser> getMsgFromProducer();

    @Query("SELECT new org.ac.cst8277.kwok_szeman.dto.MsgFromSubscriber(s.SubscriberID,m.UserID, m.content, m.timestamp) FROM Message m JOIN Subscription s ON m.UserID = s.ProducerID WHERE s.SubscriberID = 1")
    public List<MsgFromSubscriber> getSubscriber();

}
