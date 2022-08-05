package hotel.mapper;

import hotel.dto.BookingDto;
import hotel.entity.Booking;

public class BookingMap {
    public static BookingDto parseToDto(Booking booking){

        return BookingDto.builder()
                .id(booking.getId())
                .id_payment_method(booking.getId_pay_method())
                .room_id(booking.getRoom_id())
                .in_date(booking.getIn_date())
                .out_date(booking.getOut_date())
                .count_junior(booking.getCount_junior())
                .count_senior(booking.getCount_senior())
                .total_price(booking.getTotal_price())
                .created_at(booking.getCreated_at())
                .build();
    }

    public static Booking parseToEntity(BookingDto bookingDto){

        return Booking.builder()
                .id(bookingDto.getId())
                .id_pay_method(bookingDto.getId_payment_method())
                .room_id(bookingDto.getRoom_id())
                .in_date(bookingDto.getIn_date())
                .out_date(bookingDto.getOut_date())
                .count_junior(bookingDto.getCount_junior())
                .count_senior(bookingDto.getCount_senior())
                .total_price(bookingDto.getTotal_price())
                .created_at(bookingDto.getCreated_at())
                .build();
    }
}
