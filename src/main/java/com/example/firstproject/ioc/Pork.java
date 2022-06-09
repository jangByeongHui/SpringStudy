package com.example.firstproject.ioc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pork extends Ingredient{

    public Pork(String name) {
        super(name);
    }
}
