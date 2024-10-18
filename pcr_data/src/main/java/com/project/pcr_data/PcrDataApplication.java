package com.project.pcr_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//import au.com.bytecode.opencsv.CSVReader;

@SpringBootApplication
public class PcrDataApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PcrDataApplication.class, args);

		String url = "jdbc:mysql://localhost:3306/transport";
		String user = "root";
		String password = "Qwerty@2024";
		String filePath="src/main/resources/Deepika_pcr_data.xlsx";

		String createTable = "CREATE TABLE pcr_data (" +
				"    ETC_ACCOUNT_ID DECIMAL(22, 7)," +
				"    AMT_CHARGED DECIMAL(22, 7)," +
				"    PCR_ID INT," +
				"    PCR_TS TIMESTAMP(3)," +
				"    LANE_TX_ID DECIMAL(22, 0)," +
				"    UFM_ID VARCHAR(50)," +
				"    PCR_STATUS VARCHAR(30)," +
				"    PCR_STATUS_TS TIMESTAMP(3)," +
				"    ENFORCEMENT_PROVIDER VARCHAR(10)," +
				"    PCR_TYPE VARCHAR(10)," +
				"    PCR_GEN_RES_CODE VARCHAR(100)," +
				"    UPDATE_TS TIMESTAMP(3)," +
				"    ACK_ID INT," +
				"    ACK_STATUS_TS TIMESTAMP(3)," +
				"    ACK_STATUS VARCHAR(10)," +
				"    HTTP_CODE VARCHAR(2000)," +
				"    ERROR_CODE VARCHAR(2000)," +
				"    ERROR_DESC VARCHAR(2000)," +
				"    PCR_REASON VARCHAR(1000)," +
				"    PCR_NAME VARCHAR(400)," +
				"    PCR_ADDRESS VARCHAR(400)," +
				"    ISO_COUNTRY VARCHAR(30)," +
				"    PLATE_COUNTRY VARCHAR(8)," +
				"    PLATE_NUMBER VARCHAR(10)" +
				");";

		try (Connection connection = DriverManager.getConnection(url, user, password);
			 Statement statement = connection.createStatement()) {
			statement.executeUpdate(createTable);
			System.out.println("Table created successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String insertSQL = "INSERT INTO pcr_data (ETC_ACCOUNT_ID, AMT_CHARGED, PCR_ID, PCR_TS, " +
				"LANE_TX_ID, UFM_ID, PCR_STATUS, PCR_STATUS_TS, ENFORCEMENT_PROVIDER, PCR_TYPE, " +
				"PCR_GEN_RES_CODE, UPDATE_TS, ACK_ID, ACK_STATUS_TS, ACK_STATUS, HTTP_CODE, " +
				"ERROR_CODE, ERROR_DESC, PCR_REASON, PCR_NAME, PCR_ADDRESS, ISO_COUNTRY, " +
				"PLATE_COUNTRY, PLATE_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, user, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

			try (Reader reader = new FileReader(filePath);
				 CSVReader csvReader = new CSVReader(reader)) {

				String[] nextLine;
				while ((nextLine = csvReader.readNext()) != null) {
					for (int i = 0; i < 110; i++) {
						preparedStatement.setObject(i + 1, nextLine[i]);
					}
					preparedStatement.addBatch();
				}
				preparedStatement.executeBatch();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}


	}
}