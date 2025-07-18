package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.time.format.DateTimeFormatter
import java.util.Random
import java.time.LocalDate


import internal.GlobalVariable

public class DynamicICGenerator {
	@Keyword
	def String generateSingleIC() {
		LocalDate today = LocalDate.now()
		LocalDate birthDate = today.minusYears(55).plusDays(1) // umur 54y 364d
		String icPrefix = birthDate.format(DateTimeFormatter.ofPattern("yyMMdd"))

		String[] stateCodes = ["01", "02", "08", "12", "14", "10", "05", "09", "07", "03"]
		Random random = new Random()

		String stateCode = stateCodes[random.nextInt(stateCodes.length)]
		String serial = String.format("%04d", random.nextInt(10000))
		String ic = icPrefix + stateCode + serial

		println "Generated Dynamic IC: ${ic}"

		return ic
	}


	@Keyword
	def String getTodayDateInFormat(String format = "dd/MM/yyyy") {
		LocalDate today = LocalDate.now()
		return today.format(DateTimeFormatter.ofPattern(format))
	}
}
