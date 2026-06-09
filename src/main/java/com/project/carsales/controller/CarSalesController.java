package com.project.carsales.controller;

import com.project.carsales.commons.response.ApiResponse;
import com.project.carsales.dto.MonthlyCountDto;
import com.project.carsales.dto.UploadSalesResponse;
import com.project.carsales.dto.YearlyCountDto;
import com.project.carsales.service.CarSalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/car-sales")
public class CarSalesController {

    private CarSalesService carSalesService;

    public CarSalesController(CarSalesService carSalesService) {
        this.carSalesService = carSalesService;
    }


    @PostMapping("/upload-csv")
    public ResponseEntity<ApiResponse<UploadSalesResponse>> uploadFile(@RequestParam("file") MultipartFile file) {

        // check file is available or not
        if (file.isEmpty()) {
            // generate response
            UploadSalesResponse response = new UploadSalesResponse(0, 0, 0);

            ApiResponse<UploadSalesResponse> apiResponse = new ApiResponse<UploadSalesResponse>(false,
                    "File is Empty",
                    response,
                    HttpStatus.BAD_GATEWAY.value());

            return new ResponseEntity<ApiResponse<UploadSalesResponse>>(apiResponse, HttpStatus.BAD_GATEWAY);
        }
           // res  --> carSalesServiceimp  method impl call
           UploadSalesResponse response =  carSalesService.uploadCsv(file);
           ApiResponse<UploadSalesResponse> apiResponse =  getApiResponse(response);
          // we use sort hand property
        return ResponseEntity.ok(apiResponse);
    }


      private static ApiResponse<UploadSalesResponse> getApiResponse(UploadSalesResponse response) {
        String message;
        boolean success;

        if(response.getFailedCount()==0) {
            message="All records Upload Successfully";
            success=true;
        } else if (response.getSuccessCount()==0) {
            message="All records failed to Upload";
            success=false;
        } else {
            message="Uploaded with some errors";
            success=false;
        }
        // Api Response generated through method
        return new ApiResponse<UploadSalesResponse>(success,message,response,HttpStatus.OK.value());
      }


      @GetMapping("/yearly-count")
      public ResponseEntity<ApiResponse<List<YearlyCountDto>>>  yearlyCount() {

        List<YearlyCountDto> carsCount = carSalesService.getYearlyCarsCount();
        ApiResponse<List<YearlyCountDto>> response = new ApiResponse<List<YearlyCountDto>>(
                true,
                "Data Read SucessFully",
                carsCount,
                HttpStatus.OK.value());

        return ResponseEntity.ok(response);
      }

      @GetMapping("/monthly-count")
      public ResponseEntity<ApiResponse<List<MonthlyCountDto>>> monthlyCount(
              @RequestParam int year) {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Montly data Read successfully",
                        carSalesService.getMonthlyCountByYear(year),
                         HttpStatus.OK.value()
                )
        );

      }
}
