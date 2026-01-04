package tech.chilo.positions_test_unitaires.customers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CostumerController.class)
class CostumerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CostumerService costumerService;

    @DisplayName("[Controller] Test liste des utilisateurs")
    @Test
    void shouldReturnListOfCustomers() throws Exception {
        //Arrange
        CustomersDTO customerOne = new  CustomersDTO( 1,"metenousteve@gmail.com");
        CustomersDTO customerTwo = new  CustomersDTO( 2,"stevemetenou8@gmail.com");
        when(this.costumerService.search()).thenReturn(List.of(customerOne,customerTwo));

        //Act & Assert
        this.mockMvc.perform(get("/costumer"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("metenousteve@gmail")));
    }

    @DisplayName("[Controller] Test lecture d'un utilisateur") //libelle du test
    @Test
    void shouldReturnOneCustomer() throws Exception {
        CustomersDTO customerOne = new  CustomersDTO( 1,"metenousteve@gmail.com");
        when(this.costumerService.read(anyInt())).thenReturn(customerOne);

        this.mockMvc
                .perform(get("/costumer/1"))
                .andExpect(jsonPath("$.email").value(customerOne.email()))
                .andExpect(status().isOk())
                .andDo(print());
    }

}