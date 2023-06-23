package com.rating.external;

import com.rating.payload.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotel-id}")
    public Hotel getHotel(@PathVariable("hotel-id") String hotelId);

}
