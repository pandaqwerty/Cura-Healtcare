import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.IOException as IOException
import java.util.Date as Date
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.lang.String as String

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/profile.php#login')

for (def RowNum = 1; RowNum <= findTestData('Cura Healthcare').getRowNumbers(); RowNum++){
	
    WebUI.setText(findTestObject('Cura Healthcare/Username'), findTestData('Cura Healthcare').getValue(1, RowNum))

    WebUI.delay(2)

    WebUI.setText(findTestObject('Cura Healthcare/Password'), findTestData('Cura Healthcare').getValue(2, RowNum))

    WebUI.delay(2)

    WebUI.click(findTestObject('Cura Healthcare/btn Login'))

    WebUI.delay(2)
}
String URLLoginSuccess = WebUI.getUrl()
if (URLLoginSuccess == 'https://katalon-demo-cura.herokuapp.com/#appointment') {
	FileInputStream file = new FileInputStream(new File('C:\\Users\\fuadn\\Documents\\coba Google.com\\test Cura Healtcare.xlsx'))

	XSSFWorkbook workbook = new XSSFWorkbook(file)

	XSSFSheet sheet = workbook.getSheetAt(0)

	sheet.getRow(6).createCell(9).setCellValue('Test Success')

	file.close()

	FileOutputStream outFile = new FileOutputStream(new File('C:\\Users\\fuadn\\Documents\\coba Google.com\\test Cura Healtcare.xlsx'))

	workbook.write(outFile)

	outFile.close()
} else {
	FileInputStream file = new FileInputStream(new File('C:\\Users\\fuadn\\Documents\\coba Google.com\\test Cura Healtcare.xlsx'))

	XSSFWorkbook workbook = new XSSFWorkbook(file)

	XSSFSheet sheet = workbook.getSheetAt(0)

	sheet.getRow(6).createCell(9).setCellValue('Test Failed')

	file.close()

	FileOutputStream outFile = new FileOutputStream(new File('C:\\Users\\fuadn\\Documents\\coba Google.com\\test Cura Healtcare.xlsx'))

	workbook.write(outFile)

	outFile.close()
}
WebUI.closeBrowser()

