package com.chiang.java.stream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFile {
    public long statisticFileWords(String filePath) {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get(filePath), Charset.defaultCharset())) {
            //uniqueWords = lines.flatMap(line->)
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        StreamFile streamFile = new StreamFile();
    }
}
