package com.am.gestorefile.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.am.gestorefile.model.FileGF;

public class UtilsFileGF {

	public static ArrayList<FileGF> getListaFile(String dir){
		
		File root = new File(dir);
		ArrayList<FileGF> files = new ArrayList<>();
		FilenameUtils fnu = new FilenameUtils();
		FileUtils fu = new FileUtils();
		for (int i = 0; i < root.listFiles().length; i++) {
			String filename = root.listFiles()[i].getName();
			FileGF fileGS = new FileGF();
			fileGS.setIdFile(String.valueOf(i));
			fileGS.setName(fnu.getName(filename));
			fileGS.setExtension(fnu.getExtension(filename));
			fileGS.setSize(fu.byteCountToDisplaySize(fu.sizeOf(root.listFiles()[i])));
			fileGS.setDirectory(root.listFiles()[i].isDirectory());
//			fileGS.setDate(fnu.);
			files.add(fileGS);
		}
		return files;
	}
	
	public ArrayList<String> getListaEstensioni(List<FileGF> listaFile){
		ArrayList<String> listaEstensioni = new ArrayList<>();
		listaEstensioni.add(listaFile.get(0).getExtension());
		return listaEstensioni;
	}
	
}
