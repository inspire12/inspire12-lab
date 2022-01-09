package com.inspire12.practice.lab.java8.collector.rank;

//import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rank <T> {
    int rank;
//    @JsonUnwrapped
    T content;
}
