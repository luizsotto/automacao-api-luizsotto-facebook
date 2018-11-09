package br.com.luizcruz.commons.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class FileUtils {

	final static Logger logger = Logger.getLogger(FileUtils.class.getName());
	
	
	public static File createDirectory(String path) {
		//Criar a parte do diretorio
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		
		return file;
	}
	
	public static File createNewFile(String path) throws IOException {
		//Criar a parte do arquivo
		File file = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
		
		return file;
	}
	
	
	public static void  writeFiles (List <String> data, File file) throws IOException{
		
		long begin = System.currentTimeMillis();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("Arquivo gravado em : " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		writer.newLine();
		writer.write("Caminho da gravação: " + file.getAbsolutePath());
		writer.newLine();
		
		for (String string : data) {
			writer.write(string);
			writer.newLine();
		}
		
		long end = System.currentTimeMillis();
		writer.write("Tempo de gravação: " + (end - begin) + "ms.");
		//Criando o conteúdo do arquivo
		writer.flush();
		//Fechando conexão e escrita do arquivo.
		writer.close();
		logger.info("Arquivo gravado em: " + file.getAbsolutePath());
	}
}
