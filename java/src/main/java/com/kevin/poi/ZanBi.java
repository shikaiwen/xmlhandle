package com.kevin.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.util.StringUtils;

public class ZanBi {

	
//	public static final String file = "G:/BaiduYunDownload/zan.xls";
	public static final String file = "C:/Users/凯文/Desktop/tmp/8zan.xls";
	
	  private static POIFSFileSystem fs;
	    private static  HSSFWorkbook wb;
	    private static  HSSFSheet sheet;
	    private static  HSSFRow row;
	
	public static void main(String [] args) throws Exception{
		
//		sum();
		t1();
	}
	
	
	
	//将所有发送人都放在一起
	public static void t2() throws Exception{
		
		FileOutputStream out = new FileOutputStream("G:/BaiduYunDownload/zan3.xls");
		HSSFWorkbook wbout = new HSSFWorkbook();
		
		Sheet outSheet = wbout.createSheet("Sheet1");
		
		
		InputStream is = new FileInputStream(file);

		fs = new POIFSFileSystem(is);
		wb = new HSSFWorkbook(fs);

		sheet = wb.getSheetAt(0);

		HSSFRow titleRow = sheet.getRow(0);
		
		
		Map<String,List<Integer>> nameMap = new LinkedHashMap<String,List<Integer>>();
		
		for(int i = 1 ; i <= sheet.getLastRowNum(); i ++){
			
			
		}
		
	}
	
	
	public static void sum() throws Exception{


		InputStream is = new FileInputStream(file);

		fs = new POIFSFileSystem(is);
		wb = new HSSFWorkbook(fs);

		sheet = wb.getSheetAt(1);

		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);

		
		
		Map<String,Holder> sumMap = new LinkedHashMap<String,Holder>();
		
		for (int i = 1; i <= rowNum; i++) {
			
			row = sheet.getRow(i);

			HSSFCell senderCell = row.getCell(2);
			HSSFCell receiverCell = row.getCell(3);
//			HSSFCell receiverCell = row.getCell(3);
//			HSSFCell countCell = row.getCell(4);
			
			
			String sender= senderCell.getStringCellValue().trim();
			String receiver= receiverCell.getStringCellValue().trim();
			
			
			
			if(!StringUtils.hasText(sender)){
				System.out.println("退出循环，当前row :" + i);
				break;
			}
			sumMap.put(sender, new Holder());
			sumMap.put(receiver, new Holder());
			
//			String receiver =  receiverCell.getStringCellValue().trim();
//			String count = countCell.getStringCellValue().trim();
			
			
		}
		
		
		for (int i = 1; i <= rowNum; i++) {
			
			row = sheet.getRow(i);

			HSSFCell senderCell = row.getCell(2);
			HSSFCell receiverCell = row.getCell(3);
			HSSFCell countCell = row.getCell(4);
			
			
			String sender= senderCell.getStringCellValue().trim();
			String receiver =  receiverCell.getStringCellValue().trim();
			
			int count =  new Double(countCell.getNumericCellValue()).intValue() ;
			
			System.out.println("sender:"+sender + ", receiver: " + receiver + ", count:" + count);
			
			
			Holder senderHolder = sumMap.get(sender);
			Holder receiverHolder = sumMap.get(receiver);
			
			//没数据了要跳出
			if(senderHolder == null || receiverHolder==null){
				break;
				
			}
			senderHolder.setSendCount( senderHolder.getSendCount() +  count  );
			
			
			receiverHolder.setReceiveCount( receiverHolder.getReceiveCount() +  count   );
			
			
			
		}
		
		System.out.println("===============统计数据==============");
		

		
		
		FileOutputStream out = new FileOutputStream(file);
//		HSSFWorkbook wbout = new HSSFWorkbook();
		
		int startRow = 555;
		
		
		HSSFRow t = sheet.createRow(startRow);
		t.createCell(0).setCellValue("姓名");
		t.createCell(1).setCellValue("发送个数");
		t.createCell(2).setCellValue("收到个数");
		
		
		for(String key : sumMap.keySet()){
			Holder h = sumMap.get(key);
			System.out.println(key + "收到"+ h.getReceiveCount() +  "个, 发送"+ h.getSendCount());
			
			HSSFRow r = sheet.createRow(++startRow);
			r.createCell(0).setCellValue(key);
			r.createCell(1).setCellValue(h.getSendCount());
			r.createCell(2).setCellValue(h.getReceiveCount());
		}
		
		is.close();
		
