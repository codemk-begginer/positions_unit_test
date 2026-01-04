package tech.chilo.positions_test_unitaires.kpi;

import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import tech.chilo.positions_test_unitaires.customers.CostumerService;

@AllArgsConstructor
@Component
@Endpoint(id = "customers")
public class CustomerKpi {

    CostumerService costumerService;
    @ReadOperation
    public int count(){

        return this.costumerService.search().size();

    }
}
