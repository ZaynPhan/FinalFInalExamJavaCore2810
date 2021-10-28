package Question_1;

import Question_1.utils.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static Question_1.ClassX.*;


public class UnitTest_Question_01 {
    @Test
    @DisplayName("Check size list của 10 sinh viên có điểm thi lý thuyết cao nhất")
    void checkSizeListTopTenTheory() throws IOException {
        List<Student> listStudent = readData("data.csv");
        List<Student> listTopTenTheoryPoint = Question_1.ClassX.sortTheoryDesc(listStudent);
        int size = listTopTenTheoryPoint.size();
        Assertions.assertEquals(10, size);
    }

    @Test
    @DisplayName("Check size list của 10 sinh viên có điểm trung bình thấp nhất")
    void checkSizeListWorseTenTheory() throws IOException {
        List<Student> listStudent = readData("data.csv");
        List<Student> listTopTenTheoryPoint = Question_1.ClassX.sortFinalPointAsc(listStudent);
        int size = listTopTenTheoryPoint.size();
        Assertions.assertEquals(10, size);
    }

    
}
