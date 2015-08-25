package com.italigestionaleweb.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.jasper.xmlparser.TreeNode;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeModel;

import com.italigestionale.bean.Categoria;
import com.italigestionale.bean.SottoCategoria;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class TreeCategorieViewModel {

	private DefaultTreeModel treeModel;
	private DefaultTreeNode<Categoria> selectedNode;
	private String categoria;
	private String update;
	
	
//	public TreeModel<DefaultTreeModel<String>> getTreeModel() {
//		
//		DefaultTreeNode root = new DefaultTreeNode(null, new DefaultTreeNode[]{new DefaultTreeNode("aaa", (Collection)null)});
//			
//		if(treeModel == null){
//			treeModel = new DefaultTreeModel<String>(root);
//		}
//		return treeModel;
//	}
	
	
	public TreeModel<DefaultTreeNode<Categoria>> getTreeModel() {
		
		List<DefaultTreeNode<Categoria>> treeNodeCollection = new ArrayList<>();
		
		//DB
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		List<Categoria> listaCategorie = businessInterface.getAllCategorie();
		
		
		
		
		
		for (Categoria categoria : listaCategorie) {
			
//			DefaultTreeNode<Categoria> treeNodeCategoria = new DefaultTreeNode<Categoria>(categoria,(List)null);
//			treeNodeCollection.add(treeNodeCategoria);
			
			if(categoria.getSottoCategorie().size()>0){
				List<DefaultTreeNode<Categoria>> listTreeNodeSottoCategorie = new ArrayList<>();
				for (SottoCategoria sottoCategorie : categoria.getSottoCategorie()) {
					Categoria cat = new Categoria();
					cat.setId_categoria(sottoCategorie.getId_sottocategoria());
					cat.setNome(sottoCategorie.getNome());
					listTreeNodeSottoCategorie.add(new DefaultTreeNode<Categoria>(cat,(List)null));
				}
				DefaultTreeNode<Categoria> treeNodeCategoria = new DefaultTreeNode<Categoria>(categoria,listTreeNodeSottoCategorie);
				treeNodeCollection.add(treeNodeCategoria);
			}else{
				DefaultTreeNode<Categoria> treeNodeCategoria = new DefaultTreeNode<Categoria>(categoria,(List)null);
				treeNodeCollection.add(treeNodeCategoria);
			}
			
			
//			if(categoria.getSottoCategorie().size()>0){
//				List<DefaultTreeNode<Categoria>> listTreeNode = new ArrayList<>();
//				for (SottoCategoria sottoCat : categoria.getSottoCategorie()) {
//					listTreeNode.add(new DefaultTreeNode(sottoCat.getNome()));
//				}
//				DefaultTreeNode<Categoria> treeNode = new DefaultTreeNode(categoria,listTreeNode);
//				treeNodeCollection.add(treeNode);
//			}else{
//				DefaultTreeNode<Categoria> treeNode = new DefaultTreeNode<Categoria>(categoria,(List)null);
//				treeNodeCollection.add(treeNode);
//			}
			
			
		}
		
		//DB end
		
		if(treeNodeCollection.size()==0){
			DefaultTreeNode<Categoria> treeNodeCategoria = new DefaultTreeNode<Categoria>(new Categoria(),(List)null);
			treeNodeCollection.add(treeNodeCategoria);
		}
				
		DefaultTreeNode<Categoria> treeNodeRoot = new DefaultTreeNode(null, treeNodeCollection);
		
		if(treeModel == null){
			treeModel = new DefaultTreeModel<Categoria>(treeNodeRoot);
		}
		
		return treeModel;
		
	}
	
	
	public String getSelectedNodePath(){
		StringBuilder sb = new StringBuilder("");
		if(selectedNode != null){
			List<DefaultTreeNode> nodes = new ArrayList<DefaultTreeNode>();
			DefaultTreeNode node = selectedNode;
			while (node.getParent() != null) {
				nodes.add(0, node);
				node = (DefaultTreeNode)node.getParent();
			}
			for (int i = 0; i < nodes.size(); i++) {
				if(i > 0){
					sb.append(" - ");
				}
				sb.append(nodes.get(i).getData());
			}
		}
		return sb.toString();
	}
	
	@Command
	public void keepSelectedNode(@ContextParam(ContextType.TRIGGER_EVENT) SelectEvent event){
		selectedNode = ((Tree)event.getTarget()).getSelectedItem().getValue();
	}
	
	public void addNode(boolean asChild){
		if(categoria != null  && !categoria.isEmpty() && selectedNode != null){
			DefaultTreeNode parent = asChild? selectedNode : (DefaultTreeNode)selectedNode.getParent();
			List children = parent.getChildren();
			BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
			if(asChild){
				Categoria cat = new Categoria();
				Categoria catSelect = (Categoria)parent.getData();
				cat.setId_categoria(catSelect.getId_categoria());
				cat.setNome(catSelect.getNome());
				SottoCategoria scat= new SottoCategoria();
				scat.setNome(categoria);
				parent.add(new DefaultTreeNode(scat, (List)null));
//				cat.setNome_categoria_madre(parent.getData().toString());
				businessInterface.insertSottoCategoria(scat, cat);
			}else{
				Categoria cat = new Categoria();
				cat.setNome(categoria);
				businessInterface.insertCategoria(cat);
				children.add(children.indexOf(selectedNode)+1, new DefaultTreeNode(cat, (List)null));
			}
			
		}
	}
	
	
	@Command
	@NotifyChange("model")
	public void nuovaCategoriaBtn(){
		System.out.println("nuovaCategoriaBtn");
		addNode(false);
	}
	
	@Command
	public void nuovaSottocategoriaBtn(){
		System.out.println("nuovaSottocategoriaBtn");
		addNode(true);
	}
	
	@Command
	public void eliminaCategoriaBtn(){
		System.out.println("eliminaCategoriaBtn");
		if (selectedNode != null) {
			selectedNode.getParent().remove(selectedNode);
			selectedNode = null;
		}
	}
	
//	@Command
//	public void aggiornaBtn(){
//		System.out.println("aggiornaBtn");
//		if(update != null && selectedNode != null){
//			selectedNode.setData(update);
//		}
//	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
	
	
}
