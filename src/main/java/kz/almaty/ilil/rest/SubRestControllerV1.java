package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.Sub;
import kz.almaty.ilil.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/subs")
public class SubRestControllerV1 {

    @Autowired
    private SubService subService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<SubDto> getAllSubs(@RequestParam(name = "categoryId",required = false) Long categoryId,
                                         @RequestParam(name = "recommend",required = false) Boolean recommend,
                                         @RequestParam(name = "cityCode",required = false) String cityCode){
        List<Sub> allSubs = subService.getAllSubs(categoryId,recommend,cityCode);

        return allSubs.stream().map(sub -> SubDto.fromSub(sub)).collect(Collectors.toList());
    }


}
