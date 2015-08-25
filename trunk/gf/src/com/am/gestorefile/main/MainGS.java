package com.am.gestorefile.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.am.gestorefile.model.FileGF;
import com.am.gestorefile.model.ReadWindowFileGFData;
import com.am.gestorefile.utility.UtilsFileGF;

public class MainGS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UtilsFileGF u = new UtilsFileGF();
		String dir = "C:\\Users\\Ulixe\\Downloads";
//		String dir =  "C:\\Users\\Ulixe\\Documents";
		ArrayList<FileGF> files = u.getListaFile(dir);
		
		ReadWindowFileGFData.searchAllFilesIntoDirectory(new File(dir), "pdf");
		List listFile = ReadWindowFileGFData.getFileList();
		for (int i = 0; i < listFile.size(); i++) {
			System.out.println(listFile.get(i));
		}
		System.out.print("END");
//		for (FileGF fileGS : files) {
//			System.out.println("***");
//			System.out.println("id: "+fileGS.getIdFile());
//			System.out.println("nome: "+fileGS.getName());
//			System.out.println("est: "+fileGS.getExtension());
//			System.out.println("dim: "+fileGS.getSize());
//			System.out.println("***");
//			System.out.println("");
//		}
//		System.out.println("*********** TOT: "+files.size()+" *************");
	}

}
