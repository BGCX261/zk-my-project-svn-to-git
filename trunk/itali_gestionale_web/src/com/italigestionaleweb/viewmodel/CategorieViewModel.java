package com.italigestionaleweb.viewmodel;

import org.zkoss.zul.AbstractTreeModel;

public class CategorieViewModel extends AbstractTreeModel<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CategorieViewModel() {
		super("root");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		return 0;
	}

}
