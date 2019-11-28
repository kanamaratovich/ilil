package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.Sub;

import java.util.List;

public interface SubService {

    Sub addSub(Sub newSub);

    List<Sub> getAllSubs(Long categoryId,Boolean recommend,String cityCode);
}
