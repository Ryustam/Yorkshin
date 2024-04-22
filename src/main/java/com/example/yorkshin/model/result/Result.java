package com.example.yorkshin.model.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Result<T> extends ResultBase{
    private T data;
}
 