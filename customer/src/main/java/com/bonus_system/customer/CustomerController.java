package com.bonus_system.customer;

import com.bonus_system.customer.forms.SetCustomer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
@Tag(name = "Клиент", description = "Контроллер для клиента")
public class CustomerController {
    JdbcTemplate jdbcTemplate;

    @GetMapping("/idCustomer/{idCustomer}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Id Customer",
            description = "Позволяет получить  клиента по его id"
    )
    public String GetCustomerByID(
            @PathVariable("idCustomer") Integer idCustomer
    ) {
        jdbcTemplate.queryForList("select * from customer_bonus_system.public.customer where idclient=?", idCustomer);
        return jdbcTemplate.queryForList("select * from customer_bonus_system.public.customer where idclient=?", idCustomer).toString();
    }

    @GetMapping("/idCard/{idCard}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Id Card",
            description = "Получение  клиента по ID Card"
    )
    public String GetByCardID(
            @PathVariable("idCard") Integer idCard
    ) {
        return jdbcTemplate.queryForList("select * from customer_bonus_system.public.customer where card_id=?", idCard).toString();
    }

    @PostMapping("/createCustomer")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Регистрация клиента",
            description = "Позволяет зарегистрировать клиента"
    )
    public String SetCustomer(
            @RequestBody @Parameter(description = "Запрос должен содержать это тело") SetCustomer setCustomer
    ) {
        jdbcTemplate.update(
                "insert into " +
                        "customer_bonus_system.public.customer(" +
                        "nickname, card_id) " +
                        "VALUES (?, ?)",
                setCustomer.getNickName(),
                setCustomer.getCardId()
        );
        return "Success create customer";
    }
}