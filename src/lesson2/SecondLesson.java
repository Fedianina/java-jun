package lesson2;

public class SecondLesson {
    public static void main(String[] args) {
        int start = 3, end = 100;
        int res = start > end ? -1 : start;
        System.out.println(res);


        //тернарный оператор

        int sum = 200_000;
        int salle =sum - sum / 10;
        int pay = sum > 100_000 ? salle : sum;
        System.out.println(pay);
    }

}
