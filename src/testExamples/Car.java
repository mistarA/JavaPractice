package testExamples;

public final class Car {
    private  final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class TestExample{
    public static void main(String[] args) {
        Car car = new Car("BMW");
        System.out.print(car.getName());
        String secondCar = car.getName();
        secondCar = "AUDI";
        System.out.print(car.getName());
    }
}