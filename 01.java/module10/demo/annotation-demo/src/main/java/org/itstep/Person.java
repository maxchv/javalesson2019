package org.itstep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String info;

}
