package io;

import bean.TrstchTypeDTO;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 读取并解析excel
 * @author xuxiangfei
 * @date 2019/10/28
 */
public class ExcelInputStreamRead {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\acer\\Desktop\\转接类型_排序.xlsx");
        try {
            InputStream inputStream = new FileInputStream(file);
            ExcelReader reader = ExcelUtil.getReader(inputStream, "t_chf_transfer2",true);
            reader.addHeaderAlias("转接类型ID", "TRSTCH_TYPE_ID");
            reader.addHeaderAlias("转接类型名称", "TRSTCH_TYPE_NM");
            reader.addHeaderAlias("转接类型代码", "TRSTCH_TYPE_CD");
            reader.addHeaderAlias("CTIID", "CTI_ID");
            List<TrstchTypeDTO> list = reader.readAll(TrstchTypeDTO.class);
//            List<TrstchTypeDTO> list = trstchTypeDTOS.stream().sorted(
//                    (o1, o2) -> o2.getCTI_ID().compareTo(o1.getCTI_ID())
//            )
//                    .collect(Collectors.toList());
            System.out.println(list.toString());
            System.out.println(JSON.toJSONString(list));

            File file2 = new File("C:\\Users\\acer\\Desktop\\转接类型整理.xlsx");
            OutputStream outputStream = new FileOutputStream(file2);
            ExcelWriter writer = ExcelUtil.getWriter(true);
            writer.getWorkbook().setSheetName(0, "转接类型");
            writer.addHeaderAlias("TRSTCH_TYPE_ID", "转接类型ID");
            writer.addHeaderAlias("TRSTCH_TYPE_NM", "转接类型名称");
            writer.addHeaderAlias("TRSTCH_TYPE_CD", "转接类型代码");
            writer.addHeaderAlias("CTI_ID", "CTIID");

            writer.write(list);
            writer.flush(outputStream);
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
