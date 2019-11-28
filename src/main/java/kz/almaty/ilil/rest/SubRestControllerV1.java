package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.Sub;
import kz.almaty.ilil.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/subs")
public class SubRestControllerV1 {

    @Autowired
    private SubService subService;

    /*@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubDto createNewSub(@Valid @RequestBody SubDto subDto){

        Sub sub = subService.addSub(subDto.toSub());
        return SubDto.fromSub(sub);
    }*/
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<SubDto> getAllSubs(@RequestParam(name = "recommend",required = false) Boolean recommend,
                                   @RequestParam(name = "cityCode",required = false) String cityCode){
        List<Sub> allSubs = subService.getAllSubs(null,recommend,cityCode);

        return allSubs.stream().map(sub -> SubDto.fromSub(sub)).collect(Collectors.toList());
    }

    @RequestMapping(value = "search/findByCategoryId",method = RequestMethod.GET)
    @ResponseBody
    public List<SubDto> findByCategoryId(@RequestParam(name = "categoryId") long categoryId,
                                         @RequestParam(name = "recommend",required = false) Boolean recommend,
                                         @RequestParam(name = "cityCode",required = false) String cityCode){
        List<Sub> allSubs = subService.getAllSubs(categoryId,recommend,cityCode);

        return allSubs.stream().map(sub -> SubDto.fromSub(sub)).collect(Collectors.toList());
    }


}
