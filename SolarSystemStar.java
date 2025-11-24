public enum SolarSystemStar {
    Sun("Sun", 1.989e30, 696_340, "A G-type main-sequence star at the center of our solar system."),
    Mercury("Mercury", 3.301e23, 2_440, "Smallest planet; no true atmosphere; extreme temperatures."),
    Venus("Venus", 4.867e24, 6_052, "Earth-sized; dense CO2 atmosphere; hottest surface."),
    Earth("Earth", 5.972e24, 6_371, "Our home planet with liquid water and life."),
    Moon("Moon", 7.35e22, 1_737, "Earth's natural satellite; tidally locked."),
    Mars("Mars", 6.417e23, 3_390, "The red planet; thin atmosphere; polar ice caps."),
    Ceres("Ceres (Asteroid)", 9.383e20, 473, "Dwarf planet in the asteroid belt; icy and rocky."),
    Jupiter("Jupiter", 1.898e27, 69_911, "Gas giant; Great Red Spot; strong magnetic field."),
    Saturn("Saturn", 5.683e26, 58_232, "Gas giant with prominent ring system."),
    Uranus("Uranus", 8.681e25, 25_362, "Ice giant; axial tilt ~98°, seasons are extreme."),
    Neptune("Neptune", 1.024e26, 24_622, "Ice giant; strong winds; farthest known planet."),
    Pluto("Pluto", 1.309e22, 1_188, "Dwarf planet in Kuiper belt; eccentric orbit.");


    private final String displayName;
    private final double massKg;
    private final double radiusKm;
    private final String description;


    SolarSystemStar(String displayName, double massKg, double radiusKm, String description) {
        this.displayName = displayName;
        this.massKg = massKg;
        this.radiusKm = radiusKm;
        this.description = description;
    }
    public String getDisplayName() { return displayName; }
    public double getMassKg() { return massKg; }
    public double getRadiusKm() { return radiusKm; }
    public String getDescription() { return description; }
    public String[] toRow(int id) {
        return new String[]{ String.valueOf(id), displayName,
                String.format("%.3e", massKg), String.format("%,.0f", radiusKm) };
    }
}