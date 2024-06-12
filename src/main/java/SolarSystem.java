public enum SolarSystem {

    MERCURY(10, 2439),
    VENUS(20, 6052),
    EARTH(30, 6380),
    MARS(40, 3394),
    JUPITER(50, 69911),
    SATURN(60, 60250),
    URANUS(72, 25560),
    NEPTUNE(90, 24765);

    private int radius;
    private int prevDistance;

    public int getRadius() {
        return radius;
    }

    public int getPrevDistance() {
        return prevDistance;
    }

    static SolarSystem[] planets = SolarSystem.values();

    SolarSystem(int prevDistance, int radius) {
        this.prevDistance = prevDistance;
        this.radius = radius;


    }

    public static SolarSystem getNext(SolarSystem p) {
        int index;
        SolarSystem nextPlanet=NEPTUNE;
        for (SolarSystem a : planets) {

            if (p.name().equals(a.name())) {
                index = p.ordinal();
                if (index >= planets.length - 1) {
                    System.out.println("No planets outside Solar System");
                } else {
                    nextPlanet = planets[index + 1];
                }
            }
        } return nextPlanet;
    }

    public static SolarSystem getPrevious(SolarSystem p) {
        int index;
        SolarSystem prevPlanet = null;

        for (SolarSystem a : planets) {

            if (p.name().equals(a.name())) {
                index = p.ordinal();
                if (index == 0) {
                    System.out.println("No planet before this one");

                } else {
                    prevPlanet = planets[index - 1];
                }
            }
        }
        return prevPlanet;

    }

    public static int getDistance(SolarSystem p) {
        int distance;
        if (p.equals(MERCURY)) {
            distance = 0;
        } else {
            SolarSystem prevPlanet = SolarSystem.getPrevious(p);
            distance = p.getPrevDistance() - prevPlanet.getPrevDistance();
        }
        return distance;


    }


}
