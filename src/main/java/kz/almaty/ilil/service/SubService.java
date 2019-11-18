package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.Sub;

public interface SubService {

    Sub addSub(SubDto newSub) throws Exception;
}
