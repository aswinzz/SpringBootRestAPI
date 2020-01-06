package com.sample.sample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Slf4j
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Document
public class User {

    @Id
    private String userId;
    private String name;
    private String email;
}
