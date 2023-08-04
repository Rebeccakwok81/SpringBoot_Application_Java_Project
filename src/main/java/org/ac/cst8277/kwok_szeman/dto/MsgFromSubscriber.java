package org.ac.cst8277.kwok_szeman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MsgFromSubscriber {

    private int SubscriberID;
    private int UserID;
    private String content;
    private Timestamp timestamp;

    public int getSubscriberID() {
        return SubscriberID;
    }

    public void setSubscriberID(int subscriberID) {

        this.SubscriberID = subscriberID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
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
