package coursework;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import coursework.abonements.Abonements;
import coursework.abonements.AbonementsType;


public class FitnessClub {
    // бассейн, тренажерка, групповые занятия;
    //В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонементов.
    //
    //Когда фитнес клуб закрывается, клиенты покидают его (заполнить массив null элементами).
    //
    //Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент. Поэтому перед добавлением в один из массивов, необходимо проверить можно ли по данному абонементу пройти в желаемую зону, если посетитель не может пройти, необходимо сообщить ему причину.
    //
    //Посетитель не может пройти:
    //
    //если абонемент просрочен,
    //если он пытается пройти в зону, которая не разрешена по его абонементу,
    //если в зоне нет свободных мест.
    boolean openClose;

    Abonements[] swimmingPool = new Abonements[20];
    Abonements[] fitnessRoom = new Abonements[20];
    Abonements[] groupClasses = new Abonements[20];
    //String [] purposeOfTheVisit = new String []{"swimming", "fitness", "group"};

    private static boolean isOpenClose() {
        if (LocalTime.now().isBefore(LocalTime.of(7, 59, 59)) && LocalTime.now().isAfter(LocalTime.of(22, 00, 00))) {
            return false;
        }
        return true;
    }


    public static Abonements goingToTheFitnessRoom(){
        if (!isOpenClose()){
            //бряк
        }
        Abonements abonement = Abonements.getAbonement();
        if (abonement.getEndRegistrationDate().isBefore(LocalDate.now())){
            System.out.println("Добрый денью Срок Вашего абонемента истек");
            //как закончить?
        }
        int purposeOfTheVisit = (int) (0 + Math.random() * 3);
        if (purposeOfTheVisit ==1) {
            System.out.println("Добрый день. Вы решили посетить бассейн. Покажите пожалуйста Ваш абонемент");
            if (abonement.getAbonementsType().name() == AbonementsType.DAILY_SUBSCRIPTION.name()) {
                System.out.println("К сожалению, по Вашему абонементу данная услуга не предоставляется");
            }
            else {
                if ()


            }
        }


        }



    }





}
