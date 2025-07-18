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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDate;
import java.util.Random;
import utils.ICGenerator


WebUI.callTestCase(findTestCase('Test Cases/Login page_pk user'), null)

WebUI.waitForElementPresent(findTestObject('Object Repository/a_Notis Tuntutan Baru'), 30)
WebUI.click(findTestObject('Object Repository/a_Notis Tuntutan Baru'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NKM/a_NKM'), 0)
WebUI.click(findTestObject('Object Repository/NKM/a_NKM'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NKM/input_ no kad pengenalan text field'), 10)
// 2️⃣ Click on the IC field if needed
WebUI.click(findTestObject('Object Repository/NKM/input_ no kad pengenalan text field'))


// 1️⃣ Generate random IC
String icNumber = ICGenerator.generateRandomIC()
println "Generated IC: " + icNumber



// 3️⃣ Set text in the IC field
WebUI.setText(findTestObject('Object Repository/NKM/input_ no kad pengenalan text field'), icNumber)




WebUI.waitForElementVisible(findTestObject('Object Repository/NKM/input_death date'), 0)
WebUI.setText(findTestObject('Object Repository/NKM/input_death date'),'01/06/2025')

WebUI.click(findTestObject('Object Repository/NKM/button_carian'))

WebUI.click(findTestObject('Object Repository/NKM/button_daftar kes baru'))


//WebUI.closeBrowser()
