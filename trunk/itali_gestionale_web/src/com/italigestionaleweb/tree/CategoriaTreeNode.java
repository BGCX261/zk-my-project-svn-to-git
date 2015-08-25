package com.italigestionaleweb.tree;

import org.zkoss.zul.DefaultTreeNode;

import com.italigestionale.bean.Categoria;

public class CategoriaTreeNode extends DefaultTreeNode<Categoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2816686386369066882L;
	
	private boolean open = false;
	
	public CategoriaTreeNode(Categoria data, DefaultTreeNode<Categoria>[] children){
		super(data, children);
	}
	
	public CategoriaTreeNode(Categoria data, DefaultTreeNode<Categoria>[] children, boolean open){
		super(data, children);
		setOpen(open);
	}

	public CategoriaTreeNode(Categoria data){
		super(data);
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}
