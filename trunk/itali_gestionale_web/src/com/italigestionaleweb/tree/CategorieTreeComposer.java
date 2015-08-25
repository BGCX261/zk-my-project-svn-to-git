package com.italigestionaleweb.tree;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Tree;

public class CategorieTreeComposer extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6115172328857799857L;

	private Tree tree;
	
	private AdvancedTreeModel categoriaTreeModel;
	
	@AfterCompose
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		System.out.println("CategorieTreeComposer RICHIAMATA");
//		categoriaTreeModel = new AdvancedTreeModel(categoriaTreeNode)
	}
	
}

