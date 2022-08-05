package hotel.service;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.repository.BookingRepository;

import java.util.List;

public interface BookingService {
    ResponseDto<BookingDto> addBooking(BookingDto bookingDto);

    ResponseDto updateBooking(BookingDto bookingDto);

    ResponseDto deleteBooking(Integer id);

    ResponseDto<BookingDto> getBookingById(Integer id);

    ResponseDto<List<BookingDto>> getAllBooking();
}
