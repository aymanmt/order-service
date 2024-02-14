package com.alterawi.awscodepipeline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Order {
    private int id;
    private String name;
    private int quantity;
    private double price;
}
