import java.util.ArrayList;

class Animal {
    protected String id;  // รหัสของสัตว์

    // คอนสตรัคเตอร์สำหรับสร้างสัตว์ด้วยรหัส
    public Animal(String id) {
        this.id = id;
    }

    // รับรหัสของสัตว์
    public String getId() {
        return id;
    }
}

class Cow extends Animal {
    private int ageYears;   // อายุเป็นปี
    private int ageMonths;  // อายุเป็นเดือน
    private int numTeats;   // จำนวนเต้านม

    // คอนสตรัคเตอร์สำหรับสร้างวัวด้วยข้อมูลที่ระบุ
    public Cow(String id, int ageYears, int ageMonths, int numTeats) {
        super(id);
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.numTeats = numTeats;
    }

    // รับอายุเป็นปี
    public int getAgeYears() {
        return ageYears;
    }

    // รับอายุเป็นเดือน
    public int getAgeMonths() {
        return ageMonths;
    }

    // รับจำนวนเต้านม
    public int getNumTeats() {
        return numTeats;
    }

    // ตั้งค่าจำนวนเต้านม
    public void setNumTeats(int numTeats) {
        this.numTeats = numTeats;
    }

    // คำนวณปริมาณน้ำนม (ลิตร)
    public double milkProduction() {
        return ageYears + (ageMonths); // ปริมาณน้ำนมเป็นลิตร
    }

    // ตรวจสอบและปรับจำนวนเต้านม
    public void checkTeatReduction() {
        if (numTeats == 4) {
            // ลดจำนวนเต้านม 1 ต้น มีโอกาส 5%
            if (Math.random() < 0.05) {
                numTeats--;
                System.out.println("หนึ่งเต้าหายไป! จำนวนเต้าปัจจุบัน: " + numTeats);
            }
        } else if (numTeats == 3) {
            // เพิ่มจำนวนเต้านม 1 ต้น มีโอกาส 20%
            if (Math.random() < 0.2) {
                numTeats++;
                System.out.println("เต้านมกลับมา! จำนวนเต้าปัจจุบัน: " + numTeats);
            }
        }
    }
}

class Goat extends Animal {
    // คอนสตรัคเตอร์สำหรับสร้างแพะด้วยรหัส
    public Goat(String id) {
        super(id);
    }
}

class Farm {
    private ArrayList<Animal> animals;  // รายการของสัตว์ในฟาร์ม

    // คอนสตรัคเตอร์สำหรับสร้างฟาร์ม
    public Farm() {
        animals = new ArrayList<>();
    }

    // เพิ่มสัตว์ลงในฟาร์ม
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // ค้นหาสัตว์ตามรหัส
    public Animal findAnimalById(String id) {
        for (Animal animal : animals) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    // ลบสัตว์ตามรหัส
    public void removeAnimal(String id){
        ArrayList<Animal> _animals = new ArrayList<>();

        for (Animal animal : animals) {
            if (!animal.getId().equals(id)) {
                _animals.add(animal);
            }
        }
        this.animals = _animals;
        System.out.println(this.animals.toString());  // แสดงสถานะของฟาร์มหลังลบสัตว์
    }
}
