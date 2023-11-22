package cibertec.gestionequipo.handler.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse<T> {
    private Integer status;
    private T result;
}
