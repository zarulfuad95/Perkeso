package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testdata.TestDataFactory
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
import java.time.LocalDate


import internal.GlobalVariable

public class ICGenerator {
	@Keyword
	def static String generateRandomIC() {
		Random random = new Random()

		int year = 1990 + random.nextInt(11)
		String yy = String.format("%02d", year % 100)

		int month = 1 + random.nextInt(12)
		String mm = String.format("%02d", month)

		int day = 1 + random.nextInt(java.time.LocalDate.of(year, month, 1).lengthOfMonth())
		String dd = String.format("%02d", day)

		String pob = String.format("%02d", 1 + random.nextInt(16))
		String serial = String.format("%04d", random.nextInt(10000))

		return yy + mm + dd + pob + serial
	}
	@Keyword
	def static String generateRandomMalaysianWomanName() {
		Random random = new Random()

		String[] prefixes = ["Siti", "Nur", "Aisyah", "Fatimah", "Amirah", "Puteri", "Nurul", "Siti Nur", "Balqis", "Najwa"]
		String[] names = ["Aisyah", "Hafizah", "Amalina", "Syuhada", "Sakinah", "Salsabila", "Farah", "Zulaikha", "Izzah", "Nadia"]
		String[] suffixes = ["Binti Ahmad", "Binti Ali", "Binti Mohd", "Binti Ismail", "Binti Hassan", "Binti Abu Bakar", "Binti Yusof", "Binti Rahman"]

		String prefix = prefixes[random.nextInt(prefixes.length)]
		String name = names[random.nextInt(names.length)]
		String suffix = suffixes[random.nextInt(suffixes.length)]

		return prefix + " " + name + " " + suffix
	}
	@Keyword
	def static String generateRandomIC1() {
		Random random = new Random()

		int year = 1990 + random.nextInt(11) // 1990-2000
		String yy = String.format("%02d", year % 100)

		int month = 1 + random.nextInt(12)
		String mm = String.format("%02d", month)

		int day = 1 + random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth())
		String dd = String.format("%02d", day)

		String pob = String.format("%02d", 1 + random.nextInt(16)) // 01-16
		String serial = String.format("%04d", random.nextInt(10000)) // 0000-9999

		return yy + mm + dd + pob + serial
	}
	@Keyword
	def static String generateRandomMalaysianManName() {
		Random random = new Random()

		String[] prefixes = ["Muhammad", "Ahmad", "Mohd", "Abdul", "Mohamad", "Muhd", "Nur", "Amir", "Syafiq", "Hafiz"]
		String[] names = ["Hafiz", "Faiz", "Imran", "Syahmi", "Hakim", "Farhan", "Irfan", "Amirul", "Ridwan", "Shahrul"]
		String[] suffixes = ["Bin Ahmad", "Bin Ali", "Bin Mohd", "Bin Ismail", "Bin Hassan", "Bin Abu Bakar", "Bin Yusof", "Bin Rahman"]

		String prefix = prefixes[random.nextInt(prefixes.length)]
		String name = names[random.nextInt(names.length)]
		String suffix = suffixes[random.nextInt(suffixes.length)]

		String malaysianManName = prefix + " " + name + " " + suffix

		return malaysianManName
	}
	@Keyword
	def static String generateRandomBankAccount() {
		Random random = new Random()
		StringBuilder accountNumber = new StringBuilder()

		// Ensure the first digit is not zero (to avoid issues in systems that drop leading zeros)
		accountNumber.append(random.nextInt(9) + 1)

		// Generate the remaining 13 digits
		for (int i = 0; i < 13; i++) {
			accountNumber.append(random.nextInt(10))
		}

		return accountNumber.toString()

	}

}