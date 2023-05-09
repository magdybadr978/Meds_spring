package com.meds.repository;

import com.meds.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {


    public boolean existsRequestById(long id);


    public Request findById(long requestId) ;

}
