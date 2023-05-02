package com.poly.ps24083.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poly.ps24083.enity.Users;

public class ExcelUtil{
	
    public static void writeExcel(String filePath, List<Users> usersList,String sheetName,String[] hearder) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();


        XSSFSheet sheet = workbook.createSheet(sheetName);


        Row headerRow = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        for(int i =0;i<hearder.length;i++) {
        	Cell cell = headerRow.createCell(i);
            cell.setCellValue(hearder[i]);
            cell.setCellStyle(headerStyle);
        }

        int rowNum = 1;
        for (Users user : usersList) {
            Row row =sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum);
            row.createCell(1).setCellValue(user.getId());
            row.createCell(2).setCellValue(user.getUsername());
            row.createCell(3).setCellValue(user.getFullname());
            row.createCell(4).setCellValue(user.getBirth().toString());
            row.createCell(5).setCellValue(user.getAvatar());
            row.createCell(6).setCellValue(user.getStarday().toString());
            row.createCell(7).setCellValue(user.getVip());
            row.createCell(8).setCellValue(user.getEmail());
            row.createCell(9).setCellValue(user.getAdmin()?"Admin":"Users");
            row.createCell(10).setCellValue(user.getActive()?"Đang Sử Dụng":"Không hoạt dộng");
           
        }

        for (int i = 0; i < 11; i++) {
        	sheet.autoSizeColumn(i);
        }


        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
	
}
