package com.hotel.service;

import com.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getHotels();

    Hotel getHotelById(String id);
}
