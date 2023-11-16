package com.bonus_system.customer.controllers;

import com.bonus_system.customer.repoCustomer.CustomerTable;
import com.bonus_system.customer.repoCustomer.Repository;
import com.bonus_system.customer.forms.SetCustomer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
@Tag(name = "Клиент", description = "Контроллер для клиента")
public class CustomerController {
    public Repository repository;

    @GetMapping("/idCustomer/{idCustomer}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Id Customer",
            description = "Позволяет получить  клиента по его id"
    )
    public Optional<CustomerTable> GetCustomerByID(
            @PathVariable("idCustomer") Integer idCustomer
    ) {
        return repository.findById(Long.valueOf(idCustomer));
    }

    @GetMapping("/idCard/{idCard}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Id Card",
            description = "Получение  клиента по ID Card"
    )
    public Optional<CustomerTable> GetByCardID(
            @PathVariable("idCard") String idCard
    ) {
        return repository.findByCardId(idCard);
    }

    @PostMapping("/createCustomer")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Регистрация клиента",
            description = "Позволяет зарегистрировать клиента"
    )
    public String SetCustomer (
            @RequestBody @Parameter(description = "Запрос должен содержать это тело") SetCustomer setCustomer
    ) {
        UUID uuid = UUID.randomUUID();
        repository.updateCustomer(setCustomer.getNickName(), String.valueOf(uuid));
        return "Success create customer";
    }
}