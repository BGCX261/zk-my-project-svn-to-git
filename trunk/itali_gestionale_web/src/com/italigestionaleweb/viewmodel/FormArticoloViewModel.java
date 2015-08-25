package com.italigestionaleweb.viewmodel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class FormArticoloViewModel {
	
	
	@Wire("#winNuovoArticolo")
	private Window winNuovoArticolo;
	
	private List<String> listFornitori;
	
//	@Wire("#pics")
//	private Vlayout pics;
	
	private AImage myImage;
	
	private Articolo articolo = new Articolo();
	
	@Init
	public void init(){
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		List<Fornitore> listaFornitoriDB = businessInterface.getAllFornitori();
		listFornitori = new ArrayList<>();
		for (Fornitore fornitore : listaFornitoriDB) {
			listFornitori.add(fornitore.getRagione_sociale());
		}
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		
		String contextPath = Executions.getCurrent().getDesktop().getWebApp().getServletContext().getContextPath();
		String realPathOfImgFolder = Executions.getCurrent().getDesktop().getWebApp().getServletContext().getRealPath("/images");
		System.out.println("contextPath "+contextPath);
		System.out.println("realPathOfImgFolder "+realPathOfImgFolder);
		
		try {
			Thumbnails.of(new File(realPathOfImgFolder+"/articoli/large_701.jpg")).size(150,225).toFile(new File(realPathOfImgFolder+"/articoli/thumb_large_701.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Selectors.wireComponents(view, this, false);		
	}
	
	@Command
	public void submit(){
		
//		System.out.println("getFirstChild "+pics.getFirstChild());
//		System.out.println("getLastChild "+pics.getLastChild());
		
//		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
//		businessInterface.insertArticolo(this.articolo);
//		BindUtils.postGlobalCommand(null, null, FornitoriController.class, "fornitori");
		
		BufferedImage image = null;
		
		try {
			
			String realPathOfImgFolder = Executions.getCurrent().getDesktop().getWebApp().getServletContext().getRealPath("/images");
			
			image = ImageIO.read(this.myImage.getStreamData());
			ImageIO.write(image, "jpg", new File(realPathOfImgFolder+"/articoli/"+this.myImage.getName()+".jpg"));
			Thumbnails.of(new File(realPathOfImgFolder+"/articoli/"+this.myImage.getName()+".jpg")).size(150,225).toFile(new File(realPathOfImgFolder+"/articoli/thumb_"+this.myImage.getName()+".jpg"));
		
			System.out.println("realPathOfImgFolder "+realPathOfImgFolder);
			
			this.articolo.setUrl_thumb(realPathOfImgFolder+"/articoli/"+this.myImage.getName()+".jpg");
			this.articolo.setUrl_thumb_max(realPathOfImgFolder+"/articoli/thumb_"+this.myImage.getName()+".jpg");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		businessInterface.insertArticolo(this.articolo);
		winNuovoArticolo.detach();
		
	}
	
//	@Command
//	public void uploadFileImg(@BindingParam("media") Media myMedia){
//		
//		File myFile = new File(myMedia.getName());
//		Image image = new Image();
//		image.setContent((org.zkoss.image.Image)myMedia);
//		
//		if(pics.getFirstChild() != null){
//			pics.getFirstChild().detach();
//			image.setParent(pics);
//		}else{
//			image.setParent(pics);
//		}
//	
//		System.out.println("path "+myFile.getAbsolutePath());
//		System.out.println("RICHIAMATO uploadFileImg");
//	}
	
	@Command("upload")
	@NotifyChange("myImage")
	public void onImageUpload(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx){
		
		UploadEvent upEvent = null;
		Object objUploadEvent  = ctx.getTriggerEvent();
		upEvent = (UploadEvent)objUploadEvent;
		
		Media media = upEvent.getMedia();
		myImage = (AImage) media;
		System.out.println("RICHIAMATOOOO");
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public AImage getMyImage() {
		return myImage;
	}

	public void setMyImage(AImage myImage) {
		this.myImage = myImage;
	}

	public List<String> getListFornitori() {
		return listFornitori;
	}
	
	

}
