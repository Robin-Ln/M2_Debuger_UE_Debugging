package fr.louarn.debugging.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MethodesUtilsTest {

    private File file;

    @BeforeEach
    void init(){

        String fileName = new Exception().getStackTrace()[0].getFileName();
        File file = new File(System.getProperty("user.dir"));
        String path = "";
        MethodesUtils.listeRepertoire(file, fileName);
        System.out.println(path);
        this.file = new File(path);
        if (!file.exists()) {
            fail("La resource " + path + " n'est pas disponible");
        }
    }

    @Test
    void getFileLine() {
        Map<Integer,String> map = MethodesUtils.getFileLine(this.file,0,1);
    }
}
