package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends JpaRepository<Job, Integer> {
    Job findJobByJid (Integer jid);
}
