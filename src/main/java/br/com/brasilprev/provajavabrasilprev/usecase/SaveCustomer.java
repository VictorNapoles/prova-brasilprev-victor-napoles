package br.com.brasilprev.provajavabrasilprev.usecase;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.brasilprev.provajavabrasilprev.domain.customer.Customer;
import br.com.brasilprev.provajavabrasilprev.domain.customer.CustomerRepository;
import br.com.brasilprev.provajavabrasilprev.usecase.dto.CustomerDto;

@Service
public class SaveCustomer {

    private CustomerRepository repository;

    public CustomerDto execute (CustomerDto dto){

        Assert.notNull(dto, "Customer can not be null!");
        Assert.hasText(dto.getName(), "Customer name can not be null or empty!");
        Assert.hasText(dto.getAddress(), "Customer address can not be null or empty!");
        Assert.notNull(dto.getBirthDate(), "Customer birth date can not be null!");

        Customer customer = new Customer();
        BeanUtils.copyProperties(dto, customer);
        customer = repository.save(customer);
        BeanUtils.copyProperties(customer, dto);

        return dto;
    }
    
}