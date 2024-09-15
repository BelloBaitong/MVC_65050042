import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        View view = new View();
        Controller controller = new Controller(farm, view);

        // เพิ่มวัวและแพะด้วยข้อมูลที่ระบุ
        farm.addAnimal(new Cow("12345678", 5, 6, 4));  // วัว 1
        farm.addAnimal(new Cow("87654321", 3, 8, 3));  // วัว 2
        farm.addAnimal(new Cow("11112222", 7, 4, 4));  // วัว 3
        farm.addAnimal(new Cow("33334444", 9, 2, 3));  // วัว 4
        farm.addAnimal(new Cow("22223333", 2, 5, 4));  // วัว 5
        farm.addAnimal(new Cow("44445555", 1, 7, 4));  // วัว 6
        farm.addAnimal(new Cow("55556667", 6, 3, 3));  // วัว 7
        farm.addAnimal(new Cow("66667777", 4, 9, 4));  // วัว 8
        farm.addAnimal(new Cow("77778889", 10, 1, 4)); // วัว 9
        farm.addAnimal(new Cow("88889999", 0, 10, 3)); // วัว 10
        farm.addAnimal(new Cow("99990000", 8, 6, 4));  // วัว 11
        farm.addAnimal(new Cow("10101010", 3, 12, 4)); // วัว 12
        farm.addAnimal(new Cow("12121212", 5, 2, 3));  // วัว 13

        // เพิ่มแพะ
        farm.addAnimal(new Goat("55556666"));  // แพะ 1
        farm.addAnimal(new Goat("77778888"));  // แพะ 2

        // ตั้งค่า Listener ให้ปุ่มใน View ทำงานเมื่อผู้ใช้กดปุ่ม
        view.addSubmitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getIdFromUser();
                controller.handleAnimal(id);
            }
        });

        view.addRejectButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getIdFromUser();
                controller.handleGoat(id);
            }
        });
    }
}