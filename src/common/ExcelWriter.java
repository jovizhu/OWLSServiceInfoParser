package common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import parser.IONode;
import parser.ServiceInfo;

public class ExcelWriter {

	public static void writer(String filename, ArrayList<ServiceInfo> serviceInfoList)
	{
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Service Data");
          
        //Iterate over data and write to sheet

        int rownum = 0;
        int cellnum = 0;
        Row row = sheet.createRow(rownum++);
        Cell cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceName");

        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceInput - 1");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceInput - 2");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceInput - 3");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceOutput - 1");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceOutput - 2");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceOutput - 3");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceLocal - 1");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceLocal - 2");
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceLocal - 3");
        
        cell = row.createCell(cellnum++);
        cell.setCellValue("ServiceDescription");
        
        Iterator<ServiceInfo> itr = serviceInfoList.iterator();
        while (itr.hasNext())
        {
        	cellnum = 0;
            row = sheet.createRow(rownum++);
            
            ServiceInfo svcinfo = itr.next();
            
            cell = row.createCell(cellnum);
            cell.setCellValue(svcinfo.getServiceName());   
            Iterator<IONode> itrInput = svcinfo.getServiceInput().iterator();
            
            cellnum = cellnum+1;
            int i = 0;
            
            for (i=0;itrInput.hasNext() && i<3; i++)
            {
            	 IONode ionode = itrInput.next();
            	 cell = row.createCell(cellnum+i);
                 cell.setCellValue(ionode.getIONodeType());

            }
            
            cellnum = cellnum+3;
            Iterator<IONode> itrOutput = svcinfo.getServiceOutput().iterator();
            for (i=0;itrOutput.hasNext() && i<3; i++)
            {
            	 IONode ionode = itrOutput.next();
            	 cell = row.createCell(cellnum+i);
                 cell.setCellValue(ionode.getIONodeType());

            }
            
            cellnum = cellnum+3;
            Iterator<IONode> itrLocal = svcinfo.getServiceLocal().iterator();
            for (i=0;itrLocal.hasNext() && i<3; i++)
            {
            	 IONode ionode = itrLocal.next();
            	 cell = row.createCell(cellnum+i);
                 cell.setCellValue(ionode.getIONodeType());

            }
            cellnum = cellnum+3;
            cell = row.createCell(cellnum);
            cell.setCellValue(svcinfo.getServiceDescription());
           
        }
        
        
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("serviceInfoList.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("serviceInfoList.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	}
