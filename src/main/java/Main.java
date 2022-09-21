package main.java;

import main.java.util.DirTreeBranch;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final String delimiter = "\\r\\n";
    private static final Character nestingSymbol = '\t';

    private static int level;

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Invalid sequence of args!\nUse: java -jar [jar file] [structure file] [output path].");
        }

        Scanner scanner = createScanner(args[0]);
        DirTreeBranch branch = new DirTreeBranch(args[1]);

        while (scanner.hasNext()) {
            String str = scanner.next();
            if (updateLevel(str)) {
                branch.add(level, str.substring(level));
                createDirectories(branch.toString());
            } else {
                System.err.println("Line '" + str + "' is incorrect and was skipped.");
            }
        }

        scanner.close();
    }

    private static Scanner createScanner(String filename) {
        try {
            return new Scanner(new File(filename), StandardCharsets.UTF_8).useDelimiter(delimiter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createDirectories(String dir) {
        try {
            Files.createDirectory(Path.of(dir));
        } catch (FileAlreadyExistsException e) {
            System.err.println("Directory '" + dir + "' is already exists.");
        } catch (IOException e) {
            System.err.println("Directory '" + dir + "' cannot be created:\n" + e.getMessage());
        }
    }

    private static boolean updateLevel(String str) {
        int newLevel = str.lastIndexOf(nestingSymbol) + 1;
        if (newLevel - level > 1) {
            return false;
        }

        level = newLevel;
        return true;
    }
}