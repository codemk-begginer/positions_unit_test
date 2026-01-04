package tech.chilo.positions_test_unitaires.customers;

import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CostumerServiceTest {

    @Mock
    CustomersRepository customersRepository;

    @InjectMocks
    CostumerService costumerService;

    @DisplayName("[Service] Test liste des utilisateurs")
    @Test
    void shouldReturnAllCustomers(){

        //Arrange
        Customers customerOne = Customers.builder().email("metenousteve@gmail.com").build();
        Customers customerTwo = Customers.builder().email("stevemetenou8@gmail.com").build();
        when(this.customersRepository.findAll()).thenReturn(List.of(customerOne,customerTwo));



        //act

        final List<CustomersDTO> customersDTOList = this.costumerService.search();

        //assert
        Assertions.assertEquals(2,customersDTOList.size());

    }

    @DisplayName("[Service] Test lecture d'un utilisateur")
 @Test
  public void shouldReturnCustomersById(){

        //Arrange
        Customers customerOne = Customers.builder().id(1).email("metenousteve@gmail.com").build();
        when(this.customersRepository.findById(1)).thenReturn(Optional.of(customerOne));


        //act

        final CustomersDTO customersDTO = this.costumerService.read(1);

        //assert
        Assertions.assertEquals(customerOne.getId(),customersDTO.id());

    }

    @Test
    void ShouldThrowException(){
        //Arrange

        when(this.customersRepository.findById(anyInt())).thenReturn(Optional.empty());

        //Act

        //Assert
       final IllegalArgumentException exception = assertThrows(IllegalArgumentException

                .class,()->this.costumerService.read(1));

         assertEquals("no customer for id 1",exception.getMessage());
    }



}