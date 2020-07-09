package com.lugan.entity;

import lombok.*;
import lombok.experimental.Accessors;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Book {
    private @Setter @Getter Integer id;
    private Double price;
    private String bookName;
    private String author;
}




