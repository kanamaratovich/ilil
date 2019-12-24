package kz.almaty.ilil.dto;

import lombok.Data;

@Data
public class CalcInitialValues {
    private Integer N0;
    private Integer Nmax;
    private Integer Nmin;
    private Integer Nstep;
    private Integer D0;
    private Integer Dmax;
    private Integer Dmin;
    private Integer Dstep;
    private Integer Pmax;

    private Long productId;
}
