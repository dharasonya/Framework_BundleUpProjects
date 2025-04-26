package ePay_CRM.Reusable_Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

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
					String cellValue = "";

					cellValue = row.getCell(j).toString();

					data[i-1][j]  = cellValue; // add to the data array
					// System.out.println(cellValue);

				}              
			}
			workbook.close();
			fis.close();
		}

		for (String[] dataArr:data)
		{
			System.out.println("\n Imported Records: "+Arrays.toString(dataArr));
		}

		return data;
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
