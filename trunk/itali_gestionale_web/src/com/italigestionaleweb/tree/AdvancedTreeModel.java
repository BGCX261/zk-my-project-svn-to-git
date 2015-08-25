package com.italigestionaleweb.tree;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;

import com.italigestionale.bean.Categoria;

public class AdvancedTreeModel extends DefaultTreeModel<Categoria>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4643536167425522181L;
	
	DefaultTreeNode<Categoria> _root;
	
	public AdvancedTreeModel(CategoriaTreeNode categoriaTreeNode) {
		super(categoriaTreeNode);
		_root = categoriaTreeNode;
	}

	public void remove(){}

	
	public void remove2(){}
	
	public void insert(DefaultTreeNode<Categoria> parent, int indexFrom, int indexTo, DefaultTreeNode<Categoria>[] newNodes){
		
		DefaultTreeNode<Categoria> stn = parent;
		for (int i = indexFrom; i <= indexTo; i++){
			try {
				stn.getChildren().add(i, newNodes[i - indexFrom]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void add(DefaultTreeNode<Categoria> parent, DefaultTreeNode<Categoria>[] newNodes){
		
		DefaultTreeNode<Categoria> stn = (DefaultTreeNode<Categoria>) parent;
		for(int i = 0; i < newNodes.length; i++){
			stn.getChildren().add(newNodes[i]);
		}
		
		
	}

}
