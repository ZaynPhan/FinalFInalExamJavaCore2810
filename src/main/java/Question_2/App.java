package Question_2;
/*
Câu II
1. Cho biết chuỗi regular-expression để capture được các địa chỉ gmail và
outlook
2. Xây dựng hàm liệt kê thông tin các sinh viên có email là gmail
3. Chuyển thông tin các sinh viên có email là outlook (II.2) vào tập
tin outlook.bin, sử dụng kỹ thuật Serialization.
4. Xây dựng hàm đọc thông tin các sinh viên ở II.3 lên màn hình console
 */

import Question_1.ClassX;
import Question_1.utils.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App extends ClassX {
    public static void main(String[] args) throws IOException {
        List<Student> listStudent = readData("data.csv");

        Pattern patternGmail = Pattern.compile("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@(gmail|outlook)." +
                "[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");
        List<Student> listStudentGMail = getStudentGmail(listStudent, patternGmail);
        System.out.println(listStudentGMail);

        Pattern patternOutlook = Pattern.compile("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@(gmail|outlook)." +
                "[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");
        List<Student> listStudentOutlook = getStudentGmail(listStudent, patternOutlook);
        System.out.println(listStudentOutlook);
        try {
            FileOutputStream fos = new FileOutputStream("outlook.bin");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            for (Student student : listStudentOutlook) {
                dos.writeInt(student.getID());
                dos.writeUTF(student.getName());
                dos.writeUTF(student.getEmail());
                dos.writeDouble(student.getBonus());
                dos.writeDouble(student.getReport());
                dos.writeDouble(student.getApp());
                dos.writeDouble(student.getTheory());
            }
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("outlook.bin");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                int ID = dis.readInt();
                String name = dis.readUTF();
                String email = dis.readUTF();
                double bonus = dis.readDouble();
                double report = dis.readDouble();
                double app = dis.readDouble();
                double theory = dis.readDouble();
                double finalPoint = dis.readDouble();
                Student listStudentOutlook1 = new Student(ID, name, email, bonus, report, app, theory, finalPoint);
                System.out.println(listStudentOutlook1);
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getStudentGmail(List<Student> listStudent, Pattern pattern) {
        List<Student> results = new ArrayList<>();
        int n = listStudent.size();
        for (int i = 0; i < listStudent.size(); i++) {
            Matcher matcher = pattern.matcher(listStudent.get(i).getEmail());
            if (matcher.find()) {
                results.add(listStudent.get(i));
            }
        }
        return results;
    }
}
