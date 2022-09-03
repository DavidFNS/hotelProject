package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ValidatorDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidatorService {
    private List<ValidatorDto> errors = new ArrayList<>();

    public List<ValidatorDto> bookingErrorInfo(BookingDto bookingDto){
        if (bookingDto.getIn_date().after(bookingDto.getOut_date())){
            errors.add(
                    ValidatorDto.builder().fields("in_date").message("in_date must before out_date").build()
            );
        }
        return errors;
    }
}