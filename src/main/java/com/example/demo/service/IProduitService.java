package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Produit;

public interface IProduitService {

	public List<Produit> getProduits();
	public void addProduit(Produit produit);
	public void updateProduit(Produit produit);
	public void deleteProduit(Long id);
}
