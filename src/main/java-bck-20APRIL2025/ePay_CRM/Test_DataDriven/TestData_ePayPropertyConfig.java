package ePay_CRM.Test_DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData_ePayPropertyConfig {

	@DataProvider(name="Add_Data") 
	public static String[][] getAddData() throws Exception
	{
		String[][] data = null;

		File src=new File(System.getProperty("user.dir")+"//src//main//resources//FetchData//CRM_EpayPropertyConfig_Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Add_Data");  

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

	@DataProvider(name="Reset_Data")
	public static String[][] getResetData() throws Exception
	{
		String[][] data = null;    

		File src=new File("./src/main/resources/FetchData/CRM_EpayPropertyConfig_Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Reset_Data");  

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

	@DataProvider(name="View_Data")
	public static String[][] getViewData() throws Exception
	{
		String[][] data = null;

		File src=new File("./src/main/resources/FetchData/CRM_EpayPropertyConfig_Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("View_Data");  

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

	@DataProvider(name="Edit_Data")
	public static String[][] getEditData() throws Exception
	{
		String[][] data = null;

		File src=new File("./src/main/resources/FetchData/CRM_EpayPropertyConfig_Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Edit_Data");  

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
}