		wb.write(out);
		wb.close();
		out.close();
	}
	
	
	public static void t1() throws Exception{
		
		
		FileOutputStream out = new FileOutputStream("G:/BaiduYunDownload/zan2.xls");
		HSSFWorkbook wbout = new HSSFWorkbook();
		
		Sheet outSheet = wbout.createSheet("Sheet1");
		
		int destRow = -1;
		
		
		InputStream is = new FileInputStream(file);
		
		  fs = new POIFSFileSystem(is);
          wb = new HSSFWorkbook(fs);
          
          sheet = wb.getSheetAt(0);
          
          
          HSSFRow titleRow = sheet.getRow(0);
          HSSFRow toTitleRow = (HSSFRow)outSheet.createRow(++destRow);
          copyRow(wbout, titleRow, toTitleRow, true);
          
          
          int rowNum = sheet.getLastRowNum();
          row = sheet.getRow(0);
          
          
          Map<String,List<HSSFRow>> nameMap = new LinkedHashMap<String,List<HSSFRow>>();
          
          // 正文内容应该从第二行开始,第一行为表头的标题
          for (int i = 1; i <= rowNum; i++) {
              row = sheet.getRow(i);
              
              System.out.println("当前序号:"+ row.getCell(0).getNumericCellValue());
              HSSFCell nameC = row.getCell(7);
              String str = nameC.getStringCellValue();
              
              @SuppressWarnings("unused")
			String [] arr =  str.split("[，,(\\s){1,}、；@]");
//              System.out.print(str);

              for(int m = 0;m< arr.length;m++){
            	  
            	  String name = arr[m];
            	  if(!StringUtils.hasText(name)) continue;
            	  
            	 
            	  
                  HSSFRow toRow = (HSSFRow)outSheet.createRow(++destRow);
                  
                  copyRow(wbout, row, toRow, true);
            	  toRow.getCell(7).setCellValue(name);
            	  
            	  
              }
              
          }
          
          
//          for(int r = 1; r <= rowNum ; r ++){
//        	  
//              String name = outSheet.getRow(r).getCell(6).getStringCellValue().trim();
//        	  
//        	  if(nameMap.get(name) == null){
//        		  nameMap.put(name, new ArrayList());
//        	  }
//        	  nameMap.get(name).add((HSSFRow)outSheet.getRow(r));
//          }
//          
//          int currRow = 1;
//          
//          for(String s : nameMap.keySet()){
//        	  
//        	  List<HSSFRow> rows = nameMap.get(s);
//        	  
//        	  for(HSSFRow r : rows){
//        		  r.setRowNum(currRow++);
//        	  }
//        	  
//          }
          
          
  		wbout.write(out);
  		wb.close();
  		out.close();
		
	}
	
	static  HSSFCellStyle cellStyle = null;
	   public static void copyCell(HSSFWorkbook wb,HSSFCell srcCell, HSSFCell distCell,  
	            boolean copyValueFlag) {  
		   
		   if(cellStyle == null){
			   cellStyle =  wb.createCellStyle();
		   }
		   
	        HSSFCellStyle newstyle=  cellStyle ;//wb.createCellStyle();  
	        copyCellStyle(srcCell.getCellStyle(), newstyle);  
//	        distCell.setEncoding(srcCell.getEncoding());  
	        //样式  
	        distCell.setCellStyle(newstyle);  
	        //评论  
	        if (srcCell.getCellComment() != null) {  
	            distCell.setCellComment(srcCell.getCellComment());  
	        }  
	        // 不同数据类型处理  
	        int srcCellType = srcCell.getCellType();  
	        distCell.setCellType(srcCellType);  
	        if (copyValueFlag) {  
	            if (srcCellType == HSSFCell.CELL_TYPE_NUMERIC) {  
	                if (HSSFDateUtil.isCellDateFormatted(srcCell)) {  
	                    distCell.setCellValue(srcCell.getDateCellValue());  
	                } else {  
	                    distCell.setCellValue(srcCell.getNumericCellValue());  
	                }  
	            } else if (srcCellType == HSSFCell.CELL_TYPE_STRING) {  
	                distCell.setCellValue(srcCell.getRichStringCellValue());  
	            } else if (srcCellType == HSSFCell.CELL_TYPE_BLANK) {  
	                // nothing21  
	            } else if (srcCellType == HSSFCell.CELL_TYPE_BOOLEAN) {  
	                distCell.setCellValue(srcCell.getBooleanCellValue());  
	            } else if (srcCellType == HSSFCell.CELL_TYPE_ERROR) {  
	                distCell.setCellErrorValue(srcCell.getErrorCellValue());  
	            } else if (srcCellType == HSSFCell.CELL_TYPE_FORMULA) {  
	                distCell.setCellFormula(srcCell.getCellFormula());  
	            } else { // nothing29  
	            }  
	        }  
	    }  
	
    public static void copyRow(HSSFWorkbook wb,HSSFRow fromRow,HSSFRow toRow,boolean copyValueFlag){  
        for (Iterator cellIt = fromRow.cellIterator(); cellIt.hasNext();) {  
            HSSFCell tmpCell = (HSSFCell) cellIt.next();  
            HSSFCell newCell = toRow.createCell(tmpCell.getCellNum());  
            copyCell(wb,tmpCell, newCell, copyValueFlag);  
        }  
    }  

    
    public static void copyCellStyle(HSSFCellStyle fromStyle,  
            HSSFCellStyle toStyle) {  
        toStyle.setAlignment(fromStyle.getAlignment());  
        //边框和边框颜色  
        toStyle.setBorderBottom(fromStyle.getBorderBottom());  
        toStyle.setBorderLeft(fromStyle.getBorderLeft());  
        toStyle.setBorderRight(fromStyle.getBorderRight());  
        toStyle.setBorderTop(fromStyle.getBorderTop());  
        toStyle.setTopBorderColor(fromStyle.getTopBorderColor());  
        toStyle.setBottomBorderColor(fromStyle.getBottomBorderColor());  
        toStyle.setRightBorderColor(fromStyle.getRightBorderColor());  
        toStyle.setLeftBorderColor(fromStyle.getLeftBorderColor());  
          
        //背景和前景  
        toStyle.setFillBackgroundColor(fromStyle.getFillBackgroundColor());  
        toStyle.setFillForegroundColor(fromStyle.getFillForegroundColor());  
          
        toStyle.setDataFormat(fromStyle.getDataFormat());  
        toStyle.setFillPattern(fromStyle.getFillPattern());  
//      toStyle.setFont(fromStyle.getFont(null));  
        toStyle.setHidden(fromStyle.getHidden());  
        toStyle.setIndention(fromStyle.getIndention());//首行缩进  
        toStyle.setLocked(fromStyle.getLocked());  
        toStyle.setRotation(fromStyle.getRotation());//旋转  
        toStyle.setVerticalAlignment(fromStyle.getVerticalAlignment());  
        toStyle.setWrapText(fromStyle.getWrapText());  
          
    }  
}
