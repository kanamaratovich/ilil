package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.AttributeFamilyDto;
import kz.almaty.ilil.entity.AttributeFamily;
import kz.almaty.ilil.service.AttributeFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/attributeFamilies")
public class AttributeFamilyRestControllerV1 {

    @Autowired
    private AttributeFamilyService attributeFamilyService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<AttributeFamilyDto> getAllAttributeFamilies(){
        List<AttributeFamily> allAttributeFamilies = attributeFamilyService.getAllAttributeFamilies();

        return allAttributeFamilies.stream().map(attributeFamily -> AttributeFamilyDto.fromAttributeFamily(attributeFamily)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/search/findByCode",method = RequestMethod.GET)
    @ResponseBody
    public AttributeFamilyDto getAttributeFamilyByCode(@RequestParam(name = "code")String code){
        AttributeFamily attributeFamilyByCode = attributeFamilyService.getAttributeFamilyByCode(code);

        return AttributeFamilyDto.fromAttributeFamily(attributeFamilyByCode);
    }

}
