package com.sample.sample.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
}
