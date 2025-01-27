package com.sales_scout.repository.leads;

import com.sales_scout.entity.leads.Prospect;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProspectRepository extends JpaRepository<Prospect, Long> {
    /**
     * get prospects where deleted at is null
     * @return {List<Prospect>}
     */
    List<Prospect> findAllByDeletedAtIsNullAndCompanyIdIn(List<Long> companyIds);
    /**
     * Get non-Soft-deleted prospect by ID
     * @return {Optional<Prospect>}
     * @param id {Long}
     */
    Optional<Prospect> findByDeletedAtIsNullAndId(Long id);

    /**
     * Get Soft-deleted prospect by ID
     * @param id
     * @return
     */
    Optional<Prospect> findByDeletedAtIsNotNullAndId(Long id);

    /**
     * This function allows to get count of prospects per status
     * @param startDate Filter start date
     * @param endDate Filter end date
     * @return {List<Object[]> } return array of prospects count by status
     */
    @Query("SELECT  p.status, COUNT(p.id) " +
            "FROM Prospect p " +
            "WHERE (:startDate IS NULL OR p.createdAt >= :startDate) " +
            "AND (:endDate IS NULL OR p.createdAt <= :endDate) " +
            "GROUP BY p.status")
    List<Object[]> getCountOfProspectsByStatusBetweenOptionalDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    Collection<Prospect> findByDeletedAtIsNull();
}
