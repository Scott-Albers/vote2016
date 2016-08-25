package com.scottbal.repositories;


import com.scottbal.entities.Voter;
import com.scottbal.entities.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IVoterRepository extends PagingAndSortingRepository<Voter, Integer> {

    public List<Voter> findByPosition(Position postion);
}
