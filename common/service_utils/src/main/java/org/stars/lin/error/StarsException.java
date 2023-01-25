package org.stars.lin.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarsException extends RuntimeException {

    private Integer code;

    private String msg;

}
