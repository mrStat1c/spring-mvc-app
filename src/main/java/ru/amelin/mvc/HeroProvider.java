package ru.amelin.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroProvider {

    private static Map<String, String> heroes = new HashMap<String, String>() {{
        put("Soler",
                "������ �� ������.\n����������� �� ������ � ������� ������ ������.");
        put("Shao Kahn",
                "��������� �������� ����.\n�������� ���������� �����, �� ��� �� ����� ��������� ������������ �� ������ ����� ������ ������.");
        put("Towelie",
                "������ ����������.\n��������� ������. �� ������ ���������� � �������.");
        put("Unnamed",
                "����������.\n���� �� ���������.\n");
        put("Serious Sam",
                "���.\n����� ��������. ��������� ������. ���������� ���� � ���� �� \"���������������!\"\n");
        put("Farmer",
                "������� ������.\n�� ��������, ��� �� ����� ��������.");
        put("Blood Rayne",
                "����������� ������.\n������ �� ���� � �� ������. ����� ������ ����� �� �������� � ������ ��������� ���������.");
        put("T900",
                "������.\n�� ������ ���������.");
        put("Ameliniv",
                "�����������.\n���������� �����������.");
        put("John Snow",
                "���� ������������ ���� ����.\n������ �� �����, �� ��� �� �������� ��� ����� �������� ������ � ����������.");
    }};
    
    public static String getHeroDescription(String name){
        return heroes.get(name);
    }

}
