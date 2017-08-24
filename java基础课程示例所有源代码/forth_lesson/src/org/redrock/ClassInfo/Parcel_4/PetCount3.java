package org.redrock.ClassInfo.Parcel_4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wang on 2017/8/11.
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }
        public void count(Pet pet) {
            for (Map.Entry<Class, Integer> pair : entrySet()) {
                //动态的instanceof
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (Map.Entry<Class, Integer> pair : entrySet()) {
                sb.append(pair.getKey().getSimpleName());
                sb.append("=");
                sb.append(pair.getValue());
                sb.append(",   ");
            }
            sb.delete(sb.length() - 4, sb.length());
            sb.append("}");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            petCounter.count(pet);
        }

        System.out.println(petCounter);
    }
}
