package com.example.s163526_galgeleg;

public class Factory {

    private static Factory instance = new Factory();

    private Factory() {

    }

    public Logik_Interface getSession(String session) {
        if (session == null) {
            return null;
        }
        switch (session) {
            case "Standard":
                return new Logik();
            case "":
                return null;
        }
        return null;
    }

    public static Factory getInstance() {
        return instance;
    }
}
