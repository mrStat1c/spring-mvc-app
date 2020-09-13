package ru.amelin.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroProvider {

    private static Map<String, String> heroes = new HashMap<String, String>() {{
        put("Soler",
                "Рыцарь из Асторы.\nСтранствует по землям в поисках своего солнца.");
        put("Shao Kahn",
                "Император Внешнего Мира.\nОбладает невиданной силой, но тем не менее постоянно опиздюляется от других более слабых героев.");
        put("Towelie",
                "Просто полотенчик.\nПостоянно пыхает. Не против поделиться с другими.");
        put("Unnamed",
                "Безымянный.\nДаже не гражданин.\n");
        put("Serious Sam",
                "Сэм.\nОчень серьезен. Ненавидит Египет. Постоянный звон в ушах от \"ААААААААААААААА!\"\n");
        put("Farmer",
                "Обычный фермер.\nНе понимает, как он здесь оказался.");
        put("Blood Rayne",
                "Сексуальная Дампир.\nОстрая на язык и не только. Любит делать салат из фашистов и других нехороших субъектов.");
        put("T900",
                "Машина.\nОн обещал вернуться.");
        put("Ameliniv",
                "Неизвестный.\nИнформация отсутствует.");
        put("John Snow",
                "Джон Обмороженные яйца Сноу.\nНичего не знает, но это не помешало ему стать всеобщим героем и любимчиком.");
    }};
    
    public static String getHeroDescription(String name){
        return heroes.get(name);
    }

}
