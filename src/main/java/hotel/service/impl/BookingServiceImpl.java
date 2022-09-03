package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.entity.Booking;
import hotel.repository.BookingRepository;
import hotel.service.BookingService;
import hotel.service.mapper.BookingMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public ResponseDto<BookingDto> addBooking(BookingDto bookingDto) {
        Booking booking = BookingMapper.toEntity(bookingDto);
        bookingRepository.save(booking);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",bookingDto);
        return responseDto;
    }

    @Override
    public ResponseDto updateBooking(BookingDto bookingDto) {
        if(bookingRepository.existsById(bookingDto.getId())){
            Booking booking = BookingMapper.toEntity(bookingDto);
            bookingRepository.save(booking);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();
    }

    @Override
    public ResponseDto deleteBooking(Integer id) {
        if (bookingRepository.existsById(id)){
            bookingRepository.deleteById(id);

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        }
        return ResponseDto.builder()
                .code(404)
                .success(false)
                .message("Not found!")
                .build();
    }

    @Override
    public ResponseDto<BookingDto> getBookingById(Integer id) {
        if (bookingRepository.existsById(id)){
            Booking booking = (bookingRepository.findById(id)).get();
            BookingDto bookingDto = BookingMapper.toDto(booking);
            return new ResponseDto<>(200,true,"OK", bookingDto);
        }

        return new ResponseDto<>(404,false,"Not found", null);
    }

    @Override
    public ResponseDto<List<BookingDto>> getAllBooking() {
        List<Booking> bookingList = bookingRepository.findAll();
        List<BookingDto> bookingDtoList = bookingList.stream()
                .map(BookingMapper::toDto).toList();

        ResponseDto<List<BookingDto>> responseDto = new ResponseDto<>(200,true,"OK",
                bookingDtoList);
        return responseDto;
    }
}
