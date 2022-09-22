package com.bjp.api.repository;

import com.bjp.api.models.Wing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WingRepository extends JpaRepository<Wing,String> {
}
