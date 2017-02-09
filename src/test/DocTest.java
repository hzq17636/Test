package test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DocTest {
	
    public static void main(String[] args) {
		
    	InputStream inStream;
    	OutputStream outStream;
		try {
//			inStream = getInFileStream("E://电子档案DZ-3.2.0手册(0415532225).docx");
			inStream = getInFileStream("F:\\resume\\201611\\LG6114737578486174720620.doc");
			//inStream = getInFileStream("E://北师大版-胡晓�?odt");
			outStream = getOutFileStream("D://test.pdf");
			Converter converter = new OdtToPDF(inStream, outStream, false, true);//new DocxToPDFConverter(inStream, outStream, false, true);
			
			converter.convert();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    	
	}
    
    
    protected static InputStream getInFileStream(String inputFilePath) throws FileNotFoundException{
		File inFile = new File(inputFilePath);
		FileInputStream iStream = new FileInputStream(inFile);
		return iStream;
	}
	
	protected static OutputStream getOutFileStream(String outputFilePath) throws IOException{
		File outFile = new File(outputFilePath);
		
		try{
			//Make all directories up to specified
			outFile.getParentFile().mkdirs();
		} catch (NullPointerException e){
			//Ignore error since it means not parent directories
		}
		
		outFile.createNewFile();
		FileOutputStream oStream = new FileOutputStream(outFile);
		return oStream;
	}
}
