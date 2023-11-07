public class LABEXE1 {
    // Data members
    public String project_name;
    public String project_location;
    public double project_budget;

    // Default constructor
    public LABEXE1() {
        // Initialize data members
        project_name = "";
        project_location = "";
        project_budget = 0.0;
    }

    // Constructor with overloading
    public LABEXE1(String name, String location, double budget) {
        project_name = name;
        project_location = location;
        project_budget = budget;
    }

    // Method to set project details
    public void setProjectDetails(String name, String location, double budget) {
        project_name = name;
        project_location = location;
        project_budget = budget;
    }

    // Getters for project information
    public String getProjectName() {
        return project_name;
    }

    public String getProjectLocation() {
        return project_location;
    }

    public double getProjectBudget() {
        return project_budget;
    }

    // Method overloading to update project cost by adding additional budget
    public void calculateCost(double additionalBudget) {
        project_budget += additionalBudget;
    }

    // Method overloading to update project cost by considering material and labor
    // costs
    public void calculateCost(double materialCost, double laborCost) {
        project_budget += materialCost + laborCost;
    }

    // Method to print project details
    public void printProjectDetails() {
        System.out.println("Project Name: " + project_name);
        System.out.println("Project Location: " + project_location);
        System.out.println("Project Budget: Rs" + String.format("%.2f", project_budget));
    }

    public static void main(String[] args) {
        // Example usage of the class
        System.out.println("Projects for the month");
        LABEXE1 project1 = new LABEXE1("Super market", "Bangalore", 1000000.0);
        project1.printProjectDetails();
        project1.calculateCost(50000); // Update project cost by adding additional budget
        project1.printProjectDetails();

        LABEXE1 project2 = new LABEXE1();
        project2.setProjectDetails("Cinepolis", "Bangalore", 800000.0);
        project2.calculateCost(60000, 70000); // Update project cost by material and labor costs
        project2.printProjectDetails();
    }
}
