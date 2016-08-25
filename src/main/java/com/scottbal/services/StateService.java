package com.scottbal.services;

import com.scottbal.entities.State;
import com.scottbal.repositories.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    private IStateRepository repository;

    @Autowired
    public void setRepository(IStateRepository repository) {
        this.repository = repository;
    }

    public Page<State> findAll(int page) {
        PageRequest pr = new PageRequest(page, 2);
        return this.repository.findAll(pr);
    }

//    public Page<Movie> findAllMoviesByActorId(int id, int page) {
//        PageRequest pr = new PageRequest(page, 3);
//        return this.repository.findAllMoviesByActorId(id, pr);
//    }
//
//    public Page<Studio> findAllStudiosByActorId(int id, int page) {
//        PageRequest pr = new PageRequest(page, 3);
//        return this.repository.findAllStudiosByActorId(id, pr);
//    }

    public State findOne(int id) {
        return this.repository.findOne(id);
    }

    public State create(State s){
        return this.repository.save(s);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public State update(int id, State s) {
        State state = this.repository.findOne(id);
        state.setName(s.getName());
        state.setElectVotes(s.getElectVotes());
        return this.repository.save(state);
    }

}
