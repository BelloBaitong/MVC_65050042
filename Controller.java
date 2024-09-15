class Controller {
    private Farm farm;
    private View view;

    public Controller(Farm farm, View view) {
        this.farm = farm;
        this.view = view;
    }
    // เมธอดที่ใช้จัดการสัตว์ตามรหัสที่ให้มา
    public void handleAnimal(String id) {
        // ตรวจสอบความถูกต้องของรหัส
        if (!isValidId(id)) {
            view.displayMessage("รหัสไม่ถูกต้อง! กรุณาใส่รหัสตัวเลข 8 หลักที่ไม่ขึ้นต้นด้วย 0");
            return;
        }
        
        // ค้นหาสัตว์ในฟาร์มตามรหัสที่ให้มา
        Animal animal = farm.findAnimalById(id);
        if (animal == null) {
            view.displayMessage("ไม่พบสัตว์ในระบบ!");
        } else if (animal instanceof Cow) {
            this.view.disableRejectButton();
            handleCow((Cow) animal);
        } else if (animal instanceof Goat) {
            this.view.enableRejectButton();
            view.displayMessage("นี่คือแพะ! ไล่กลับไปที่ภูเขา!");
        }
    }
    // เมธอดที่ใช้จัดการแพะ
    public void handleGoat(String id){
        Animal animal = farm.findAnimalById(id);
        if (animal instanceof Goat) {
            //ไล่ออกจากฟาร์ม
            this.farm.removeAnimal(id);
            StringBuilder message = new StringBuilder();
            message.append("แพะรหัส: ").append(id).append("\n");
            message.append("ถูกส่งกลับภูเขาแล้ว !!");
            view.displayMessage(message.toString());
        }
    }
    // เมธอดที่ใช้จัดการวัว
    private void handleCow(Cow cow) {
        StringBuilder message = new StringBuilder();
        message.append("พบวัวรหัส: ").append(cow.getId()).append("\n");
        message.append("อายุ: ").append(cow.getAgeYears()).append(" ปี ").append(cow.getAgeMonths()).append(" เดือน\n");
        message.append("จำนวนเต้านม: ").append(cow.getNumTeats()).append("\n");

        if (cow.getNumTeats() == 4) {
            message.append("สามารถรีดนมได้!\n");
            message.append("ผลิตน้ำนม: ").append(cow.milkProduction()).append(" ลิตร\n");
            cow.checkTeatReduction();
        } else {
            message.append("จำนวนเต้านมไม่เพียงพอสำหรับรีดนม\n");
            cow.checkTeatReduction();
        }

        view.displayMessage(message.toString());
    }
    // เมธอดตรวจสอบความถูกต้องของรหัส
    private boolean isValidId(String id) {
        if (id.length() != 8 || !id.matches("[1-9][0-9]{7}")) {
            return false;
        }
        return true;
    }
}