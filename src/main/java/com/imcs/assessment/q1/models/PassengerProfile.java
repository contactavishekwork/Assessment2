/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q1.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "passenger_profile", catalog = "employeewebapp", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"profile_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassengerProfile.findAll", query = "SELECT p FROM PassengerProfile p")
    , @NamedQuery(name = "PassengerProfile.findByProfileId", query = "SELECT p FROM PassengerProfile p WHERE p.profileId = :profileId")
    , @NamedQuery(name = "PassengerProfile.findByPassword", query = "SELECT p FROM PassengerProfile p WHERE p.password = :password")
    , @NamedQuery(name = "PassengerProfile.findByFirstName", query = "SELECT p FROM PassengerProfile p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "PassengerProfile.findByLastName", query = "SELECT p FROM PassengerProfile p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "PassengerProfile.findByAddress", query = "SELECT p FROM PassengerProfile p WHERE p.address = :address")
    , @NamedQuery(name = "PassengerProfile.findByTelNo", query = "SELECT p FROM PassengerProfile p WHERE p.telNo = :telNo")
    , @NamedQuery(name = "PassengerProfile.findByEmailId", query = "SELECT p FROM PassengerProfile p WHERE p.emailId = :emailId")})
public class PassengerProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profile_id", nullable = false)
    private Integer profileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel_no", nullable = false)
    private int telNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_id", nullable = false, length = 45)
    private String emailId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passengerProfile")
    private CreditCardDetails creditCardDetails;

    public PassengerProfile() {
    }

    public PassengerProfile(Integer profileId) {
        this.profileId = profileId;
    }

    public PassengerProfile(Integer profileId, String password, String firstName, String lastName, String address, int telNo, String emailId) {
        this.profileId = profileId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telNo = telNo;
        this.emailId = emailId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
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
        if (!(object instanceof PassengerProfile)) {
            return false;
        }
        PassengerProfile other = (PassengerProfile) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.imcs.assessment.q1.models.PassengerProfile[ profileId=" + profileId + " ]";
    }
    
}
