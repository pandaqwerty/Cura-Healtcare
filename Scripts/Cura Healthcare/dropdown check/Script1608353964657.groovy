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

WebUI.callTestCase(findTestCase('Cura Healthcare/Login'), [:], FailureHandling.STOP_ON_FAILURE)


for (int i = 0 ; i < 2 ; i++){
	WebUI.selectOptionByValue(findTestObject("Cura Healthcare/dropdown"), 'Seoul CURA Healthcare Center', false)
	
	WebUI.delay(3)
	
	WebUI.verifyOptionSelectedByValue(findTestObject('Cura Healthcare/dropdown'), 'Seoul CURA Healthcare Center', false,
		3)
	
	WebUI.selectOptionByValue(findTestObject("Cura Healthcare/dropdown"), 'Tokyo CURA Healthcare Center', false)
	
	WebUI.delay(3)
	
	WebUI.verifyOptionSelectedByValue(findTestObject('Cura Healthcare/dropdown'), 'Tokyo CURA Healthcare Center', false,
		3)
	
	WebUI.selectOptionByValue(findTestObject("Cura Healthcare/dropdown"), 'Hongkong CURA Healthcare Center', false)
	
	WebUI.delay(3)
	
	WebUI.verifyOptionSelectedByValue(findTestObject('Cura Healthcare/dropdown'), 'Hongkong CURA Healthcare Center', false,
		3)
}

WebUI.closeBrowser()
