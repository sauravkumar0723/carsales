package com.project.carsales.service;

import com.project.carsales.dto.MonthlyCountDto;
import com.project.carsales.dto.UploadSalesResponse;
import com.project.carsales.dto.YearlyCountDto;
import com.project.carsales.entity.CarSales;
import com.project.carsales.repository.CarSalesRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarSalesServiceImpl implements CarSalesService {

    private final CarSalesRepository repository;


    public CarSalesServiceImpl(CarSalesRepository repository) {
        this.repository = repository;
    }


    @Override
    public UploadSalesResponse uploadCsv(MultipartFile file) {

        List<CarSales> cars = new ArrayList<>();

        int failCount = 0;
        int totalRecords = 0;

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
//            InputStream inputStream = file.getInputStream(); // raw bytes
//            //converts raw bytes onto character
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//            // we read characters line by line
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            // now we build the  csv Formatting
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader() // header
                    .setSkipHeaderRecord(true) // skip not treated as data
                    .setIgnoreHeaderCase(true) // Case Insensitive
                    .setTrim(true)
                    .build();
            // comple the csv formatting
            // now parse the csv
            CSVParser csvParser = CSVParser.parse(reader, csvFormat);

            for (CSVRecord record : csvParser) {
                String carNumber = record.get("Car Number");

                totalRecords++;
                try {

                    boolean exists = repository.existsByCarNumber(carNumber);

                    if (exists) {
                        failCount++;
                        System.out.println("Duplicate data found" + carNumber);
                        continue;
                    }
                    // if not exist --> we  create a entity of carSales
                    CarSales carSales = new CarSales();
                    // we get the record for csv and set record in the entity
                    carSales.setCarNumber(record.get("Car Number"));

                    carSales.setBrand(record.get("Brand"));
                    carSales.setModel(record.get("Model"));
                    carSales.setColor(record.get("Color"));
                    carSales.setYear(Integer.parseInt(record.get("Year")));
                    carSales.setDateOfPurchase(LocalDate.parse(record.get("Date of Purchase"), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    carSales.setTimeOfPurchase(LocalTime.parse(record.get("Time of purchase")));
                    carSales.setPrice(Long.parseLong(record.get("Price (Rs)")));
                    carSales.setMileage(Double.parseDouble(record.get("Mileage (km/L)")));
                    carSales.setEngine(Integer.parseInt(record.get("Engine (cc)")));
                    carSales.setFuelType(record.get("Fuel Type"));
                    carSales.setPaymentMode(record.get("Payment Mode"));
                    carSales.setState(record.get("State"));
                    carSales.setCity(record.get("City"));
                    carSales.setCustomerName(record.get("Customer Name"));
                    carSales.setContactNumber(record.get("Contact Number"));
                    carSales.setEmail(record.get("Email"));
                    carSales.setWarrantyPeriod(Integer.parseInt(record.get("Warranty Period (years)")));
                    // All data are inserted & put in the list
                    cars.add(carSales);
                }
                catch (Exception e) {
                    failCount++;
                    System.out.println("Fail to process row" + record.getRecordNumber());
                    e.printStackTrace();
                }
            }
            // list of entity ready
            if (!cars.isEmpty()) {
                repository.saveAll(cars);
            }

        } catch (Exception exception) {
            throw new RuntimeException("Unable to Parse CSV: " + exception.getMessage());
        }


        int successCount = totalRecords - failCount;
        return new UploadSalesResponse(totalRecords, successCount,failCount);
    }

    @Override
    public List<YearlyCountDto> getYearlyCarsCount() {
        return repository.getYearlyCount();
    }

    @Override
    public List<MonthlyCountDto> getMonthlyCountByYear(int year) {
        // we call through repository and get list of records
        List<MonthlyCountDto> data = repository.getMonthlyCountByYear(year);
         // put into map
        Map<Integer, Long> map = data.stream()
                .collect(Collectors.toMap(
                        MonthlyCountDto::month,
                        MonthlyCountDto::count
                ));
                // key value pair store
        // create ArrayList
        //with the help of map & put the data in ArrayList
        List<MonthlyCountDto> result = new ArrayList<>();
        // when key missing put own value

        for(int i = 1; i <= 12; i++) {
            result.add(new MonthlyCountDto(
                    i,
                    map.getOrDefault(i,0L)
            ));
        }
        return result;
    }
}
