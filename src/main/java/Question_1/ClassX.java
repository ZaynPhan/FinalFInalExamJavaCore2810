package Question_1;

import Question_1.utils.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassX {
    public static void main(String[] args) throws IOException {

        //1. Đọc danh sách sinh viên từ tập tin data.csv được cung cấp
        System.out.println("1. Read student list from csv file");
        List<Student> listStudent = readData("data.csv");

        //2. Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết cao nhất
        System.out.println("2. Top 10 students that have highest Theory points");
        List<Student> listTopTenLT = sortTheoryDesc(listStudent);
        for (Student student : listTopTenLT) {
            System.out.println(student);
        }

        //3. Tính điểm tổng kết cho từng sinh viên theo công thức: bonus 10%,
        //report 30%, app 15%, lý thuyết 45%; điểm tổng kết được làm tròn đến
        //0.5 (ví dụ: 7.37 -> 7.5, 6.2 -> 6.0)
        System.out.println("3. Calculate final points for all list students");
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i));
        }

        //4. Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất lên giao diện
        //console
        System.out.println("4. Top 10 students that has the lowest final points");
        sortFinalPointAsc(listStudent);
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i));
        }

        //5.
        try {
            FileOutputStream fos = new FileOutputStream("output.csv");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            for (Student sv : listStudent) {
                dos.writeInt(sv.getID());
                dos.writeUTF(sv.getName());
                dos.writeUTF(sv.getEmail());
                dos.writeDouble(sv.getBonus());
                dos.writeDouble(sv.getReport());
                dos.writeDouble(sv.getApp());
                dos.writeDouble(sv.getTheory());
            }
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //6. Hiển thị bảng thống kê tình hình lớp, gồm các thông tin như trong
        //bảng bên dưới
        //Em làm không kịp ạ

    }

    public static List<Student> readData(String filePath) throws IOException {
        List<Student> result = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            //Skip header
            if (line.contains("ID,Name,Email,Bonus,Report,App,Theory"))
                continue;
            else {
                List<String> data = Arrays.asList(line.split(","));
                Student student = new Student();
                student.setID(Integer.parseInt(data.get(0)));
                student.setName(data.get(1));
                student.setEmail(data.get(2));
                student.setBonus(Float.parseFloat(data.get(3)));
                student.setReport(Float.parseFloat(data.get(4)));
                student.setApp(Float.parseFloat(data.get(5)));
                student.setTheory(Float.parseFloat(data.get(6)));
                result.add(student);
            }
        }
        return result;
    }

    public static List<Student> sortTheoryDesc(List<Student> listStudent) {
        List<Student> listTopTenTheory = new ArrayList<>();
        int n = listStudent.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (listStudent.get(j - 1).getTheory() < listStudent.get(j).getTheory()) {
                    temp = listStudent.get(j - 1);
                    listStudent.set(j - 1, listStudent.get(j));
                    listStudent.set(j, temp);
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            listTopTenTheory.add(listStudent.get(i));
        }
        return listTopTenTheory;
    }

    public static List<Student> sortFinalPointAsc(List<Student> listStudent) {
        List<Student> listTopTenFinalPoint = new ArrayList<>();
        int n = listStudent.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (listStudent.get(j - 1).getFinalPoint() > listStudent.get(j).getFinalPoint()) {
                    temp = listStudent.get(j - 1);
                    listStudent.set(j - 1, listStudent.get(j));
                    listStudent.set(j, temp);
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            listTopTenFinalPoint.add(listStudent.get(i));
        }
        return listTopTenFinalPoint;


    }
}

