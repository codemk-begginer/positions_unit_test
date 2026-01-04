package tech.chilo.positions_test_unitaires.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomersRepository extends JpaRepository<Customers ,Integer> {

    Customers findByEmail(String email);

}
