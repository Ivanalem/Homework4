package com.academy.entity;

import com.academy.enum_personal.Personal_ENUM;
import lombok.Data;

@Data
public class Personal {
    private Integer id;
    private Enum type;
}
