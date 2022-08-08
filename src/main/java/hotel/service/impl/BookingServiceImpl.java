package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.entity.Booking;
import hotel.mapper.BookingMap;
import hotel.repository.BookingRepository;
import hotel.service.BookingService;
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
        Booking booking = BookingMap.parseToEntity(bookingDto);
        bookingRepository.save(booking);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",bookingDto);
        return responseDto;
    }

    @Override
    public ResponseDto updateBooking(BookingDto bookingDto) {
        if(bookingRepository.existsById(bookingDto.getId())){
            Booking booking = BookingMap.parseToEntity(bookingDto);
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
        ResponseDto<BookingDto> responseDto;
        if (bookingRepository.existsById(id)){
            Booking booking = (bookingRepository.findById(id)).get();
            BookingDto bookingDto = BookingMap.parseToDto(booking);

            responseDto = new ResponseDto<>(200,true,"OK",bookingDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(404,false,"Not found", null);

        return responseDto;
    }

    @Override
    public ResponseDto<List<BookingDto>> getAllBooking() {
        List<Booking> bookingList = bookingRepository.findAll();

        List<BookingDto> bookingDtoList = bookingList.stream()
                .map(b -> {
                            return BookingDto.builder()
                                    .id(b.getId())
                                    .id_payment_method(b.getId_pay_method())
                                    .room_id(b.getRoom_id())
                                    .in_date(b.getIn_date())
                                    .out_date(b.getOut_date())
                                    .count_senior(b.getCount_senior())
                                    .count_junior(b.getCount_junior())
                                    .created_at(b.getCreated_at())
                                    .build();
                        }
                ).toList();

        ResponseDto<List<BookingDto>> responseDto = new ResponseDto<>(200,true,"OK",
                bookingDtoList);
        return responseDto;
    }
}
