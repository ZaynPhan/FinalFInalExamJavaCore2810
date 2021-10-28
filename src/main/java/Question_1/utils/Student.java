package Question_1.utils;

//Sinh viên
public class Student {
    public int ID;
    public String name;
    public String email;
    public double bonus, report, app, finalPoint;
    public double theory;
    public String rank;

    public Student() {
    }

    public Student(int ID, String name, String email, double bonus, double report, double app, double theory,
                   double finalPoint) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.theory = theory;
        this.finalPoint = finalPoint;
    }

    public static double roundPoint(double value, int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, position);
        value = value * factor;
        long temporary = Math.round(value);
        return (double) temporary / factor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getReport() {
        return report;
    }

    public void setReport(double report) {
        this.report = report;
    }

    public double getApp() {
        return app;
    }

    public void setApp(double app) {
        this.app = app;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getFinalPoint() {
        double fp = this.finalPoint * 0.1 + this.report * 0.3 + this.app * 0.15 + this.theory * 0.45;
        return Student.roundPoint(fp, 2);
    }

    public void setFinalPoint(double finalPoint) {
        this.finalPoint = finalPoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bonus=" + bonus +
                ", report=" + report +
                ", app=" + app +
                ", theory=" + theory +
                ", finalPoint=" + getFinalPoint() +
                '}';
    }
}