package com.italigestionaleweb.data;

import java.util.ArrayList;
import java.util.List;

import com.italigestionale.bean.Categoria;
import com.italigestionaleweb.tree.CategoriaTreeNode;

public class CategorieList {
	
	public final static String categoria = "Categoria";
	public final static String sottoCategoria = "Sotto Categoria";
	
	private CategoriaTreeNode root;
	
	public CategorieList(){
		
		List<CategoriaTreeNode> categoriaTree1 = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Categoria cat = new Categoria();
			cat.setNome(Integer.toString(i));
			CategoriaTreeNode prova = new CategoriaTreeNode(cat);
			categoriaTree1.add(prova);
		}
		
//		root = new CategoriaTreeNode(null, new CategoriaTreeNode[]);
	}

	public CategoriaTreeNode getRoot() {
		return root;
	}

	public void setRoot(CategoriaTreeNode root) {
		this.root = root;
	}
	

}
