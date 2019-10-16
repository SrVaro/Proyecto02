package com.grupo01.lucatinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo01.lucatinder.models.Profile;


public interface ProfileRepository extends JpaRepository<Profile,Integer>{

}
