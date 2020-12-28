package com.example.demo.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Emerland;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

@RestController
public class SampleController {

	@GetMapping("/sample")
	public String sample() {

		return "sample";
	}

//	@PostMapping("/converter")
//	public String jsonToCSVConverter(@RequestBody String file) throws JsonProcessingException, IOException, ParseException {
//		System.out.println("getting into it ..");
//		 //JSON parser object to parse read file
//		//FileReader reader = new FileReader(file);
//        JSONParser jsonParser = new JSONParser(file);
//		//Read JSON file
//        Object obj = jsonParser.parse();
//
//		System.out.println("obj" + obj);
//		return "";
//	}

	@PostMapping("/converter")
	public String jsonToCSVConverter(@RequestBody String file)
			throws JsonProcessingException, IOException, ParseException {
		System.out.println("getting into it ..");

		Emerland emerland = convertJsonString2Objects(file);
		writeListObjects2CsvFile(Arrays.asList(emerland), "emerland.csv");
		return "";
	}

	private static Emerland convertJsonString2Objects(String jsonString) {
		Emerland emerlandAddress = null;
		try {
			emerlandAddress = new ObjectMapper().readValue(jsonString, new TypeReference<Emerland>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emerlandAddress;
	}
	
	
	private static List<String[]> collectData(List<Emerland> emps) {
		List<String[]> records = new ArrayList<String[]>();

		// adding header record
		records.add(new String[] { "addressEffectiveEndDt", "addressEffectiveStartDt", "addressLine1",
				"addressLine2", "addressLine3", "addressTypeCode", "city", "countryTypeCode", "countyTypeCode",
				"postalCode", "stateTypeCode" });

		Iterator<Emerland> it = emps.iterator();
		while (it.hasNext()) {
			Emerland emerland = it.next();
			records.add(new String[] { String.valueOf(emerland.getAddressEffectiveEndDt()),
					String.valueOf(emerland.getAddressEffectiveStartDt()), emerland.getAddressLine1(), emerland.getAddressLine2(),
					emerland.getAddressLine3(), emerland.getAddressTypeCode(), emerland.getCity(),
					emerland.getCountryTypeCode(), emerland.getCountyTypeCode(), emerland.getPostalCode(),
					emerland.getStateTypeCode() });
		}
		return records;
	}

 	private static void writeListObjects2CsvFile(List<Emerland> emerlands, String pathFile) {
		final String[] CSV_HEADER = { "addressEffectiveEndDt", "addressEffectiveStartDt", "addressLine1",
				"addressLine2", "addressLine3", "addressTypeCode", "city", "countryTypeCode", "countyTypeCode",
				"postalCode", "stateTypeCode" };

		FileWriter fileWriter = null;
		//CSVPrinter csvPrinter = null;
		CSVWriter writer=null;

		try {
			fileWriter = new FileWriter(pathFile);
		    writer = new CSVWriter(fileWriter, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.DEFAULT_LINE_END);
			List<String[]> emerlandsData = collectData(emerlands);
			writer.writeAll(emerlandsData);
			//writer.close();
	   	System.out.println("data :  "+writer);
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			 	writer.close();
			} catch (IOException e) {
				System.out.println("Flushing/closing error!");
				e.printStackTrace();
			}
		}
	}

}
