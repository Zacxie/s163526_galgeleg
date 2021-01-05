package com.example.s163526_galgeleg;

import java.util.ArrayList;

public interface Logik_Interface {

    ArrayList<String> getBrugteBogstaver();

    String getSynligtOrd();

    String getOrdet();

    int getAntalForkerteBogstaver();

    boolean erSidsteBogstavKorrekt();

    boolean erSpilletVundet();

    boolean erSpilletTabt();

    boolean erSpilletSlut();

    Logik_Interface startNytSpil();

    Logik_Interface indlæsOrd();

    Logik_Interface gætBogstav(String bogstav);

    Logik_Interface logStatus();

    void hentOrdFraRegneark(String s) throws Exception;
}
