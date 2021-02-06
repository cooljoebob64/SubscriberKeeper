package com.tts.subscriberList.subscriber;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

    @Query("SELECT s FROM Subscriber s WHERE s.firstName LIKE %?1% OR s.lastName LIKE %?1% OR s.userName LIKE %?1%")
    public List<Subscriber> search(String keyword);
}
