package edu.nyu.cs9053.homework6;

/**
 * User: blangel
 * Date: 10/11/17
 * Time: 8:03 AM
 */
public class BombSquadTechnicianRecruiter extends Toolbox {

    private static final BombSquadTechnician TECHNICIAN = new Technician();

    public static BombSquadTechnician recruit() {
        return TECHNICIAN;
    }

}
