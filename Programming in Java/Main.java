// Abstract base class for construction equipment
abstract class ConstructionEquipment {
    String name;
    String manufacturer;

    ConstructionEquipment(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    abstract void displayInfo();
}

// Concrete class for Excavators, inheriting from ConstructionEquipment
class Excavator extends ConstructionEquipment {
    double bucketSize;

    Excavator(String name, String manufacturer, double bucketSize) {
        super(name, manufacturer);
        this.bucketSize = bucketSize;
    }

    void displayInfo() {
        System.out.println("Excavator: " + name + ", Manufacturer: " + manufacturer + ", Bucket Size: " + bucketSize + " cubic meters");
    }
}

// Concrete class for Concrete Mixers, inheriting from ConstructionEquipment
class ConcreteMixer extends ConstructionEquipment {
    double drumCapacity;

    ConcreteMixer(String name, String manufacturer, double drumCapacity) {
        super(name, manufacturer);
        this.drumCapacity = drumCapacity;
    }

    void displayInfo() {
        System.out.println("Concrete Mixer: " + name + ", Manufacturer: " + manufacturer + ", Drum Capacity: " + drumCapacity + " cubic meters");
    }
}

// Final class for Crane, inheriting from ConstructionEquipment
final class Crane extends ConstructionEquipment {
    double liftingCapacity;

    Crane(String name, String manufacturer, double liftingCapacity) {
        super(name, manufacturer);
        this.liftingCapacity = liftingCapacity;
    }

    void displayInfo() {
        System.out.println("Crane: " + name + ", Manufacturer: " + manufacturer + ", Lifting Capacity: " + liftingCapacity + " tons");
    }
}

// Main class should be in a file named Main.java
public class Main {
    public static void main(String[] args) {
        // Instantiate objects of the classes
        Excavator excavator = new Excavator("Model X", "ABC Inc.", 2.5);
        ConcreteMixer concreteMixer = new ConcreteMixer("Mixer 2000", "XYZ Co.", 5.0);
        Crane crane = new Crane("HeavyLift 5000", "PQR Ltd.", 50);

        // Display information about the equipment
        excavator.displayInfo();
        concreteMixer.displayInfo();
        crane.displayInfo();
    }
}
