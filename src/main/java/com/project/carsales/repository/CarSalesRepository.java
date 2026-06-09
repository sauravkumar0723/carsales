package com.project.carsales.repository;

import com.project.carsales.dto.MonthlyCountDto;
import com.project.carsales.dto.YearlyCountDto;
import com.project.carsales.entity.CarSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarSalesRepository extends JpaRepository<CarSales, Long> {

    boolean existsByCarNumber(String carNumber);

    @Query("""
             Select new com.project.carsales.dto.YearlyCountDto(c.year,count(c))
                          from CarSales c 
                                       Group by c.year
                                                    Order by c.year
                                                     """)
    List<YearlyCountDto> getYearlyCount();


    // Data read and immediately goes to record
    @Query("""
      Select new com.project.carsales.dto.MonthlyCountDto(
      MONTH(c.dateOfPurchase), COUNT(c)
      )
      From CarSales  c
      WHERE YEAR(c.dateOfPurchase) = :year
      GROUP BY MONTH(c.dateOfPurchase)
      ORDER BY MONTH(c.dateOfPurchase)
      """)

    List<MonthlyCountDto> getMonthlyCountByYear(@Param("year") int year);

}
