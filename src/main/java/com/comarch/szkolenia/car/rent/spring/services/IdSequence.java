package com.comarch.szkolenia.car.rent.spring.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class IdSequence implements IIdSequence {
    private int sequence = 0;

    @Override
    public int getNextId() {
        return ++this.sequence;
    }
}
