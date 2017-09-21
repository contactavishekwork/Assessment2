/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q1.dao;

import com.imcs.assessment.q1.models.CreditCardDetails;
import javax.persistence.NamedQuery;
import javax.persistence.Entity;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Avishek
 */
@Entity
@NamedQuery(name = "CREDIT_CARD", query = "from CREDIT_CARD card where card.profile_id=?")
public interface CreditCardDao extends CrudRepository<CreditCardDetails, Integer>{
    public CreditCardDetails getCreditCardById(int profile_id);
    public boolean createCreditCard(CreditCardDetails card);
    public boolean updateCreditCard(CreditCardDetails card);
    public boolean deleteCreditCard(int profile_id);
}
