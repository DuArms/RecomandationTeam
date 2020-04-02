package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {

    Contact findContactById(UUID id);
}
