/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q1.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Avishek
 */
@Entity
@Table(name = "credit_card_details", catalog = "employeewebapp", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"profile_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCardDetails.findAll", query = "SELECT c FROM CreditCardDetails c")
    , @NamedQuery(name = "CreditCardDetails.findByProfileId", query = "SELECT c FROM CreditCardDetails c WHERE c.profileId = :profileId")
    , @NamedQuery(name = "CreditCardDetails.findByCardNumber", query = "SELECT c FROM CreditCardDetails c WHERE c.cardNumber = :cardNumber")
    , @NamedQuery(name = "CreditCardDetails.findByCardType", query = "SELECT c FROM CreditCardDetails c WHERE c.cardType = :cardType")
    , @NamedQuery(name = "CreditCardDetails.findByExpirationMonth", query = "SELECT c FROM CreditCardDetails c WHERE c.expirationMonth = :expirationMonth")
    , @NamedQuery(name = "CreditCardDetails.findByExpirationYear", query = "SELECT c FROM CreditCardDetails c WHERE c.expirationYear = :expirationYear")})
public class CreditCardDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "profile_id", nullable = false)
    private Integer profileId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_number", nullable = false)
    private long cardNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "card_type", nullable = false, length = 45)
    private String cardType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_month", nullable = false)
    private int expirationMonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_year", nullable = false)
    private int expirationYear;
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PassengerProfile passengerProfile;

    public CreditCardDetails() {
    }

    public CreditCardDetails(Integer profileId) {
        this.profileId = profileId;
    }

    public CreditCardDetails(Integer profileId, long cardNumber, String cardType, int expirationMonth, int expirationYear) {
        this.profileId = profileId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public PassengerProfile getPassengerProfile() {
        return passengerProfile;
    }

    public void setPassengerProfile(PassengerProfile passengerProfile) {
        this.passengerProfile = passengerProfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileId != null ? profileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCardDetails)) {
            return false;
        }
        CreditCardDetails other = (CreditCardDetails) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.imcs.assessment.q1.models.CreditCardDetails[ profileId=" + profileId + " ]";
    }
    
}
