package tech.chilo.positions_test_unitaires.customers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CostumerService {

  CustomersRepository customersRepository;

  public List<CustomersDTO> search(){
      return this.customersRepository.findAll().stream()
           .map(customers -> {
         return new CustomersDTO(customers.getId(),customers.getEmail());
     }).collect(Collectors.toList());
  }

  public CustomersDTO read(int id){
      Customers customers = this.customersRepository
              .findById(id)
              .orElseThrow(()-> new IllegalArgumentException(("no customer for id "+id)));
      return new CustomersDTO(customers.getId(),customers.getEmail());
  }

}
