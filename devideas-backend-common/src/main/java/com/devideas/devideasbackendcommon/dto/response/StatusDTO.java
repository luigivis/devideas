package com.devideas.devideasbackendcommon.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

@Data
public class StatusDTO {

    /** The code. */
    private int code;

    /** The description. */
    private String description;

    /** The http status. */
    @NonNull
    @JsonIgnore
    private HttpStatus httpStatus;

    /**
     * Instantiates a new status DTO.
     *
     * @param httpStatus the http status
     */
    public StatusDTO(HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.description = httpStatus.getReasonPhrase();
        this.httpStatus = httpStatus;
    }

    /**
     * Instantiates a new status DTO.
     *
     * @param code the code
     * @param description the description
     * @param httpStatus the http status
     */
    public StatusDTO(Integer code, String description, @NonNull HttpStatus httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

}
