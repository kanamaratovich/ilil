package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.AttributeDto;
import kz.almaty.ilil.entity.Attribute;
import kz.almaty.ilil.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/attributes")
public class AttributeRestControllerV1 {
    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<AttributeDto> getAllAttributes(){
        List<Attribute> attributes = attributeService.getAllAttributes();
        return attributes.stream().map(attribute -> AttributeDto.fromAttribute(attribute)).collect(Collectors.toList());
    }
}
