package com.example.artem.streamv;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Helper {
    public static HashMap<String, ArrayList<String>> phrases;

    public Helper(Context ctx) {
        phrases = new HashMap<String, ArrayList<String>>();
        Scanner scanner = new Scanner(ctx.getResources().openRawResource(R.raw.phrases));
        String currentName = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("Streamer:")) {
                currentName = line.split(":")[1];
                phrases.put(currentName, new ArrayList<String>());
            } else {
                phrases.get(currentName).add(line);
            }
        }
    }


}
