package edu.nyu.cs9053.homework6;
import java.lang.reflect.InvocationTargetException;

public class Technician implements BombSquadTechnician {

    private final Toolbox toolbox;

    public Technician() {
        this.toolbox = new Toolbox();
    }

    @Override
    public void defuse(Bomb bomb, WireDiagram diagram) {

        Wire[] BombWires = bomb.getWires();

        try {
            for (Wire wire : BombWires) {
                WireColor color = (WireColor) this.toolbox.invokeMethod(wire, "getColor");
                if (color == WireColor.Red || color == WireColor.Blue) {
                    wire.cut();
                }
                if (!(wire instanceof Colored)) {
                    throw new IllegalStateException("Tool Misuse");
                }
                if (wire == null) {
                    throw new IllegalArgumentException();
                }
            }
            for (Wire wire : BombWires) {
                Object evil = this.toolbox.invokeMethod(wire,"callingCard");
                if (evil instanceof EvilVillain) {
                    this.toolbox.setField(evil,"free",false);
                }
            }
        }
        catch (Throwable t) {
            throw new AssertionError(t);
        }
    }
    @Override
    public WireDiagram assess(Bomb bomb) {
        this.toolbox.invokeMethod();
        return null;
    }

}







