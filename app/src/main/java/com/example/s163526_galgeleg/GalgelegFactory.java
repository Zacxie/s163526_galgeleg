package com.example.s163526_galgeleg;

public class GalgelegFactory {

    private static GalgelegFactory instance = new GalgelegFactory();

    private GalgelegFactory() {

    }

    public GalgeLogik_Interface getSession(String session) {
        if (session == null) {
            return null;
        }
        switch (session) {
            case "Standard":
                return new GalgeLogik();
            case "dwa":
                return null;
        }
        return null;
    }

    public static GalgelegFactory getInstance() {
        return instance;
    }
}
