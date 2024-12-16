package com.sales_scout.repository;

import com.sales_scout.entity.data.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    List<PhoneNumber> findByNumber(String number);
}
