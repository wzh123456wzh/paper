package com.wzh.paper.controller;

import com.wzh.paper.entity.Result;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
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
    public Result listUserAndProjects(@RequestParam(value = "file", required = false) MultipartFile mfile,
                                      @RequestParam(value = "name", required = false) String name) {
        Result<String> result = new Result<>();
        try {
            String str = queryNameAndProject(mfile, name);
            result.setMsg("成功了");
            result.setData(str);
        } catch (Exception e) {
            result.setMsg("程序运行错误啦，快点找你老公解决");
            e.printStackTrace();
        }

        return result;
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
                //获取当前工作表行数
                int rows = sheet.getLastRowNum() + 1;
                //获取当前姓名在第几列
                for(i = 0; i < rows; i++){
                    Row row = sheet.getRow(i);
                    int cols = row.getPhysicalNumberOfCells();
                    String frontRow = row.getCell(0).getStringCellValue();
                    if(StringUtils.isEmpty(frontRow) || frontRow.contains("表")){
                        continue;
                    }
                    if(cols >= 3){
                        for(int j = 0; j < cols; j++){
                            String stringCellValue = row.getCell(j).getStringCellValue();
                            if(stringCellValue.contains("项目")){
                                colProject = j;
                            }
                            if(stringCellValue.contains("股东名称") || stringCellValue.contains("股东姓名") || stringCellValue.equals("股东")){
                                colName = j;
                            }

                        }
                        break;
                    }
                }
                for(i = i + 1; i < rows; i++){
                    if(colProject == -1){
                        Row row = sheet.getRow(i);
                        String stockHolder = row.getCell(colName).getStringCellValue();
                        if(stockHolder.equals(name)){
                            stringBuilder.append(sheetName + ",");
                            break;
                        }
                    } else {
                        Row row = sheet.getRow(i);
                        String stockHolder = row.getCell(colName).getStringCellValue();
                        if(stockHolder.equals(name)){
                            String projectName = row.getCell(colProject).getStringCellValue();
                            stringBuilder.append(projectName + ",");
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
