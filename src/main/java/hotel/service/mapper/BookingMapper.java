package hotel.service.mapper;

import hotel.dto.BookingDto;
import hotel.entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class BookingMapper {

    public static Booking toEntity(BookingDto bookingDto){
        if (bookingDto == null){
            return null;
        }

        return Booking.builder()
                .id(bookingDto.getId())
                .room(RoomsMapper.toEntity(bookingDto.getRoom()))
                .user(UsersMapper.toEntity(bookingDto.getUser()))
                .count_junior(bookingDto.getCount_junior())
                .count_senior(bookingDto.getCount_senior())
                .in_date(bookingDto.getIn_date())
                .out_date(bookingDto.getOut_date())
                .total_price(bookingDto.getTotal_price())
                .paymentMethod(PaymentMethodMapper.toEntity(bookingDto.getPaymentMethod()))
                .created_at(bookingDto.getCreated_at())
                .build();
    }

    public static BookingDto toDto(Booking booking){
        if (booking == null){
            return null;
        }

        return BookingDto.builder()
                .id(booking.getId())
                .room(RoomsMapper.toDto(booking.getRoom()))
                .user(UsersMapper.toDto(booking.getUser()))
                .count_junior(booking.getCount_junior())
                .count_senior(booking.getCount_senior())
                .in_date(booking.getIn_date())
                .out_date(booking.getOut_date())
                .total_price(booking.getTotal_price())
                .paymentMethod(PaymentMethodMapper.toDto(booking.getPaymentMethod()))
                .created_at(booking.getCreated_at())
                .build();
    }
}
