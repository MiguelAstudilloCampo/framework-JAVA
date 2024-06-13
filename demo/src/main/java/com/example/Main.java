package com.example;

import com.example.Models.ProductoDAO;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dbQuery = new ProductoDAO();

        dbQuery.TraerClases();


    }
}
