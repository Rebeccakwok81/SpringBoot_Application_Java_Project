package org.ac.cst8277.kwok_szeman.db2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {

    @Id
    private Long MessageID;
    @JoinColumn(name = "userID")
    private int UserID;
    @Column(name="Content")
    private String content;
    @Column(name="Timestamp")
    private Timestamp timestamp;

    public Long getMessageID() {
        return MessageID;
    }

    public void setMessageID(Long messageID) {
        MessageID = messageID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }




}
