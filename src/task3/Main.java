package task3;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        checkValidWorkflow();
        //checkInvalidCapacity();
    }

    public static void checkValidWorkflow() {
        Dishwasher myDishWasher = new Dishwasher(10);

        System.out.println("Dishwasher status is " + myDishWasher.getStatus());

        try {
            myDishWasher.putDishToDishwasher(new Dish());
        } catch (InvalidMachineState e) {
                System.out.println("Can not put a dish to dishwasher");
            }

        System.out.println("List of dishes before: " + myDishWasher.getDishes().toString());

        //start dishwasher
        try {
            myDishWasher.startDishwasher();
        } catch (InvalidMachineState e) {
            System.out.println("Dishwasher can not be started");
        }
        System.out.println("Dishwasher status is " + myDishWasher.getStatus());

        //stop dishwasher
        try {
            myDishWasher.stopDishwasher();
        } catch (InvalidMachineState e) {
            System.out.println("Dishwasher can not be stopped.");
        }

        System.out.println("Dishwasher status is " + myDishWasher.getStatus());
        //start dishwasher again
        myDishWasher.startDishwasher();
        System.out.println("Dishwasher status is " + myDishWasher.getStatus());

        System.out.println("Wait 30 min");

        System.out.println("Finish the program");
        myDishWasher.finishTheProgram();

        // get dishes
        System.out.println("Get dishes");
        List<Dish> dishesFromDishwasher = myDishWasher.getTheDishesFromDishwasher();
        System.out.println("Dishwasher status is " + myDishWasher.getStatus());

        System.out.println("List of dishes after: " + dishesFromDishwasher.toString());
    }

    public static void checkInvalidCapacity() {
        Dishwasher myDishWasher = new Dishwasher(-5);
    }
}
