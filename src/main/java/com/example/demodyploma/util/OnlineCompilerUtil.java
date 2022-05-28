package com.example.demodyploma.util;

import com.example.demodyploma.entity.UserEntity;

import java.io.*;

public class OnlineCompilerUtil {

    private static String tmpFilename = "MainClass";

    public static String getTmpFilename() {
        return tmpFilename;
    }

    public static String compileCode(UserEntity userEntity, String input) {
        return compileCode(input);
    }

    private static String compileCode(String input){
        String path = "src\\main\\resources\\tmp\\";
        try {
            PrintWriter printWriter = new PrintWriter(path + getTmpFilename() + ".java");
            printWriter.println(input);
            printWriter.close();
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error while writing into the file.");
            e.printStackTrace();
        }
        try {
            runProcess("javac " + path + getTmpFilename() + ".java");
            System.out.println("**********");
            return runProcess("java -cp " + path + " " + getTmpFilename() + " "); // TODO add args
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getOutput(InputStream ins) throws Exception {
        String line;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        StringBuilder output = new StringBuilder("");
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            output.append(line);
        }
        return output.toString();
    }

    private static String runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        try {
            getOutput(pro.getInputStream());
            getOutput(pro.getErrorStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
        return getOutput(pro.getInputStream());
    }
}
