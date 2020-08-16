package edu.nyu.cs9053.homework4;

public enum OceanName {

    PACIFIC    (165250000),
    ATLANTIC   (106460000),
    INDIAN     (70560000),
    ARTIC      (14056000),
    SOUTHERN   (2600000);

    private final double area; // in kilometers squared

    OceanName(double area) {
        this.area = area;
    }

    public double getArea() {
    	return area;
    }

    public static void printArea(OceanName ...names) {

        for(OceanName n : names)
            System.out.printf("The Area of %s is %.2f squared kilometers. ", n, n.getArea());
            System.out.println();
    }
}