package com.perfectdk.davinci.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@AllArgsConstructor
public class DavinciMessage<T> {

    private DavinciCommand command;
    private T data;

}
