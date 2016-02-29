package com.kevin.poi;

import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Basic {

	public static void main(String[] args) throws Exception{
//		apacheExample();
		
		writeFile();
		
//		FileOutputStream fos = new FileOutputStream("");
//		fos.write("12".getBytes());
//		color();
	}
	
	public static void color() throws Exception{
		  Workbook wb = new XSSFWorkbook();
		    Sheet sheet = wb.createSheet("new sheet");

		    // Create a row and put some cells in it. Rows are 0 based.
		    Row row = sheet.createRow((short) 1);

		    // Aqua background
		    CellStyle style = wb.createCellStyle();
		    style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		    style.setFillPattern(CellStyle.BIG_SPOTS);
		    Cell cell = row.createCell((short) 1);
		    cell.setCellValue("X");
		    cell.setCellStyle(style);

		    // Orange "foreground", foreground being the fill foreground not the font color.
		    style = wb.createCellStyle();
		    style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    cell = row.createCell((short) 2);
		    cell.setCellValue("X");
		    cell.setCellStyle(style);

		    // Write the output to a file
		    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		    wb.write(fileOut);
		    fileOut.close();
	}
	
	
	public static void writeFile() throws Exception{
		
		FileOutputStream out = new FileOutputStream("book.xls");
		Workbook wb = new HSSFWorkbook();
		
		Sheet s = wb.createSheet("·¿²úÐÅÏ¢");
		
		CellStyle rowStyle = wb.createCellStyle();
//		rowStyle.setFillBackgroundColor(HSSFColor.YELLOW.index);
//		rowStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
//		rowStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		rowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		rowStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
		for(int i = 0;i < 50;i++){
			
			Row row = s.createRow(i);
			Cell c0 = row.createCell(0);
			Cell c1 = row.createCell(1);
			Cell c2 = row.createCell(2);
			Cell c3 = row.createCell(3);
			Cell c4 = row.createCell(4);
			Cell c5 = row.createCell(5);
			
			String value0 = "ÉîÛÚ¸£ÌïÇø";
			c0.setCellValue(value0);
			CellStyle widthStyle = wb.createCellStyle();
			
//			s.setColumnWidth(0, (value0.length()+1) * 256 *2);
			
			
			c1.setCellValue((50 + i + ( (int)(Math.random() * 10)))+" Æ½Ã×·¿×Ó");
			c2.setCellValue( ( (int)(Math.random() * 10)) + "ÍòÔª");
			c3.setCellValue("¿ìÀ´Âò°É");
			c3.setCellValue("ºÃÂð");
			String value4 = "¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ°¡°¡°¡°¡°¡°¡°¡°¡";
			c4.setCellValue(value4);
			
			Iterator<Cell> cellIter = row.cellIterator();
			for(;cellIter.hasNext();){
				Cell c = cellIter.next();
				String str = c.getStringCellValue();
//				s.setDefaultColumnWidth(arg0);
				s.setColumnWidth(c.getColumnIndex(), (str.length()+1) * 256 * 2);
			}
			
			
			if(i !=0 && i%3 ==0){
//				CellStyle rowStyle = row.getRowStyle();

				row.setRowStyle(rowStyle);
				
				Iterator<Cell> bgIter = row.cellIterator();
				for(;bgIter.hasNext();){
					Cell c = bgIter.next();
					c.setCellStyle(rowStyle);
				}
				
				
			}
			
		}
//		IndexedColors.g
		wb.write(out);
		out.close();
		wb.close();
	}
	
	
	
	public static void apacheExample() throws Exception{
		FileOutputStream out = new FileOutputStream("workbook.xls");
		Workbook wb = new HSSFWorkbook();
		Sheet s = wb.createSheet();
		Row r = null;
		Cell c = null;
		
		CellStyle cs = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		CellStyle cs3 = wb.createCellStyle();
		DataFormat df = wb.createDataFormat();
		
		Font f = wb.createFont();
		Font f2 = wb.createFont();
		
		f.setFontHeightInPoints((short)12);
//		HSSFColor.DARK_GREEN
//		f.setColor((short)0xc); // blue
//		f.setColor(Font.COLOR_RED);
		f.setColor(HSSFColor.DARK_GREEN.index); // green
		
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		f2.setFontHeightInPoints( (short)10 );
		f2.setColor(Font.COLOR_RED);
		f2.setBoldweight(Font.BOLDWEIGHT_BOLD);
		f2.setStrikeout(true);
		
		cs.setFont(f);
		cs.setDataFormat(df.getFormat("#,##0.0"));

		cs2.setBorderBottom(cs2.BORDER_THIN);
		cs2.setFillPattern(  CellStyle.SOLID_FOREGROUND );
		cs2.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
		cs2.setFont(f2);
		
		
		// set the sheet name in Unicode
		wb.setSheetName(0, "µ¥×Ó"  );
		                  
		// wb.setSheetName(0, "HSSF Test");
		int rownum;
		for (rownum=(short)0;rownum < 30; rownum++){
			
			r = s.createRow(rownum);
			// on every other row 
			if( (rownum %2) == 0 ){
				r.setHeight( (short)0x249 );
			}
			
			
			for (short cellnum = (short)0; cellnum < 10 ; cellnum += 2){
				
				c = r.createCell(cellnum);
				c.setCellValue( rownum * 10000
						+ cellnum 
						+ ( (double)rownum / 1000  )
						+ ((double)cellnum / 10000 )
						);
				String cellValue;
				
				c = r.createCell( (short)(cellnum + 1) );
				
				// on every other row
				if((rownum %2) == 0){
					c.setCellStyle(cs);
					c.setCellValue( "Test" );
				}else{
					c.setCellStyle(cs2);
					 c.setCellValue( "\u0422\u0435\u0441\u0442" );
				}
				
				s.setColumnWidth((short)(cellnum + 1),  (short)((50*8)/((double) 1 /20))  );
			}
		}
		
		rownum ++;
		rownum ++;
		
		r = s.createRow(rownum);
		
		cs3.setBorderBottom(cs3.BORDER_THICK);
		
		//create 50 cells
		for ( short cellnum = (short)0; cellnum < 50 ; cellnum++){
			c = r.createCell(cellnum);
			c.setCellStyle(cs3);
		}
		
		s = wb.createSheet();
		wb.setSheetName(1, "DeletedSheet");
//		wb.removeSheetAt(1);
		
		wb.write(out);
		out.close();
		
		wb.close();
	}
	
	
	public static void test1(){
//		org.apache.poi.ss.usermodel.WorkbookFactory    in ooxml.jar
		HSSFWorkbook b = new HSSFWorkbook();
		HSSFSheet sheet1 = b.createSheet("sheet1");
		HSSFRow row = sheet1.createRow(0);
		
	}
}
