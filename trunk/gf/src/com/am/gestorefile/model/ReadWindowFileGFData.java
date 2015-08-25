package com.am.gestorefile.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class ReadWindowFileGFData {

	private static List fileList = new ArrayList<>();
	private static List<FileGF> listFileGF = new ArrayList<>(); 
	
	public static void searchAllFiles(File pathFile, String extension){
		File listFile[] = pathFile.listFiles();
		if(fileList.size()>0){
			fileList.clear();
		}
		if(listFile != null){
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isDirectory()) {
					searchAllFiles(listFile[i], extension);
				}else{
					if(extension != null){
						if(listFile[i].getName().endsWith(extension)){
							fileList.add(listFile[i].getPath());
						}
					}else{
						fileList.add(listFile[i].getPath());
					}
				}
			}
		}
	}
	
	public static List<FileGF> searchAllFilesIntoDirectory(File pathFile, String extension){
		File listFile[] = pathFile.listFiles();
		if(fileList.size()>0){
			fileList.clear();
		}
		if(listFileGF.size()>0){
			listFileGF.clear();
		}
		if(listFile != null){
			for (int i = 0; i < listFile.length; i++) {
				if(extension != null){
					if(extension.equals("directory")){
						if(listFile[i].isDirectory()){
							FileGF fileGF = new FileGF();
							fileGF.setIdFile(String.valueOf(i));
							fileGF.setName(listFile[i].getName());
							fileGF.setPath(listFile[i].getPath());
							fileGF.setExtension("directory");
							fileGF.setDirectory(true);
							fileGF.setSize(FileUtils.byteCountToDisplaySize(listFile[i].length()));
							listFileGF.add(fileGF);
							fileList.add(listFile[i].getPath());
						}
					}else{
						if(listFile[i].getName().endsWith(extension)){
							FileGF fileGF = new FileGF();
							fileGF.setIdFile(String.valueOf(i));
							fileGF.setName(listFile[i].getName());
							fileGF.setPath(listFile[i].getPath());
							fileGF.setExtension(FilenameUtils.getExtension(listFile[i].getPath()));
							fileGF.setSize(FileUtils.byteCountToDisplaySize(listFile[i].length()));
							listFileGF.add(fileGF);
							fileList.add(listFile[i].getPath());
						}
					}
				}else{
					FileGF fileGF = new FileGF();
					fileGF.setIdFile(String.valueOf(i));
					fileGF.setName(listFile[i].getName());
					fileGF.setPath(listFile[i].getPath());
					if(listFile[i].isDirectory()){
						fileGF.setDirectory(true);
						fileGF.setExtension("directory");
					}else{
						fileGF.setExtension(FilenameUtils.getExtension(listFile[i].getPath()));
					}
					fileGF.setSize(FileUtils.byteCountToDisplaySize(listFile[i].length()));
					listFileGF.add(fileGF);
					fileList.add(listFile[i].getPath());
				}
			}
		}
		return listFileGF;
	}

	public static List getFileList() {
		return fileList;
	}

	public static List<FileGF> getListFileGF() {
		return listFileGF;
	}
	
}
