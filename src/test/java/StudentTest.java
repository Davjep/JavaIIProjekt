import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Test för att skapa student")
    public void skapaStudent(){
        Student student = new Student("David", "Jepsson", 29);
        assertEquals("David", student.getFirstName());
        System.out.println(student.getFirstName());
    }

}