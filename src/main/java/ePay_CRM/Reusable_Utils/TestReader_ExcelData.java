package ePay_CRM.Reusable_Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class TestReader_ExcelData {

	 // Generic method to get data based on sheet name
	public static String[][] getData(String sheetName,String FileName) throws Exception
	{
		String[][] data = null;
		File src=new File(System.getProperty("user.dir")+"//src//main//resources//FetchData//"+FileName+".xlsx");
		
		//File src=new File(System.getProperty("user.dir")+"//src//main//resources//FetchData//APITestData.xlsx");
		//File src=new File(System.getProperty("user.dir")+"//src//main//resources//FetchData//CRM_EpayPropertyConfig_Data.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);  

		// get the number of rows
		int rowCount = sheet.getLastRowNum();//2

		// get the number of columns
		int columnCount = sheet.getRow(0).getLastCellNum();//1
		
		//System.out.println("\n Row Count :"+rowCount);
		//System.out.println("\n Column Count :"+columnCount);

		System.out.println("\n Total No. of Records (Rows) :"+rowCount);
		System.out.println("\n Total No. of Fields (Columns) ::"+columnCount);

		data = new String[rowCount][columnCount];
		// loop through the rows
		for(int i=1; i <rowCount+1; i++){
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j <columnCount; j++){ // loop through the columns
				{
					 XSSFCell cell = row.getCell(j);
					String cellValue = "";

			        if (cell == null || cell.getCellType() == CellType.BLANK) {
			            cellValue = ""; // Handle empty cell
			        } else {
			            cellValue = cell.toString();
			        }
			        data[i - 1][j] = cellValue; // add to the data array


				}              
			}
			workbook.close();
			fis.close();
			
			//OUTPUT FILE GENERATION
			

		}

		for (String[] dataArr:data)
		{
			System.out.println("\n Imported Records: "+Arrays.toString(dataArr));
		}
		// **Generate Output File with Execution Status**
       //generateOutputFile(data, ste ,"Test_OuputFileName");

		return data;
	}
	
	public static void generateOutputFile(String[][] data, boolean[] executionStatus, String fileName) throws Exception {
		File outputFile = new File(System.getProperty("user.dir") + "/OutputFileResults/" + fileName + "_Results.xlsx");

	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("TestResults");

	    // Writing headers dynamically
	    Row headerRow = sheet.createRow(0);
	    for (int j = 0; j < data[0].length; j++) {
	        headerRow.createCell(j).setCellValue("Input Column " + (j + 1));
	    }
	    headerRow.createCell(data[0].length).setCellValue("Execution Status"); // Test result

	    // Writing all input values + execution status
	    for (int i = 0; i < data.length; i++) {
	        Row row = sheet.createRow(i + 1);

	        for (int j = 0; j < data[i].length; j++) {
	            row.createCell(j).setCellValue(data[i][j]); // Writing input values
	        }

	        row.createCell(data[i].length).setCellValue(executionStatus[i] ? "Pass" : "Fail"); // Test execution result
	    }

	    FileOutputStream outFile = new FileOutputStream(outputFile);
	    workbook.write(outFile);
	    outFile.close();
	    workbook.close();

	    System.out.println("Output file generated successfully: " + outputFile.getAbsolutePath());
	}

	public static String executeTest(String[] testData, boolean actualStatusValue) {
	    // Assuming you want to check a specific field (e.g., first column in testData)
		
		System.out.println(" --- ACTUAL Status : "+actualStatusValue);
	    return actualStatusValue ? "Pass" : "Fail";
	}
	
	  // Parameterized DataProvider to accept sheet names
    @DataProvider(name = "ExcelDataProvider")
    public static Object[][] getExcelDataProvider(ITestContext context) throws Exception {
        String sheetName = context.getCurrentXmlTest().getParameter("sheetName");
        String fileName=context.getCurrentXmlTest().getParameter("fileName");
        System.out.println("\n File name : "+fileName);
        System.out.println("\n Sheet name : "+sheetName);
      return getData(sheetName,fileName);// Commented coz this value we are referring from testng xml file
      // return getData("Add");
    }
}
