package com.scottbal.controllers;

import com.scottbal.entities.State;
import com.scottbal.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/states")
public class StateController {
    private StateService service;

    @Autowired
    public void setService(StateService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<State> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

//    @RequestMapping(path = {"/{id}/movies"}, method = RequestMethod.GET)
//    public Page<State> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
//        return this.service.findAllMoviesByActorId(id, page);
//    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public State show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path= {"", "/"}, method = RequestMethod.POST)
    public State create(@RequestBody State  state){
        return this.service.create(state);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public State update(@PathVariable int id, @RequestBody State state) {
        return this.service.update(id, state);
    }

}
