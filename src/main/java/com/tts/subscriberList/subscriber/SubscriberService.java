package com.tts.subscriberList.subscriber;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubscriberService {

    @Autowired
    SubscriberRepository repo;

    public List<Subscriber> listAll(){
        return (List<Subscriber>) repo.findAll();
    }

    public List<Subscriber> searchByKeyword(String keyword){
        return repo.search(keyword);
    }

    public void save(Subscriber subscriber){
        repo.save(subscriber);
    }

    public Subscriber get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}
