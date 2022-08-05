package hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseDto<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;

}