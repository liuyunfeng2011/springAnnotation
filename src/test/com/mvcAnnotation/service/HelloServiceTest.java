package com.mvcAnnotation.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class HelloServiceTest {
	@Ignore
	@Test
	public void testGetHello() throws IOException {
			String disrPath="/Users/yexianyong/Desktop/";
			String htmlFile = "/Users/yexianyong/Desktop/tem.html";
	        String pdfFile = "/Users/yexianyong/Desktop/testoone2.pdf";
	        String templateContent = "";
	        FileInputStream fileinputstream = new FileInputStream(htmlFile);// 读取模板文件
	        int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
            System.out.print(templateContent);
            templateContent = templateContent.replaceAll("gongsiname", "<div class='test'>第一家大鸡排</div>");
            System.out.print(templateContent);
            
            
            String fileame = "xiaohei" + ".html";
            fileame = disrPath+"/" + fileame;// 生成的html文件保存路径。
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
            System.out.print("文件输出路径:");
            System.out.print(fileame);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
	        try {
	        	HelloServiceTest.html2pdf(fileame, pdfFile);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	/**
	 * 将HTML转成PD格式的文件。html文件的格式比较严格
	 * 
	 * @param htmlFile
	 * @param pdfFile
	 * @throws Exception
	 */
	// <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	// "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd ">
	public static void html2pdf(String htmlFile, String pdfFile) throws Exception {
		long l1=System.currentTimeMillis();
		// step 1
		String url = new File(htmlFile).toURI().toURL().toString();
		System.out.println(url);
		// step 2
		OutputStream os = new FileOutputStream(pdfFile);
		System.out.println(os);
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(url);

		// step 3 解决中文支持
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("/Users/yexianyong/Desktop/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		renderer.layout();
		renderer.createPDF(os);
		os.close();

		System.out.println("create pdf done!!");
		long l2=System.currentTimeMillis();
		System.out.println(l2-l1);
	}
	//String title = "<image class='' src="+'"'+imagePath+'"'+"/>";
	//templateContent = templateContent.replaceAll("###title###", title);

}
