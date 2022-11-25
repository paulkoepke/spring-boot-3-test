package com.example.sprinb3.converter;

public interface Converter<S, T> {

    T convert(S source);
}
