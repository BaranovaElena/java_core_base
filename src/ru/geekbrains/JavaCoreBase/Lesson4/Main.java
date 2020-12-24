package ru.geekbrains.JavaCoreBase.Lesson4;

public class Main {
    public static void main(String[] args) {

        int counter = 0;    //task7 уникальный порядковый номер

        //task4
        Employee man1 = new Employee(
                "Иванов Иван Иванович",
                "бухгалтер",
                "89991112233",
                50000,
                30, ++counter);
        System.out.println(man1.getFullName()+" - "+man1.getPosition());
        System.out.println();

        //task5
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(
                "Абрамов Антон Павлович",
                "инженер",
                "89123456789",
                50000,
                25, ++counter);
        employees[1] = new Employee(
                "Бондаренко Илья Ильич",
                "Начальник отдела",
                "89992223311",
                80000,
                40, ++counter);
        employees[2] = new Employee(
                "Васильев Николай Петрович",
                "программист",
                "89117655665",
                70000,
                30, ++counter);
        employees[3] = new Employee(
                "Галкина Людмила Павловна",
                "бухгалтер",
                "89109998877",
                55000,
                55, ++counter);
        employees[4] = new Employee(
                "Диденко Лариса Михайловна",
                "начальник отдела кадров",
                "89200001111",
                60000,
                45, ++counter);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee.getId() +"\t"+
                        employee.getFullName() +" - "+
                        employee.getPosition() +" ("+
                        employee.getPhoneNumber() +")\n\tвозраст "+
                        employee.getAge() +" лет, зарплата "+
                        employee.getSalary()
                );
            }
        }
        System.out.println();

        //task6
        for (Employee employee : employees) {
            if (employee.getAge() > 35) {
                System.out.print(employee.getId() +"\t"+
                        employee.getFullName()+" ("+
                        employee.getAge()+" лет): увеличение зп с "+
                        employee.getSalary());
                employee.increaseSalary(10000);
                System.out.println(" до "+employee.getSalary());
            }
        }
    }
}
