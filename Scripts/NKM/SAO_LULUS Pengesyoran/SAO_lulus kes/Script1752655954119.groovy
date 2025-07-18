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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.testobject.ObjectRepository as OR
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By


WebUI.callTestCase(findTestCase('Test Cases/NKM/IO_Menunggu Pengesyoran/IO_menunggu pengesyoran'), null)
WebUI.callTestCase(findTestCase('Test Cases/Login page_SAO user'), null)


println("No. Rujukan Notis: " + GlobalVariable.rujukanNotis)
WebUI.click(findTestObject('Object Repository/NKM/IO/workbasket/a_workbasket'))

// Get the table WebElement using TestObject
WebElement table = WebUI.findWebElement(OR.findTestObject('Object Repository/NKM/IO/workbasket/tbody_table'), 10)

// Get all rows in the table
List<WebElement> rows = table.findElements(By.tagName("tr"))

// Loop through all rows and cells to find matching rujukan notis
String targetText = GlobalVariable.rujukanNotis
boolean isFound = false

for (WebElement row : rows) {
	List<WebElement> cells = row.findElements(By.tagName("td"))
	
	for (WebElement cell : cells) {
		if (cell.getText().trim() == targetText) {
			println("✅ Match found: " + targetText)

			// Optionally: Click the "Masuk Bakul Saya" link in the same row
			//WebElement link = row.findElement(By.xpath(".//a[contains(.,'Masuk Bakul Saya')]"))
			WebElement link = WebUI.findWebElement(OR.findTestObject('Object Repository/NKM/IO/workbasket/a_masuk bakul saya'), 10)
			if (link != null) {
				link.click()
				println("🖱️ Clicked on 'Masuk Bakul Saya'")
			}

			isFound = true
			break
		}
	}

	if (isFound) {
		break
	}
}

if (!isFound) {
	println("❌ No match found for: " + targetText)
}

// Notis Tuntutan

	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Notis tuntutan'))
	
	// Get the table WebElement using TestObject
	WebElement table2 = WebUI.findWebElement(OR.findTestObject('Object Repository/NKM/IO/workbasket/tbody_table'), 10)
	
	// Get all rows in the table
	List<WebElement> rows1 = table2.findElements(By.tagName("tr"))
	
	// Loop through all rows and cells to find matching rujukan notis
	String targetTexts = GlobalVariable.rujukanNotis
	boolean isFounds = false
	
	for (WebElement row1 : rows1) {
		List<WebElement> cells1 = row1.findElements(By.tagName("td"))
		
		for (WebElement cell1 : cells1) {
			if (cell1.getText().trim() == targetText) {
				println("✅ Match found: " + targetTexts)
	
				// Optionally: Click the "Masuk Bakul Saya" link in the same row
				//WebElement link = row.findElement(By.xpath(".//a[contains(.,'Masuk Bakul Saya')]"))
				WebElement link1 = WebUI.findWebElement(OR.findTestObject('Object Repository/NKM/IO/Tugasan Saya/span_papar'), 10)
				if (link1 != null) {
					link1.click()
					println("🖱️ Clicked on 'Papar'")
				}
	
				isFound = true
				break
			}
		}
	
		if (isFound) {
			break
		}
	}
	
	if (!isFound) {
		println("❌ No match found for: " + targetText)
	}
	
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Select_sila pilih'))
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Option_lulus penakat'))
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Button_semak bencana domestik'))
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Select_Status kelulusan'))
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Option_lulus'))
	WebUI.setText(findTestObject('Object Repository/NKM/IO/Tugasan Saya/text_catatan pelulus'),"ABC TEST")
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Button_hantar'))
	
	WebUI.acceptAlert()
	
	