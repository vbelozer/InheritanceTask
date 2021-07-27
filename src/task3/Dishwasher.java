package task3;

/*Добавьте эксепшены в программу для обработки некорректного пользования машинкой (например, нельзя добавить посуду, если машина уже запущена) - используйте свои классы для эксепшенов.
В конструктуре входной параметр должен быть больше 0 - используйте стандартный эксепшн, подходящий по назначению.
К методам должны быть добавлены java docs с описанием метода, входных параметров, результата и возможных эксепшенов.
Для статуса используйте enum вместо String.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dishwasher {

    private Status status; // текущий статус машинки

    private final int maxCapacity; // максимальное количество мест в машинке

    private List<Dish> dishes = new ArrayList<>(); // набор посуды

    public Dishwasher(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.maxCapacity = capacity;
        this.status = Status.ON;
    }

    /**
     * A method that gets a list of dishes
     */
    public List<Dish> getDishes() {
        return this.dishes;
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
        if (status != Status.WORKING) {
            throw new InvalidMachineState("Program can not be finished");
        }
        status = Status.FINISHED;
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
        if (status.equals(Status.WORKING)) {
            throw new InvalidMachineState("Dishwasher is working");
        }
        if (dishes.size() == 0) {
            throw new InvalidMachineState("Dishwasher is empty");
        }
        if (status.equals(Status.FINISHED) && dishes.size() != 0) {
            throw new InvalidMachineState("Clean dishes are not removed");
        }
        status = Status.WORKING;
        System.out.println("Dishwasher has started");
    }

    /**
     * A method that allows to stop a dishwasher
     * @throws InvalidMachineState
     *      throws exception if dishwasher is not working, status is OFF or FINISHED
     */
    public void stopDishwasher() {
        Status currentStatus = status;
        if (currentStatus.equals(Status.STOPPED) || currentStatus.equals(Status.OFF) || currentStatus.equals(Status.FINISHED)
                || currentStatus.equals(Status.ON)) {
            throw new InvalidMachineState("Dishwasher is not working");
        }
        status = Status.STOPPED;
        System.out.println("Dishwasher was stopped");
    }

    /**
     * A method that allows to get the clean dishes from a dishwasher
     */
    public List<Dish> getTheDishesFromDishwasher() {
        List<Dish> dishesToGot = dishes;
        dishes = Collections.emptyList();
        System.out.println("Dishwasher is empty. Dishes were get from it.");
        return dishesToGot;
    }

    /**
     * A method that allows to put a dish to a dishwasher
     * @param dish
     * @throws InvalidMachineState
     *      throws in case dishwasher is full, clean dishes are not removed or dishwasher is working
     */
    public void putDishToDishwasher(Dish dish) {
        if (dishes.size() == maxCapacity){
            throw new InvalidMachineState("Dishwasher is full");
        }
        if (status.equals(Status.FINISHED) && dishes.size() != 0) {
            throw new InvalidMachineState("Clean dishes are not removed");
        }
        if (status.equals(Status.WORKING)) {
            throw new InvalidMachineState("Dishwasher is working");
        }
        dishes.add(dish);
        System.out.println("Dish with pattern " + dish.getPattern() + " was put into dishwasher");
    }
}
