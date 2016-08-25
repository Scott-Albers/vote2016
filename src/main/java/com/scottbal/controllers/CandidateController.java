package com.scottbal.controllers;

import com.scottbal.entities.Candidate;
import com.scottbal.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService service;
    
    @Autowired
    public void setService(CandidateService service) {this.service = service;}

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Candidate> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

//    @RequestMapping(path = {"/{id}/movies"}, method = RequestMethod.GET)
//    public Page<Candidate> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
//        return this.service.findAllMoviesByActorId(id, page);
//    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Candidate show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path= {"", "/"}, method = RequestMethod.POST)
    public Candidate create(@RequestBody Candidate  Candidate){
        return this.service.create(Candidate);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
//    public Candidate update(@PathVariable int id, @RequestBody Candidate Candidate) {
//        return this.service.update(id, Candidate);
//    }

}
