package com.example;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("\nEnter string:");
        String string = InputHandler.string();

        System.out.println("\nEnter substring:");
        String substring = InputHandler.string();

        boolean loop = true;
        SubstringSearchStrategy strategy = new Naive();

        Template template = new Template(strategy) {};

        while (loop) {
            menu.show();

            switch (menu.getChoice()) {
                case 1:
                    strategy = new Naive();
                    break;
                case 2:
                    strategy = new KnutaMorrisaPratta();
                    break;
                case 3:
                    strategy = new RabinKarp();
                    break;
                case 4:
                    System.out.println("Enter string:");
                    string = InputHandler.string();
                    continue; // Skip the search to allow re-entering the string
                case 5:
                    System.out.println("Enter substring:");
                    substring = InputHandler.string();
                    continue; // Skip the search to allow re-entering the substring
                case 6:
                    loop = false;
                    continue; // Exit the loop without performing search
            }

            template = new Template(strategy) {};
            if (loop) {
                System.out.println("Result: " + template.isSubstring(string, substring));
            }
        }
    }
}
