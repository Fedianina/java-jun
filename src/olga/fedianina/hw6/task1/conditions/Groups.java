package olga.fedianina.hw6.task1.conditions;

import java.util.Arrays;

public class Groups {
    //Группа для восхождения на гору создаётся со следующими характеристиками и возможностями:
    //идёт набор в группу или нет;
    //массив альпинистов;
    //гора;
    //должна быть возможность добавить альпиниста в группу, если набор ещё идёт

    private boolean recruitment;
    private Alpenist[] alpenists;
    private Mountain mountain;
    private int number = 0;


    public boolean isRecruitment() {
        return recruitment;
    }

    public Alpenist[] getAlpenists() {
        return alpenists;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setRecruitment(boolean recruitment) {
        this.recruitment = recruitment;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public Groups(int numAlpenists) {
        if (0 < numAlpenists)
            alpenists = new Alpenist[numAlpenists];
        else throw new IllegalArgumentException("Группа должна содержать хотя бы 1 альпениста");
        recruitment = true;
    }

    public void plusAlpenist(Alpenist alpenist) {
        if (recruitment == true) {
            if (number < alpenists.length) {
                alpenists[number] = alpenist;
                ++number;
            } else {
                recruitment = false;
                System.out.println("Группа набрана");
            }
        }
    }

    @Override
    public String toString() {
        return "Groups{" +
                "recruitment=" + recruitment +
                ", alpenists=" + Arrays.toString(alpenists) +
                ", mountain=" + mountain +
                ", number=" + number +
                '}';
    }
}
