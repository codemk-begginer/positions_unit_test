package tech.chilo.positions_test_unitaires.customers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomersDAO {
    private final static String FIND_ALL ="SELECT * FROM customers";

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<CustomersDTO> costumerRowMapper =
            ((rs, name) -> new CustomersDTO(rs.getInt("id"),
                    rs.getString("email")) );


    public CustomersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<CustomersDTO> search(){
        return this.jdbcTemplate.query(FIND_ALL,costumerRowMapper);
    }
}
