package com.bjp.api.repository;

import com.bjp.api.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer,String> {
}
