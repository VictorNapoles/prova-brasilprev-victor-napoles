package br.com.brasilprev.provajavabrasilprev.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}