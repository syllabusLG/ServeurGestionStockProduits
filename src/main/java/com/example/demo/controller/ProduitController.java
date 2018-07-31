package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produit;
import com.example.demo.entity.User;

@RestController
@RequestMapping(value="/api/produit")
public class ProduitController extends CrudController<Produit, Long>{

}
