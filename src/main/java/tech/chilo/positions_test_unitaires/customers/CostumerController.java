package tech.chilo.positions_test_unitaires.customers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "costumer")
@AllArgsConstructor
public class CostumerController {

    private final CostumerService costumerService;

    @GetMapping
    public List<CustomersDTO> search(){
        return this.costumerService.search();
    }
    @GetMapping(path = "{id}")
    public CustomersDTO read(@PathVariable int id){
        return this.costumerService.read(id);
    }

}
