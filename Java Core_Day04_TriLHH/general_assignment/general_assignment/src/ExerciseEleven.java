public class ExerciseEleven {
    String b = "Tri";

    public static void changeNumber(int a) {
        a = 1 + a;
    }

    public static void changeString(ExerciseEleven a) {
        a.b = "Huu " + a.b;

    }

    public static void main(String[] args) {
//        câu 11
//        khi gọi hàm và truyền đối số vào cho hàm
//        by pass value  : nếu đối số là kiểu nguyên thủy sẽ copy giá trị

//        by pass refference : nếu đối số là kiểu đối tượng sẽ copy địa chỉ ô nhớ

//        vd :
        int a = 1;
        System.out.println("Before by pass value is " + a );
        changeNumber(a); // pass value
        System.out.println("After by pass value a is :  " + a);


        ExerciseEleven exerciseEleven = new ExerciseEleven();
        System.out.println("Before by pass refference is " + exerciseEleven.b + " address is " + exerciseEleven);
        changeString(exerciseEleven); //pass refference
        System.out.println("After by pass refference is : " + exerciseEleven.b + " address is " + exerciseEleven);
    }
}
