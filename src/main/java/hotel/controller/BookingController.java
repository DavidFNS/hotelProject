package hotel.controller;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.service.impl.BookingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/Booking")

public class BookingController {
    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseDto<List<BookingDto>> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping(name = "/{id}")
    public ResponseDto<BookingDto> getBookingById(@PathVariable Integer id){
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public ResponseDto<BookingDto> addBooking(@RequestBody BookingDto bookingDto){
        return bookingService.addBooking(bookingDto);
    }

    @PutMapping
    public ResponseDto updateBooking(@RequestBody BookingDto bookingDto){
        return bookingService.updateBooking(bookingDto);
    }

    @DeleteMapping(name = "/{id}")
    public ResponseDto deleteBooking(@PathVariable Integer id){
        return bookingService.deleteBooking(id);
    }
}
