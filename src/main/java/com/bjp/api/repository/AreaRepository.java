package com.bjp.api.repository;

import com.bjp.api.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AreaRepository extends JpaRepository<Area,String> {
    Optional<Area> findByAreaName(final String eventName);
}
