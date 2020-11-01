package com.example.s163526_galgeleg;

import java.util.ArrayList;

public interface GalgeLogik_Interface {

    ArrayList<String> getBrugteBogstaver();

    String getSynligtOrd();

    String getOrdet();

    int getAntalForkerteBogstaver();

    boolean erSidsteBogstavKorrekt();

    boolean erSpilletVundet();

    boolean erSpilletTabt();

    boolean erSpilletSlut();

    GalgeLogik startNytSpil();

    GalgeLogik_Interface indlæsOrd();

    GalgeLogik_Interface gætBogstav(String bogstav);

    GalgeLogik_Interface logStatus();



}
