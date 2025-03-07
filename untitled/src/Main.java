
import com.student.manage.Student;
import com.student.manage.StudentDAO;
import java.sql.Timestamp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Press 1 to Add student");
            System.out.println("Press 2 to Delete student");
            System.out.println("Press 3 to Display student");
            System.out.println("Press 4 to exit");
            int choice = Integer.parseInt(br.readLine());
            if(choice == 1){
                System.out.println("Enter student first name:");
                String firstName = br.readLine();

                System.out.println("Enter student last name:");
                String lastName = br.readLine();

                System.out.println("Enter student email:");
                String email = br.readLine();

                System.out.println("Enter student gender (Male/Female/Other):");
                String gender = br.readLine();

                System.out.println("Enter student phone number:");
                String phoneNumber = br.readLine();

                System.out.println("Enter student address:");
                String address = br.readLine();

                Timestamp enrollmentDate = new Timestamp(System.currentTimeMillis());

                Student st = new Student(firstName, lastName, email, gender, phoneNumber, address, enrollmentDate);
                boolean answer = StudentDAO.insertStudentToDB(st);
                if(answer){
                    System.out.println("Student added successfully");
                }
                else{
                    System.out.println("Student not added successfully");
                }
            }
            else if(choice == 2){
                System.out.println("Enter student id:");
                int id = Integer.parseInt(br.readLine());
                boolean flag = StudentDAO.deleteStudent(id);
            }
            else if(choice == 3){
                System.out.println("Enter student id:");
                int id = Integer.parseInt(br.readLine());
                boolean flag = StudentDAO.displayStudent(id);
            }
            else if(choice == 4){
                break;
            }
            else{
                throw new IOException("Invalid choice");
            }
        }

    }
    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
            return null;
        }
    }
}