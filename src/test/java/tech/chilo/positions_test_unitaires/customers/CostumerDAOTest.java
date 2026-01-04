package tech.chilo.positions_test_unitaires.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CostumerDAOTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    CustomersDAO customersDAO;
    @Test
    void shouldReturnListOfCustomers() {
        //Arrange / Given
        customersDAO = new CustomersDAO(jdbcTemplate);
        //Act / When
        List<CustomersDTO> customersList = this.customersDAO.search();

        //Assert /then
        Assertions.assertEquals(6,customersList.size());


    }
}