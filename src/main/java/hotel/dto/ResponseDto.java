package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;
}