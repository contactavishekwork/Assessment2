/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q1.dao;

import com.imcs.assessment.q1.models.PassengerProfile;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Avishek
 */
@Entity
@NamedQuery(name = "PASSENGER_PROFILE", query = "from PASSENGER_PROFILE prof where prof.profile_id=?")
public interface PassengerDao extends CrudRepository<PassengerProfile, Integer>{
    public PassengerProfile getPassengerProfileById(int profileId);
    public boolean createPassengerProfile(PassengerProfile profile);
    public boolean updatePassengerProfileById(PassengerProfile profile);
    public boolean deletePassengerProfileById(int profileId);
}
