package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String s = scanner.nextLine();
        File file = new File(s);
        List<String> list = new ArrayList<>();

        try (Scanner scanner1 = new Scanner(file)) {
            while (scanner1.hasNext()) {
                list.add(scanner1.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(-1);
        }

        int longest = list.get(0).length();
        for (String value : list) {
            if (value.length() > longest) longest = value.length();
        }
        List<String> list2 = new ArrayList<>();

        for (String item : list) {
            list2.add(item + " ".repeat(longest - item.length()));
        }

        for (String value : list2) {
            System.out.print(value + " | ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                if (ch == '<') stringBuilder.append(">");
                else if (ch == '>') stringBuilder.append("<");
                else if (ch == '[') stringBuilder.append("]");
                else if (ch == ']') stringBuilder.append("[");
                else if (ch == '{') stringBuilder.append("}");
                else if (ch == '}') stringBuilder.append("{");
                else if (ch == '(') stringBuilder.append(")");
                else if (ch == ')') stringBuilder.append("(");
                else if (ch == '/') stringBuilder.append("\\");
                else if (ch == '\\') stringBuilder.append("/");
                else stringBuilder.append(ch);
            }
            System.out.println(stringBuilder.reverse());
        }
    }
}