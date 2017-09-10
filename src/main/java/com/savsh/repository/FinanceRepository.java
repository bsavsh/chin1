package com.savsh.repository;

import com.savsh.entity.Finance;
import org.springframework.data.repository.CrudRepository;

public interface FinanceRepository extends CrudRepository<Finance, Long> {
}
