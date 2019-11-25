package hu.store.domain.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CartWriter {

    private final String fileName;

    public CartWriter(String fileName) {
        this.fileName = fileName;
    }

    public void printAll(List<String> lines) {
        try {
            Files.write(Paths.get(fileName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
