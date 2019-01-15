package Practice.Day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {
	public static void main(String[] args)
	{
		try {
			FileInputStream fn=new FileInputStream("I:\\OrangeHRM\\Day4\\FreeCRM.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fn);
			XSSFSheet sheet=workbook.getSheetAt(0);
			Row row=sheet.getRow(0);
			int rowCount=sheet.getLastRowNum();
			System.out.println("RowCount:"+rowCount);
			int ColCount=row.getLastCellNum();
			System.out.println("ColoumnCount:"+ColCount);
			for(int i=1;i<=rowCount;i++)
			{
				for(int j=0;j<ColCount;j++)
				{
					System.out.print(sheet.getRow(i).getCell(j)+" ");
				}
				System.out.println();
			}
			fn.close();
			workbook.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

