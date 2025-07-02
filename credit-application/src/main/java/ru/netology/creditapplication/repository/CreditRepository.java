package ru.netology.creditapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.CreditStatus;
import ru.netology.creditapplication.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    @Modifying
    @Query("update Credit c set c.status = :status where c.id = :id")
    void updateCreditDecision(@Param("id") Long id, @Param("status") CreditStatus status);
}
