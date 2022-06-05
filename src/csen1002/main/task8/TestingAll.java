package csen1002.main.task8;

import csen1002.tests.task8.Task8PublicTest;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestingAll {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("problem_inputs.txt");
        String[] tests_files = new String[] {"test_cases_1_12.txt", "test_cases_13_15.txt",
        "test_cases_16.txt", "test_cases_17.txt", "test_cases_18.txt"};
        for (String filename : tests_files) {
            Scanner sc = new Scanner(new FileInputStream(filename));
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String o = sc.nextLine();
                if (!Task8PublicTest.tokenStream(s).equals(o)) {
                    fw.write(s);
                    fw.write("\n");
                }
            }
            fw.flush();
        }
    }
}
