package com.project.carsales.service;

import com.project.carsales.dto.MonthlyCountDto;
import com.project.carsales.dto.UploadSalesResponse;
import com.project.carsales.dto.YearlyCountDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarSalesService {

    UploadSalesResponse uploadCsv(MultipartFile file);

    List<YearlyCountDto> getYearlyCarsCount();

    List<MonthlyCountDto> getMonthlyCountByYear(int year);
}
