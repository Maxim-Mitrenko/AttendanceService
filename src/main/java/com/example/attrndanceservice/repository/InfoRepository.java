package com.example.attrndanceservice.repository;

import com.example.attrndanceservice.model.Info;
import com.example.attrndanceservice.model.InfoID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, InfoID> {

    List<Info> findAllByInfoIDUserID(Long userID);

    List<Info> findAllByClassName(String className);
}
