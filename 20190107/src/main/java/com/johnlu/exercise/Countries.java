package com.johnlu.exercise;

/**
 * @author lxp
 * @date 2019/10/21 下午3:12
 * @Version 1.0
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import net.mindview.util.Print;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Countries {
    public static final String[][] DATA =
        new String[][] {{"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"}, {"BENIN", "Porto-Novo"},
            {"BOTSWANA", "Gaberone"}, {"BURKINA FASO", "Ouagadougou"}, {"BURUNDI", "Bujumbura"},
            {"CAMEROON", "Yaounde"}, {"CAPE VERDE", "Praia"},
            {"CENTRAL AFRICAN REPUBLIC", "Bangui"}, {"CHAD", "N'djamena"}, {"COMOROS", "Moroni"},
            {"CONGO", "Brazzaville"}, {"DJIBOUTI", "Dijibouti"}, {"EGYPT", "Cairo"},
            {"EQUATORIAL GUINEA", "Malabo"}, {"ERITREA", "Asmara"}, {"ETHIOPIA", "Addis Ababa"},
            {"GABON", "Libreville"}, {"THE GAMBIA", "Banjul"}, {"GHANA", "Accra"},
            {"GUINEA", "Conakry"}, {"BISSAU", "Bissau"},
            {"COTE D'IVOIR (IVORY COAST)", "Yamoussoukro"}, {"KENYA", "Nairobi"},
            {"LESOTHO", "Maseru"}, {"LIBERIA", "Monrovia"}, {"LIBYA", "Tripoli"},
            {"MADAGASCAR", "Antananarivo"}, {"MALAWI", "Lilongwe"}, {"MALI", "Bamako"},
            {"MAURITANIA", "Nouakchott"}, {"MAURITIUS", "Port Louis"}, {"MOROCCO", "Rabat"},
            {"MOZAMBIQUE", "Maputo"}, {"NAMIBIA", "Windhoek"}, {"NIGER", "Niamey"},
            {"NIGERIA", "Abuja"}, {"RWANDA", "Kigali"}, {"SAO TOME E PRINCIPE", "Sao Tome"},
            {"SENEGAL", "Dakar"}, {"SEYCHELLES", "Victoria"}, {"SIERRA LEONE", "Freetown"},
            {"SOMALIA", "Mogadishu"}, {"SOUTH AFRICA", "Pretoria/Cape Town"}, {"SUDAN", "Khartoum"},
            {"SWAZILAND", "Mbabane"}, {"TANZANIA", "Dodoma"}, {"TOGO", "Lome"},
            {"TUNISIA", "Tunis"}, {"UGANDA", "Kampala"},
            {"DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)", "Kinshasa"}, {"ZAMBIA", "Lusaka"},
            {"ZIMBABWE", "Harare"}, {"AFGHANISTAN", "Kabul"}, {"BAHRAIN", "Manama"},
            {"BANGLADESH", "Dhaka"}, {"BHUTAN", "Thimphu"}, {"BRUNEI", "Bandar Seri Begawan"},
            {"CAMBODIA", "Phnom Penh"}, {"CHINA", "Beijing"}, {"CYPRUS", "Nicosia"},
            {"INDIA", "New Delhi"}, {"INDONESIA", "Jakarta"}, {"IRAN", "Tehran"},
            {"IRAQ", "Baghdad"}, {"ISRAEL", "Jerusalem"}, {"JAPAN", "Tokyo"}, {"JORDAN", "Amman"},
            {"KUWAIT", "Kuwait City"}, {"LAOS", "Vientiane"}, {"LEBANON", "Beirut"},
            {"MALAYSIA", "Kuala Lumpur"}, {"THE MALDIVES", "Male"}, {"MONGOLIA", "Ulan Bator"},
            {"MYANMAR (BURMA)", "Rangoon"}, {"NEPAL", "Katmandu"}, {"NORTH KOREA", "P'yongyang"},
            {"OMAN", "Muscat"}, {"PAKISTAN", "Islamabad"}, {"PHILIPPINES", "Manila"},
            {"QATAR", "Doha"}, {"SAUDI ARABIA", "Riyadh"}, {"SINGAPORE", "Singapore"},
            {"SOUTH KOREA", "Seoul"}, {"SRI LANKA", "Colombo"}, {"SYRIA", "Damascus"},
            {"TAIWAN (REPUBLIC OF CHINA)", "Taipei"}, {"THAILAND", "Bangkok"}, {"TURKEY", "Ankara"},
            {"UNITED ARAB EMIRATES", "Abu Dhabi"}, {"VIETNAM", "Hanoi"}, {"YEMEN", "Sana'a"},
            {"AUSTRALIA", "Canberra"}, {"FIJI", "Suva"}, {"KIRIBATI", "Bairiki"},
            {"MARSHALL ISLANDS", "Dalap-Uliga-Darrit"}, {"MICRONESIA", "Palikir"},
            {"NAURU", "Yaren"}, {"NEW ZEALAND", "Wellington"}, {"PALAU", "Koror"},
            {"PAPUA NEW GUINEA", "Port Moresby"}, {"SOLOMON ISLANDS", "Honaira"},
            {"TONGA", "Nuku'alofa"}, {"TUVALU", "Fongafale"}, {"VANUATU", "< Port-Vila"},
            {"WESTERN SAMOA", "Apia"}, {"ARMENIA", "Yerevan"}, {"AZERBAIJAN", "Baku"},
            {"BELARUS (BYELORUSSIA)", "Minsk"}, {"BULGARIA", "Sofia"}, {"GEORGIA", "Tbilisi"},
            {"KAZAKSTAN", "Almaty"}, {"KYRGYZSTAN", "Alma-Ata"}, {"MOLDOVA", "Chisinau"},
            {"RUSSIA", "Moscow"}, {"TAJIKISTAN", "Dushanbe"}, {"TURKMENISTAN", "Ashkabad"},
            {"UKRAINE", "Kyiv"}, {"UZBEKISTAN", "Tashkent"}, {"ALBANIA", "Tirana"},
            {"ANDORRA", "Andorra la Vella"}, {"AUSTRIA", "Vienna"}, {"BELGIUM", "Brussels"},
            {"BOSNIA", "-"}, {"HERZEGOVINA", "Sarajevo"}, {"CROATIA", "Zagreb"},
            {"CZECH REPUBLIC", "Prague"}, {"DENMARK", "Copenhagen"}, {"ESTONIA", "Tallinn"},
            {"FINLAND", "Helsinki"}, {"FRANCE", "Paris"}, {"GERMANY", "Berlin"},
            {"GREECE", "Athens"}, {"HUNGARY", "Budapest"}, {"ICELAND", "Reykjavik"},
            {"IRELAND", "Dublin"}, {"ITALY", "Rome"}, {"LATVIA", "Riga"},
            {"LIECHTENSTEIN", "Vaduz"}, {"LITHUANIA", "Vilnius"}, {"LUXEMBOURG", "Luxembourg"},
            {"MACEDONIA", "Skopje"}, {"MALTA", "Valletta"}, {"MONACO", "Monaco"},
            {"MONTENEGRO", "Podgorica"}, {"THE NETHERLANDS", "Amsterdam"}, {"NORWAY", "Oslo"},
            {"POLAND", "Warsaw"}, {"PORTUGAL", "Lisbon"}, {"ROMANIA", "Bucharest"},
            {"SAN MARINO", "San Marino"}, {"SERBIA", "Belgrade"}, {"SLOVAKIA", "Bratislava"},
            {"SLOVENIA", "Ljuijana"}, {"SPAIN", "Madrid"}, {"SWEDEN", "Stockholm"},
            {"SWITZERLAND", "Berne"}, {"UNITED KINGDOM", "London"}, {"VATICAN CITY", "---"},
            {"ANTIGUA AND BARBUDA", "Saint John's"}, {"BAHAMAS", "Nassau"},
            {"BARBADOS", "Bridgetown"}, {"BELIZE", "Belmopan"}, {"CANADA", "Ottawa"},
            {"COSTA RICA", "San Jose"}, {"CUBA", "Havana"}, {"DOMINICA", "Roseau"},
            {"DOMINICAN REPUBLIC", "Santo Domingo"}, {"EL SALVADOR", "San Salvador"},
            {"GRENADA", "Saint George's"}, {"GUATEMALA", "Guatemala City"},
            {"HAITI", "Port-au-Prince"}, {"HONDURAS", "Tegucigalpa"}, {"JAMAICA", "Kingston"},
            {"MEXICO", "Mexico City"}, {"NICARAGUA", "Managua"}, {"PANAMA", "Panama City"},
            {"ST. KITTS", "-"}, {"NEVIS", "Basseterre"}, {"ST. LUCIA", "Castries"},
            {"ST. VINCENT AND THE GRENADINES", "Kingstown"},
            {"UNITED STATES OF AMERICA", "Washington, D.C."}, {"ARGENTINA", "Buenos Aires"},
            {"BOLIVIA", "Sucre (legal)/La Paz(administrative)"}, {"BRAZIL", "Brasilia"},
            {"CHILE", "Santiago"}, {"COLOMBIA", "Bogota"}, {"ECUADOR", "Quito"},
            {"GUYANA", "Georgetown"}, {"PARAGUAY", "Asuncion"}, {"PERU", "Lima"},
            {"SURINAME", "Paramaribo"}, {"TRINIDAD AND TOBAGO", "Port of Spain"},
            {"URUGUAY", "Montevideo"}, {"VENEZUELA", "Caracas"}};
    //    static Map<String, String> map = new Countries.FlyweightMap((Countries.FlyweightMap)null);
    static Map<String, String> map = new Countries.FlyweightMap();
    static List<String> names;

    static {
        names = new ArrayList(map.keySet());
    }

    public Countries() {
    }

    static Map<String, String> select(final int size) {
        return new Countries.FlyweightMap() {
            @Override public Set<java.util.Map.Entry<String, String>> entrySet() {
                return new Countries.FlyweightMap.EntrySet(size);
            }
        };
    }

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList(select(size).keySet());
    }

    public static void main(String[] args) {
        Print.print(capitals(10));
        Print.print(names(10));
        Print.print(new HashMap(capitals(3)));
        Print.print(new LinkedHashMap(capitals(3)));
        Print.print(new TreeMap(capitals(3)));
        Print.print(new Hashtable(capitals(3)));
        Print.print(new HashSet(names(6)));
        Print.print(new LinkedHashSet(names(6)));
        Print.print(new TreeSet(names(6)));
        Print.print(new ArrayList(names(6)));
        Print.print(new LinkedList(names(6)));
        Print.print(capitals().get("BRAZIL"));
    }

    private static class FlyweightMap extends AbstractMap<String, String> {
        private static Set<java.util.Map.Entry<String, String>> entries;

        static {
            entries = new Countries.FlyweightMap.EntrySet(Countries.DATA.length);
        }

        private FlyweightMap() {
        }

        @Override public Set<java.util.Map.Entry<String, String>> entrySet() {
            return entries;
        }

        private static class Entry implements java.util.Map.Entry<String, String> {
            int index;

            Entry(int index) {
                this.index = index;
            }

            @Override public boolean equals(Object o) {
                return Countries.DATA[this.index][0].equals(o);
            }

            @Override public String getKey() {
                return Countries.DATA[this.index][0];
            }

            @Override public String getValue() {
                return Countries.DATA[this.index][1];
            }

            @Override public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override public int hashCode() {
                return Countries.DATA[this.index][0].hashCode();
            }
        }


        static class EntrySet extends AbstractSet<java.util.Map.Entry<String, String>> {
            private int size;

            EntrySet(int size) {
                if (size < 0) {
                    this.size = 0;
                } else if (size > Countries.DATA.length) {
                    this.size = Countries.DATA.length;
                } else {
                    this.size = size;
                }

            }

            @Override public int size() {
                return this.size;
            }

            @Override public Iterator<java.util.Map.Entry<String, String>> iterator() {
                //                return new Countries.FlyweightMap.EntrySet.Iter((Countries.FlyweightMap.EntrySet.Iter)null);
                return new Countries.FlyweightMap.EntrySet.Iter();
            }

            private class Iter implements Iterator<java.util.Map.Entry<String, String>> {
                private Countries.FlyweightMap.Entry entry;

                private Iter() {
                    this.entry = new Countries.FlyweightMap.Entry(-1);
                }

                @Override public boolean hasNext() {
                    return this.entry.index < EntrySet.this.size - 1;
                }

                @Override public java.util.Map.Entry<String, String> next() {
                    ++this.entry.index;
                    return this.entry;
                }

                @Override public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
        }
    }
}
