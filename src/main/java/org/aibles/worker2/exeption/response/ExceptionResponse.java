package org.aibles.worker2.exeption.response;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String error;
    private String message;
    private Instant timeStamp;


}
