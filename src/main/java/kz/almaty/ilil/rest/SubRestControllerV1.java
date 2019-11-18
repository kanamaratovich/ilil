package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.Sub;
import kz.almaty.ilil.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/subs")
public class SubRestControllerV1 {

    @Autowired
    private SubService subService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createNewSub(@RequestBody SubDto subDto){
        Sub sub;
        try{
            sub = subService.addSub(subDto);
        }catch (Exception e){
            Map<Object, Object> response = new HashMap<>();
            String[] error = new String[2];
            catchErrorSize = e.getMessage().split(";").length;
            if(e.getMessage().split(";").length<=1){
                error.add("9999");
            }
            response.put("errorMsg",error[0]);
            response.put("errorCode",error[1]);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(SubDto.fromSub(sub), HttpStatus.OK);
    }
}
