package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public ResponseDto<BookingDto> addBooking(BookingDto bookingDto) {
        return null;
    }

    @Override
    public ResponseDto updateBooking(BookingDto bookingDto) {
        return null;
    }

    @Override
    public ResponseDto deleteBooking(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<BookingDto> getBookingById(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<List<BookingDto>> getAllBooking() {
        return null;
    }
}
