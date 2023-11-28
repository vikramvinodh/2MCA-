// Interface representing a construction material
interface ConstructionMaterial {
    String getName();
    double getPrice();
}

// Concrete class for a specific construction material - Concrete
class Concrete implements ConstructionMaterial {
    private String name;
    private double pricepcm;

    public Concrete(String name, double pricepcm) {
        this.name = name;
        this.pricepcm = pricepcm;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return pricepcm;
    }
}

// Concrete class for a specific construction material - Steel
class Steel implements ConstructionMaterial {
    private String name;
    private double pricePerKilogram;

    public Steel(String name, double pricePerKilogram) {
        this.name = name;
        this.pricePerKilogram = pricePerKilogram;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return pricePerKilogram;
    }
}

// Main class to test the interfaces and concrete classes
public class ConstructionMaterialTest {
    public static void main(String[] args) {
        ConstructionMaterial concrete = new Concrete("Reinforced Concrete", 120.0);
        ConstructionMaterial steel = new Steel("Structural Steel", 5.0);

        // Display information about construction materials
        displayMaterialInfo(concrete);
        displayMaterialInfo(steel);
    }

    // Helper method to display information about a construction material
    private static void displayMaterialInfo(ConstructionMaterial material) {
        System.out.println("Material: " + material.getName());
        System.out.println("Price: Rs" + material.getPrice() + " per unit");
        System.out.println();
    }
}
