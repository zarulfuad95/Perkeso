import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.WebElement as WebElement
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
import com.kms.katalon.core.testobject.ObjectRepository as OR
import org.openqa.selenium.By as By


WebUI.callTestCase(findTestCase('Test Cases/NKM/SAO_LULUS Pengesyoran/SAO_lulus kes'), null)
WebUI.callTestCase(findTestCase('Test Cases/Login page_BCO user'), null)


println("No. Rujukan Notis: " + GlobalVariable.rujukanNotis)

WebUI.click(findTestObject('Object Repository/NKM/IO/workbasket/a_workbasket'))
WebUI.click(findTestObject('Object Repository/NKM/BCO/a_butiran faedah'))

// Get the table WebElement using TestObject
WebElement table = WebUI.findWebElement(findTestObject('Object Repository/NKM/IO/workbasket/tbody_table'), 10)
// Get all rows in the table
List<WebElement> rows = table.findElements(By.tagName("tr"))

// Loop through all rows and cells to find matching rujukan notis
String targetText = GlobalVariable.rujukanNotis

// Replace 'NKM' with 'PKT' only in the first occurrence
targetTexts = targetText.replace('NKM', 'PKT')
// Optional debug print
println("Updated No. Rujukan Notis: " + targetTexts)

boolean isFound = false

for (WebElement row : rows) {
	List<WebElement> cells = row.findElements(By.tagName("td"))
	
	for (WebElement cell : cells) {
		if (cell.getText().trim() == targetTexts) {
			println("✅ Match found: " + targetTexts)

			// Optionally: Click the "Masuk Bakul Saya" link in the same row
		WebElement link = row.findElement(By.xpath(".//a[contains(.,'Masuk Bakul Saya')]"))
			//WebElement link = WebUI.findWebElement(findTestObject('Object Repository/NKM/BCO/a_masuk bakul saya'), 10)
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
	println("❌ No match found for: " + targetTexts)
}


// butiran faedah

	WebUI.click(findTestObject('Object Repository/NKM/BCO/a_butiran faedah'))
	
	// Get the table WebElement using TestObject
	WebElement table2 = WebUI.findWebElement(findTestObject('Object Repository/NKM/IO/workbasket/tbody_table'), 10)
	
	// Get all rows in the table
	List<WebElement> rows1 = table2.findElements(By.tagName("tr"))
	
	// Loop through all rows and cells to find matching rujukan notis
	//String targetTexts = GlobalVariable.rujukanNotis
	//targetText = targetText.replace('NKM', 'PKT')
	// Optional debug print
	//println("Updated No. Rujukan Notis: " + targetText)
	boolean isFounds = false
	
	for (WebElement row1 : rows1) {
		List<WebElement> cells1 = row1.findElements(By.tagName("td"))
		
		for (WebElement cell1 : cells1) {
			if (cell1.getText().trim() == targetTexts) {
				println("✅ Match found: " + targetTexts)
	
				// Optionally: Click the "Masuk Bakul Saya" link in the same row
				//WebElement link = row.findElement(By.xpath(".//a[contains(.,'Masuk Bakul Saya')]"))
				WebElement link1 = WebUI.findWebElement(findTestObject('Object Repository/NKM/IO/Tugasan Saya/span_papar'), 10)
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
		println("❌ No match found for: " + targetTexts)
	}

	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Select_sila pilih'))
	WebUI.click(findTestObject('Object Repository/NKM/BCO/option_pengesyoran kes'))
	WebUI.click(findTestObject('Object Repository/NKM/BCO/select_penyosoran'))
	WebUI.click(findTestObject('Object Repository/NKM/BCO/option_pengeysoran kes'))
	WebUI.setText(findTestObject('Object Repository/NKM/BCO/Textarea'),'TEST ABC')
	WebUI.click(findTestObject('Object Repository/NKM/IO/Tugasan Saya/Button_hantar'))
	
	WebUI.acceptAlert()
	
	
	
	
	
	
	
