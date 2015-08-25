package com.am.gestorefile.viewmodel.data_filter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import com.am.gestorefile.model.FileGF;
import com.am.gestorefile.model.ReadWindowFileGFData;

public class FilterViewModel {
	
//	private String dir = "C:\\Users\\Ulixe\\Downloads";
	
	private String dir = Executions.getCurrent().getArg().get("dir") == null?"C:\\Users\\Ulixe\\Downloads" :Executions.getCurrent().getArg().get("dir").toString();
	
	private static final String footerMessage = "Totale File: %d";
	private FileGFFilter fileGSFilter = new FileGFFilter();
	public List<FileGF> currentFileGS = ReadWindowFileGFData.searchAllFilesIntoDirectory(new File(dir), null);
	
	
	public FileGFFilter getFileGSFilter() {
		return fileGSFilter;
	} 

	public ListModel<FileGF> getFileGSModel(){
		return new ListModelList<>(currentFileGS);
	}
	
	public String getFooter() {
		return String.format(footerMessage, currentFileGS.size());
	}
	
	@Command
	@NotifyChange({"fileGSModel","footer"})
	public void changeFilterName(){
		currentFileGS = ReadWindowFileGFData.searchAllFilesIntoDirectory(new File(dir), fileGSFilter.getExtension());
	}
	
	@Command
	@NotifyChange({"fileGSModel","footer"})
	public void changeFilterExtension(){
		currentFileGS = ReadWindowFileGFData.searchAllFilesIntoDirectory(new File(dir), fileGSFilter.getExtension());
		System.out.println(currentFileGS.size());
	}

	@Command
	public void viewDetail(@BindingParam("file") FileGF fileGF){
		if(fileGF.isDirectory()){
			HashMap<String, Object> map = new HashMap<>();
			map.put("dir", fileGF.getPath());
			Window window = (Window) Executions.createComponents("dettaglioCartella.zul", null, map);
			window.setClosable(true);
			window.setTitle(fileGF.getPath());
			window.doModal();
		}
	}
	
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}
