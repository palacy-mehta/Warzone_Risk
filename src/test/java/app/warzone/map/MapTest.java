package app.warzone.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class contains unit tests for the Map class, which represents the game
 * map in Warzone.
 */
public class MapTest {

    private Map d_map;

    @BeforeEach
    void setUp() {
        d_map = new Map("Test Map","Domination");
    }

    /**
     * Test for adding a continent to the map.
     */
    @Test
    void addContinent() {
        Continent l_continent = new Continent(1, "Continent 1", 5);
        d_map.addContinent(l_continent);

        assertTrue(d_map.d_continents.contains(l_continent));
    }

    /**
     * Test for removing a continent from the map by its name.
     */
    @Test
    void removeContinentByName() {
        Continent l_continent = new Continent(1, "Continent 1", 5);
        d_map.addContinent(l_continent);

        d_map.removeContinentByName("Continent 1");

        assertFalse(d_map.d_continents.contains(l_continent));
    }

    /**
     * Test for adding a country to the map.
     */
    @Test
    void addCountry() {
        Continent l_continent = new Continent(1, "Continent 1", 5);
        d_map.addContinent(l_continent);
        Country l_country = new Country(1, "Country 1", l_continent);

        d_map.addCountry(l_country);

        assertTrue(d_map.d_countries.contains(l_country));
    }

    /**
     * Test for removing a country from the map by its name.
     */
    @Test
    void removeCountryByName() {
        Continent l_continent = new Continent(1, "Continent 1", 5);
        d_map.addContinent(l_continent);
        Country l_country = new Country(1, "Country 1", l_continent);
        d_map.addCountry(l_country);

        d_map.removeCountryByName("Country 1");

        assertFalse(d_map.d_countries.contains(l_country));
    }

    /**
     * Test for adding and removing country neighbours by their names.
     */
    @Test
    void addRemoveCountryNeighbourByName() {
        Continent l_continent = new Continent(1, "Continent 1", 5);
        d_map.addContinent(l_continent);
        Country l_country1 = new Country(1, "Country 1", l_continent);
        Country l_country2 = new Country(2, "Country 2", l_continent);
        d_map.addCountry(l_country1);
        d_map.addCountry(l_country2);

        d_map.addRemoveCountryNeighbourByName("Country 1", "Country 2", true);

        assertTrue(l_country1.getNeighbouringCountries().contains(l_country2));
    }
}
