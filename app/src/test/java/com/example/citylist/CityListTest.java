package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private CityList mockCityList2() {
        CityList cityList = new CityList();
        cityList.add(mockCity2());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "AB");
    }
    private City mockCity2() {
        return new City("Dhaka", "CD");
    }

    @Test
    public void testCount(){
        CityList cityList = mockCityList();
        cityList.count();
        assertEquals(1, cityList.getCities(1).size());


    }
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);
        cityList.delete(city);

        assertEquals(1, cityList.getCities(1).size());
        assertTrue(!cityList.getCities(1).contains(city));
    }

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }


    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1=new City("Mohammodpur","Dhaka");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testSort() {
        CityList cityList = new CityList();
        City city=new City("Zalalabad","ZZZ");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));

        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);

        assertEquals(0, city.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0,city1.compareTo(cityList.getCities(2).get(0)));
    }
}
