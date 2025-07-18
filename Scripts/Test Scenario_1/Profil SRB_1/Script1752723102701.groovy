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
import utils.ICGenerator
import utils.DynamicICGenerator
import org.openqa.selenium.Keys
import com.kms.katalon.core.testobject.ConditionType


WebUI.callTestCase(findTestCase('Test Cases/Test Scenario_1/NOTIS ASAL_NKM_1'), null)

String tarikhterimaborang = CustomKeywords.'utils.DynamicICGenerator.getTodayDateInFormat'()

WebUI.waitForElementPresent(findTestObject("Object Repository/NKM/Profil SRB/Tarikh terima borang"), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Tarikh terima borang'))

//WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/Tarikh terima borang'),'17/07/2025')

String todayFormatted = GlobalVariable.tarikhterimaborang // "17/07/2025"
String dayOnly = todayFormatted.split("/")[0]             // "17"
println("Day only for calendar click: " + dayOnly)

TestObject dynamicDate = new TestObject('dynamicDate')
dynamicDate.addProperty('xpath', ConditionType.EQUALS, "//td[normalize-space(text())='" + dayOnly + "' and not(contains(@class,'yui3-calendar-selection-disabled'))]")

WebUI.waitForElementVisible(dynamicDate, 10)
WebUI.click(dynamicDate)


WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/Select_ sumber Notis diterima'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Select_ sumber Notis diterima'))
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Option Online'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/input_butiran srb name'), 0)


// Generate a random Malaysian woman name
String womanName = ICGenerator.generateRandomMalaysianWomanName()
println "Generated Name: " + womanName

// Set into your name field
WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/input_butiran srb name'), womanName)

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/input_no kad pengenalan'),10)
String NoKadPengenalan = WebUI.getAttribute(findTestObject('Object Repository/NKM/Profil SRB/input_no kad pengenalan'), 'value')
println "Raw IC: " + NoKadPengenalan

// Extract birthdate part from IC
String icDatePart = NoKadPengenalan.substring(0, 6)

// Extract year, month, day
String yy = icDatePart.substring(0, 2)
String mm = icDatePart.substring(2, 4)
String dd = icDatePart.substring(4, 6)

// Convert to yyyy
int yearInt = Integer.parseInt(yy)
if (yearInt >= 0 && yearInt <= 24) { // Adjust based on your data pipeline
	yearInt += 2000
} else {
	yearInt += 1900
}

// Format to dd/MM/yyyy
String formattedDate = String.format("%02d/%02d/%d", Integer.parseInt(dd), Integer.parseInt(mm), yearInt)

println "Formatted Date: " + formattedDate
WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/input_Tarikh lahir'),0)
WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/input_Tarikh lahir'), formattedDate)



WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/Select_warganegara'),0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Select_warganegara'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/option_malaysia'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/option_malaysia'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/select_bangsa'),0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/select_bangsa'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/option_bangsa'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/option_bangsa'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/Select_status perkahwinan'),0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Option_status perkahwinna'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/Select_status bekerja'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Select_status bekerja'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/Option_status bekerja'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Option_status bekerja'))

WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/Input_alamat'), 'Kampung baru jalan ABC')
WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/input_bandar'), 'Kelana jaya')
WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/input_postcode'),'54200')
WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/Select_negeri'),0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/Option_negeri'))

WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/input_no telephone rumah'), '01234567890')
WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/Input_no telephone bimbit'), '01234567890')
WebUI.setText(findTestObject('Object Repository/NKM/Profil SRB/input_email'),'rccsituseonly@gmail.com')

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Profil SRB/button_simpan'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Profil SRB/button_simpan'))


WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/butiran caruman SRB/input_tarikh mula'), 0)
WebUI.setText(findTestObject('Object Repository/NKM/butiran caruman SRB/input_tarikh mula'), '01/01/2025')

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/butiran caruman SRB/Select_bilangan Caruman'), 0)
WebUI.click(findTestObject('Object Repository/NKM/butiran caruman SRB/Option_bilangan Caruman'))
WebUI.click(findTestObject('Object Repository/NKM/butiran caruman SRB/Button_tambah'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/butiran caruman SRB/Button_selanjutnya'),0)
WebUI.click(findTestObject('Object Repository/NKM/butiran caruman SRB/Button_selanjutnya'))


WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Butis notis kematian/Select_punca kematian'),0)
WebUI.click(findTestObject('Object Repository/NKM/Butis notis kematian/Select_punca kematian'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Butis notis kematian/Option_becana domestik'),0)
WebUI.click(findTestObject('Object Repository/NKM/Butis notis kematian/Option_becana domestik'))

WebUI.setText(findTestObject('Object Repository/NKM/Butis notis kematian/Textarea_sebab kematian'), 'TEST ABC')
WebUI.click(findTestObject('Object Repository/NKM/Butis notis kematian/Button_simpan'))



//Butiran Pemohon

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Butiran Pemohon/input_nama pemohon'),0)
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_nama pemohon'), womanName)



String KadPengenalan = ICGenerator.generateRandomIC1()
println "Generated Name: " + KadPengenalan

WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_ no kad pengenalan'), KadPengenalan)
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_alamat'), 'Kampung Baru AJL ')
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_bandar'),'setapak ')
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_postcode'), '54200')
WebUI.click(findTestObject('Object Repository/NKM/Butiran Pemohon/Select_negeri'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran Pemohon/select_negeri wilayah'))
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/Input_no telephone'), '01234567890')
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_telephone bimbit'), '01234567890')
WebUI.setText(findTestObject('Object Repository/NKM/Butiran Pemohon/input_email'), 'rccsituseonly@gmail.com')
WebUI.click(findTestObject('Object Repository/NKM/Butiran Pemohon/button_simpan'))


//Senarai Orang Tanggungan

WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_kategori tanggungan'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_duda dan anak'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Button_pilih'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Button_tambah OT'))

String maleName = ICGenerator.generateRandomMalaysianManName()
println "Generated Male Malaysian Name: " + maleName

// Get single dynamic IC
String ic = CustomKeywords.'utils.DynamicICGenerator.generateSingleIC'()


WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Input_Name'), maleName)
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_jenis pengenalan'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_kad baru'))
WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Input_no kad pengenalan'), ic)
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_kewarganegaraan'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_malaysia'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_Hubungan'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_duda'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Button_simpan'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_tinggal serumah SRB'),0)
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_tinggal serumah SRB'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_Ya'))
WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Input_no telephone'), '01234567890')
WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Input_no telephone bimbit'), '01234567890')
WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Input_email'), 'rccsituseonly@gmail.com')

WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Input_tarikh berkahwin dgn srb'), '01/05/2015')
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Button_simpan'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Senarai orang tanggungan/select_ada akaun bank'), 0)
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/select_ada akaun bank'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_yes'))

WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Select_akaun bank'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Option_akaun bank'))
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/option_1'))

String accountNumber = ICGenerator.generateRandomBankAccount()
println "Generated Bank Account Number: " + accountNumber

WebUI.setText(findTestObject('Object Repository/NKM/Senarai orang tanggungan/input_no akaun bank'), accountNumber)
WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/button_simpann'))

WebUI.click(findTestObject('Object Repository/NKM/Senarai orang tanggungan/Button_selanjutnya'))

//Butiran FPM
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/Button_Tambah Penuntut'))

WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/Select_pilih pemohon FPM'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/Option_yes'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/button_simpan'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/Select_Senarai tanggungan'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/option_duda'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/button_simpan'))
WebUI.click(findTestObject('Object Repository/NKM/Butiran FPM/Button_selanjutnya'))

//Document sokongan

// Define your local file path
// Wait for the upload field to appear
WebUI.waitForElementPresent(findTestObject('Object Repository/NKM/Document sokongan/input_akaun bank'), 10)

String filePath = "C:/Users/aaror/Downloads/Untitled spreadsheet - Sheet1.csv"

// Use WebUI.uploadFile to upload into the target input field
WebUI.uploadFile(
	findTestObject('Object Repository/NKM/Document sokongan/input_akaun bank'),filePath)
WebUI.uploadFile(
	findTestObject('Object Repository/NKM/Document sokongan/input_borang SR6'),filePath)
WebUI.uploadFile(
	findTestObject('Object Repository/NKM/Document sokongan/input_salinan kad pengenalan'),filePath)
WebUI.uploadFile(
	findTestObject('Object Repository/NKM/Document sokongan/input_sijil kematian'),filePath)

WebUI.click(findTestObject('Object Repository/NKM/button_carian'))

WebUI.click(findTestObject('Object Repository/NKM/Document sokongan/button_selanjutnya'))

//perakuan

WebUI.click(findTestObject('Object Repository/NKM/perakuan/select_pengesahan'))
WebUI.click(findTestObject('Object Repository/NKM/perakuan/Option_ya'))

WebUI.setText(findTestObject('Object Repository/NKM/perakuan/input_tarikh pengesahan lengkap'), '01/07/2025')
WebUI.click(findTestObject('Object Repository/NKM/perakuan/button_serah'))

WebUI.acceptAlert()


String rujukanText = WebUI.getText(findTestObject('Object Repository/NKM/perakuan/div_no rujukan notis'))
GlobalVariable.rujukanNotis = rujukanText

println("No. Rujukan Notis: " + GlobalVariable.rujukanNotis)







