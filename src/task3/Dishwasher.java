package task3;

/*Добавьте эксепшены в программу для обработки некорректного пользования машинкой (например, нельзя добавить посуду, если машина уже запущена) - используйте свои классы для эксепшенов.
В конструктуре входной параметр должен быть больше 0 - используйте стандартный эксепшн, подходящий по назначению.
К методам должны быть добавлены java docs с описанием метода, входных параметров, результата и возможных эксепшенов.
Для статуса используйте enum вместо String.*/

import java.util.ArrayList;

public class Dishwasher {

    private Status status; // текущий статус машинки

    private final int maxCapacity; // максимальное количество мест в машинке

    private int currentCapacity; // занятые места в машинке

    private ArrayList<Dish> dishes = new ArrayList<>(); // набор посуды

    public Dishwasher(int capacity) {
        if (capacity <= 0) {
            throw new IndexOutOfBoundsException();
        }
        this.maxCapacity = capacity;
        this.status = Status.ON;
    }

    /**
     * A method that gets a list of dishes
     */
    public ArrayList<Dish> getDishes() {
        return this.dishes;
    }

    /**
     * A method that sets a list of dishes
     */
    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    /**
     * A method that gets current capacity of dishwasher
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * A method that gets a max capacity of dishwasher
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * A method that gets a status of dishwasher
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * A method that allows to finish program
     * @throws InvalidMachineState
     *      throws exception if dishwasher is not in WORKING state
     */
    public void finishTheProgram() {
        if (this.status != Status.WORKING) {
            throw new InvalidMachineState("Program can not be finished");
        }
        this.status = Status.FINISHED;
        for (Dish dish : this.dishes) {
            dish.setDirty(false);
        }
    }

    /**
     * A method that allows to start a dishwasher
     * @throws InvalidMachineState
     *      throws exception if dishwasher is already working, empty or clean dishes are not removed
     */
    public void startDishwasher() {
        if (this.status.equals(Status.WORKING)) {
            throw new InvalidMachineState("Dishwasher is working");
        }
        if (this.currentCapacity == 0) {
            throw new InvalidMachineState("Dishwasher is empty");
        }
        if (this.status.equals(Status.FINISHED) && this.currentCapacity != 0) {
            throw new InvalidMachineState("Clean dishes are not removed");
        }
        this.status = Status.WORKING;
        System.out.println("Dishwasher has started");
    }

    /**
     * A method that allows to stop a dishwasher
     * @throws InvalidMachineState
     *      throws exception if dishwasher is not working, status is OFF or FINISHED
     */
    public void stopDishwasher() {
        Status currentStatus = this.status;
        if (currentStatus.equals(Status.STOPPED) || currentStatus.equals(Status.OFF) || currentStatus.equals(Status.FINISHED)
                || currentStatus.equals(Status.ON)) {
            throw new InvalidMachineState("Dishwasher is not working");
        }
        this.status = Status.STOPPED;
        System.out.println("Dishwasher was stopped");
    }

    /**
     * A method that allows to get the clean dishes from a dishwasher
     */
    public void getTheDishesFromDishwasher() {
        currentCapacity = 0;
        System.out.println("Dishwasher is empty. Dishes were get from it.");
    }

    /**
     * A method that allows to put a dish to a dishwasher
     * @param dish
     * @throws InvalidMachineState
     *      throws in case dishwasher is full, clean dishes are not removed or dishwasher is working
     */
    public void putDishToDishwasher(Dish dish) {
        if (getCurrentCapacity() == getMaxCapacity()){
            throw new InvalidMachineState("Dishwasher is full");
        }
        if (this.status.equals(Status.FINISHED) && this.currentCapacity != 0) {
            throw new InvalidMachineState("Clean dishes are not removed");
        }
        if (this.status.equals(Status.WORKING)) {
            throw new InvalidMachineState("Dishwasher is working");
        }
        currentCapacity++;
        System.out.println("Dish with pattern " + dish.getPattern() + " was put into dishwasher");
    }
}
