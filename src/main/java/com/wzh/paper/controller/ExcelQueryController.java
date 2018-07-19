package com.wzh.paper.controller;

import com.wzh.paper.entity.Result;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;

/**
 * 输入姓名导出此姓名关联的项目名
 *
 */
@Controller
@RequestMapping("/excel")
public class ExcelQueryController {


    @ResponseBody
    @RequestMapping(value = "/listUserAndProjects", method = RequestMethod.POST)
    public String listUserAndProjects(@RequestParam(value = "file", required = false) MultipartFile mfile,
                                      @RequestParam(value = "name", required = false) String name) {
        Result<String> result = new Result<>();
        try {
            String str = queryNameAndProject(mfile, name);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String queryNameAndProject(MultipartFile mfile, String name) throws Exception {
        CommonsMultipartFile cf= (CommonsMultipartFile)mfile;
        File file = new File(new Date().getTime() + "excel.xlsx");
        cf.getFileItem().write(file);
        // 获得工作簿
        Workbook workbook = WorkbookFactory.create(file);
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        int i = 0;
        // 遍历工作表
        try {
            while(true){
                int colName = -1;
                int colProject = -1;
                Sheet sheet = workbook.getSheetAt(num++);
                String sheetName = sheet.getSheetName();
                System.out.println("正在扫描第" + num + "个表  表名:" + sheetName);
                //获取当前工作表行数
                int rows = sheet.getLastRowNum() + 1;
                //获取当前姓名在第几列
                for(i = 0; i < rows; i++){
                    Row row = sheet.getRow(i);
                    if(row == null){
                        continue;
                    }
                    int cols = row.getPhysicalNumberOfCells();
                    Cell cell = row.getCell(0);
                    if(cell == null){
                        continue;
                    }
                    String frontRow = cell.getStringCellValue();
                    if(StringUtils.isEmpty(frontRow) || frontRow.contains("表")){
                        continue;
                    }
                    if(cols >= 3){
                        for(int j = 0; j < cols; j++){
                            String stringCellValue = null;
                            try {
                                Cell cell1 = row.getCell(j);
                                if(cell1 == null){
                                    continue;
                                }
                                stringCellValue = cell1.getStringCellValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                continue;
                            }
                            if(stringCellValue.contains("项目")){
                                colProject = j;
                            }
                            if(stringCellValue.contains("股东名称") || stringCellValue.contains("股东姓名") || stringCellValue.contains("投资者") || stringCellValue.equals("股东") ||stringCellValue.equals("姓名")){
                                colName = j;
                            }

                        }
                        break;
                    }
                }
                if(colName == -1){
                    continue;
                }
                for(i = i + 1; i < rows; i++){
                    Row row = sheet.getRow(i);
                    if(row == null){
                        continue;
                    }
                    Cell cell = row.getCell(colName);
                    if(cell == null){
                        continue;
                    }
                    if(colProject == -1){
                        String stockHolder = null;
                        try {
                            stockHolder = cell.getStringCellValue();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                            continue;
                        }
                        if(stockHolder.equals(name)){
                            stringBuilder.append("工作表：" + sheetName + "--项目名:" +  sheetName + "<br>");
//                            bw.write("工作表：" + sheetName + "--项目名:" +  sheetName + System.getProperty("line.separator"));
//                            bw.flush();
                            break;
                        }
                    } else {
                        String stockHolder = cell.getStringCellValue();
                        try {
                            stockHolder = cell.getStringCellValue();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                            continue;
                        }
                        if(stockHolder.equals(name)){
                            String projectName = row.getCell(colProject).getStringCellValue();
                            stringBuilder.append("工作表：" + sheetName + "--项目名:" +  projectName + "<br>");
//                            bw.write("工作表：" + sheetName + "--项目名:" +  projectName + System.getProperty("line.separator"));
//                            bw.flush();
                            break;
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        ExcelQueryController excelQuery = new ExcelQueryController();
        File file = new File("C:\\Users\\Administrator\\Documents\\WeChat Files\\wzh13044228001\\Files\\潮南胪岗（啤酒厂）项目跟投明细表（设计系统）.xls");
//        String project = excelQuery.queryNameAndProject(file, "汪海灵");
//        System.out.println(project);
    }

}
