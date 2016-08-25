package com.scottbal.services;

import com.scottbal.entities.Candidate;
import com.scottbal.repositories.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private ICandidateRepository repository;
    
    @Autowired
    public void setRepository(ICandidateRepository repository) {this.repository = repository;}

    public Page<Candidate> findAll(int page) {
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

    public Candidate findOne(int id) {
        return this.repository.findOne(id);
    }

    public Candidate create(Candidate c){
        return this.repository.save(c);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

//    public Candidate update(int id, Candidate c) {
//        Candidate candidate = this.repository.findOne(id);
//        Candidate.setName(c.getName());
//        Candidate.setPosition(c.getPosition());
//        Candidate.setParty(c.getParty());
//        Candidate.setState(c.getState());
//        return this.repository.save(candidate);
//    }

}
