package com.example.demo.po;

import java.util.List;

public class Nav extends Categroy {
    private List<Brand> brands;

    public List<Brand> getBrands(){
        return brands;
    }

    public void setBrands(List<Brand> brands){
        this.brands = brands;
    }
}
