package com.sales_scout.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
        private String name;
        private String email;
        private String password;
        private String aboutMe;
}
