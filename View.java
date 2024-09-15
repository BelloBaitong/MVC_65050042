import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class View extends JFrame {
    private JTextField idTextField;
    private JButton submitButton;
    private JButton rejectButton;
    private JTextArea resultTextArea;

    public View() {
        // ตั้งค่าหน้าต่าง JFrame
        setTitle("ระบบตรวจสอบวัวและแพะ");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // เพิ่มป้ายข้อความ "กรุณาใส่รหัส"
        JLabel label = new JLabel("กรุณาใส่รหัสวัวหรือแพะ (8 หลัก):");
        label.setBounds(90, 20, 400, 30);
        add(label);

        // ช่องใส่รหัสวัวหรือแพะ
        idTextField = new JTextField();
        idTextField.setBounds(90, 50, 400, 30);
        add(idTextField);

        // ปุ่ม "ตรวจสอบ"
        submitButton = new JButton("ตรวจสอบ");
        submitButton.setBounds(130, 90, 150, 30);
        add(submitButton);

        // ปุ่ม "ไล่แพะ"
        rejectButton = new JButton("ไล่แพะ");
        rejectButton.setBounds(300, 90, 150, 30);
        add(rejectButton);
        rejectButton.setEnabled(false);

        // ช่องแสดงผลลัพธ์
        resultTextArea = new JTextArea();
        resultTextArea.setBounds(90, 130, 400, 120);
        resultTextArea.setEditable(false);
        add(resultTextArea);

        setVisible(true);
    }

    // รับรหัสที่ผู้ใช้ใส่
    public String getIdFromUser() {
        return idTextField.getText();
    }

    // แสดงข้อความใน TextArea
    public void displayMessage(String message) {
        resultTextArea.setText(message);
    }

    // เพิ่ม Listener ให้กับปุ่ม submit
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    // เพิ่ม Listener ให้กับปุ่ม submit
    public void addRejectButtonListener(ActionListener listener) {
        rejectButton.addActionListener(listener);
    }

    public void enableRejectButton(){
        rejectButton.setEnabled(true);
    }

    public void disableRejectButton(){
        rejectButton.setEnabled(false);
    }
}