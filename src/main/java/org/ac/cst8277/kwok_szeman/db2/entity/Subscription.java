package org.ac.cst8277.kwok_szeman.db2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subscription")
public class Subscription {
    @Id
    private Long SubscriptionID;
    @JoinColumn(name="UserID")
    @Column(name="SubscriberID")
    private int SubscriberID;
    @JoinColumn(name="UserID")
    @Column(name="ProducerID")
    private int ProducerID;

    public Long getSubscriptionID() {
        return SubscriptionID;
    }

    public void setSubscriptionID(Long subscriptionID) {
        SubscriptionID = subscriptionID;
    }

    public int getSubscriberID() {
        return SubscriberID;
    }

    public void setSubscriberID(int subscriberID) {
        SubscriberID = subscriberID;
    }

    public int getProducerID() {
        return ProducerID;
    }

    public void setProducerID(int producerID) {
        ProducerID = producerID;
    }

}
