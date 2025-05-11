package com.agrocontrol.msvc_finance.finances.infrastructure.persistence.jpa.repositories;

import com.agrocontrol.msvc_finance.finances.domain.model.aggregates.Finance;
import com.agrocontrol.msvc_finance.finances.domain.model.valueobjects.AgriculturalProcessId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> findAllByAgriculturalProcessId(AgriculturalProcessId userId);
}
