package com.devideas.devideasbackendcommon.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponses<Body> {
    private StatusDTO status;

    private Body body;

    public ResponseEntity<GenericResponses<Body>> getResponseHttp(GenericResponses<Body> genericResponse){
        return ResponseEntity.status(genericResponse.getStatus().getHttpStatus()).body(genericResponse);
    }

    public GenericResponses(Body body) {
        this.body = body;
    }
}
