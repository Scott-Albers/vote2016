package com.scottbal.controllers;

import com.scottbal.entities.Voter;
import com.scottbal.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/voters")

public class VoterController {
    private VoterService service;
    
    @Autowired
    public void setService(VoterService service) {this.service = service;}

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Voter> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

//    @RequestMapping(path = {"/{id}/movies"}, method = RequestMethod.GET)
//    public Page<Voter> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
//        return this.service.findAllMoviesByActorId(id, page);
//    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Voter show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path= {"", "/"}, method = RequestMethod.POST)
    public Voter create(@RequestBody Voter  Voter){
        return this.service.create(Voter);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Voter update(@PathVariable int id, @RequestBody Voter Voter) {
        return this.service.update(id, Voter);
    }

    @RequestMapping(path = {"/postion/{position}"}, method = RequestMethod.GET)
    public List<Votes> findByPostion(@PathVariable Position postion) {
        return this.service.findByPosition(postion);
    }

}
