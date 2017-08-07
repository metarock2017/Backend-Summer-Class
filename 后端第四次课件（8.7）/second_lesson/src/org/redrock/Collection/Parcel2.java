package org.redrock.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel2 {

    public static void main(String[] args) {
        List<Snow> snow1  = Arrays.asList(
                new Crusty(), new Slush(), new Powder()
        );

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy()
        );

        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        //显式类型参数申明
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy()
        );
    }
}

class Snow {};

 class Powder extends  Snow {};
 class Light extends Snow {};
 class Heavy extends Snow {};
 class Crusty extends Snow {};
 class Slush extends Snow {};
