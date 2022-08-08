package hotel.service.mapper;

import hotel.dto.BookingDto;
import hotel.entity.Booking;
import org.mapstruct.Mapper;

@Mapper
public interface BookingMapper {
    Booking toEntity(BookingDto bookingDto);
    BookingDto toDto(Booking booking);
}