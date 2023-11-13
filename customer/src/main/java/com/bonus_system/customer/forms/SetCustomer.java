package com.bonus_system.customer.forms;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

@Data
//@Hidden
public class SetCustomer {
    public String nickName;
    public Integer cardId;
}