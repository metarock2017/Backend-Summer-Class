package org.redrock.ClassInfo.Parcel_8;

import java.util.ArrayList;

/**
 * Created by wang on 2017/8/21.
 */
public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title: titles)
            add(new Position(title));
    }

    public Staff(String... titles) {add(titles);}

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson() == Person.Null)
                return true;
        }

        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this)
            if (position.getTitle().equals(title) && position.getPerson() == Person.Null) {
                position.setPerson(hire);
                return;
            }
        throw new RuntimeException("没有该职位");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("站长", "副站长", "部长");
        staff.fillPosition("站长", new Person("将天星", "陕西"));
        staff.fillPosition("副站长", new Person("严澄", "杭州"));
        System.out.println(staff);
        //可以工作的最简单的事情：设计时，努力做到使用最简单且可以工作的事务，直至程序的某个方面要求你添加额外的特性，而不是
        //一开始就假设他是必需的
    }
}
