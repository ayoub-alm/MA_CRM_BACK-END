package com.sales_scout.repository.crm;

import com.sales_scout.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     *
     * @param prospectId
     * @return
     */
    Optional<Customer> findByProspectIdAndDeletedAtIsNull(Long prospectId);
}
