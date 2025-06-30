package ru.netology.creditapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.creditapplication.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
}
