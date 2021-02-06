package com.tts.subscriberList.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubscriberController {

//    @Autowired
//    private SubscriberRepository subscriberRepository;

    @Autowired
    private SubscriberService service;

    @GetMapping(value="/")
    public String index (Subscriber subscriber){
        // Where we want to go when our application is started.
        return "subscriber/index";
    }
    @PostMapping(value="/")
    public String addNewSubscriber(Subscriber subscriber, Model model){
        service.save(new Subscriber(subscriber.getFirstName(),subscriber.getLastName(),
                subscriber.getUserName(), subscriber.getSignedUp()));
        model.addAttribute("firstName", subscriber.getFirstName());
        model.addAttribute("lastName", subscriber.getLastName());
        model.addAttribute("userName", subscriber.getUserName());
        return "subscriber/result";
    }

    @GetMapping(value="/list")
    public String listAllSubscribers(Model model){
        List<Subscriber> listSubscribers = service.listAll();
        model.addAttribute("listSubscribers", listSubscribers);

        return "subscriber/searchResults";
    }
    @GetMapping(value="/q")
    public String searchResults(Model model, @Param("keyword")String keyword){
        List<Subscriber> listSubscribers = service.searchByKeyword(keyword);
        model.addAttribute("listSubscribers", listSubscribers);
        model.addAttribute("keyword", keyword);

        return "subscriber/searchResults";
    }

    @GetMapping(value="/search")
    public String searchPage(){
        return "subscriber/searchEntry";
    }



}
