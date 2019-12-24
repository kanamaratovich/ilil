package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Partner;
import lombok.Data;

@Data
public class PartnerDto {
    private String name;
    private String image;

    public static PartnerDto fromPartner(Partner partner){
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setName(partner.getName());
        partnerDto.setImage(partner.getImage());
        return partnerDto;
    }
}
