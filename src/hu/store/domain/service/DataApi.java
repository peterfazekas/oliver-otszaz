package hu.store.domain.service;

import hu.store.domain.model.Cart;

import java.util.List;

public class DataApi {
    private final DataReader dataReader;
    private final DataParser dataParser;

    public DataApi(DataReader dataReader, DataParser dataParser) {
        this.dataReader = dataReader;
        this.dataParser = dataParser;
    }

    public List<Cart> getData(String input) {
        return dataParser.parse(dataReader.read(input));
    }
}
