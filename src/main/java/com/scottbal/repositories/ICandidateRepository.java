package com.scottbal.repositories;


import com.scottbal.entities.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {

    //    @Query("select m from Movie m join m.actors a where a.id = :id")
//    public Page<Movie> findAllMoviesByActorId(@Param("id") int id, Pageable pageable);
//
//
//    @Query("select distinct s from Movie m join m.studio s join m.actors a where a.id = :id")
//    public Page<Studio> findAllStudiosByActorId(@Param("id") int id, Pageable pageable);

}
