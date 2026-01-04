package tech.chilo.positions_test_unitaires.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomersRepositoryTest {

    @Autowired
    CustomersRepository customersRepository;
@Test
    public void shouldReturnAllCustomersByEmail(){
        //Arrange
        Customers customerOne = Customers.builder().email("metenousteve@gmail.com").build();
        Customers customerTwo = Customers.builder().email("stevemetenou8@gmail.com").build();

        this.customersRepository.saveAll(List.of(customerOne,customerTwo));

        //act

        final Customers customers = this.customersRepository.findByEmail("stevemetenou8@gmail.com");

        //assert
        Assertions.assertEquals(customerTwo.getId(),customers.getId());
        Assertions.assertEquals(customerTwo.getEmail(),customers.getEmail());

    }
}