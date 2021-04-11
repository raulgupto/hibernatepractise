package com.example.practise.hibernatepractise.service.movie;


import com.example.practise.hibernatepractise.model.movie.actor.Actor;
import com.example.practise.hibernatepractise.repository.movie.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    final
    ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor addActor(Actor actor) {
        Actor save = actorRepository.save(actor);
        return save;
    }
}
