package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import static com.javatunes.catalog.MusicCategory.*;

public class InMemoryCatalogTest {
    // object under test - "fixture"
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void allPopTitles_shouldReturnPopulatedList_inNaturalOrder() {
        List<String> titles = catalog.allPopTitles();

        assertEquals(4, titles.size());

        titles.sort(null);  // sort by natural order
        assertEquals("Diva", titles.get(0));
        assertEquals("Dream of the Blue Turtles", titles.get(1));
        assertEquals("Seal", titles.get(2));
        assertEquals("So", titles.get(3));
    }

    @Test
    public void itemsAvailableWithCategory_shouldReturnTrue_POP() {
        boolean pop = catalog.itemsAvailableWithCategory(POP);
        assertTrue(pop);
    }

    @Test
    public void itemsAvailableWithCategory_shouldReturnFalse_JAZZ() {
        boolean jazz = catalog.itemsAvailableWithCategory(JAZZ);
        assertFalse(jazz);
    }

    @Test
    public void allItemsAtLeast10_shouldReturnFalse() {  // based on the dataset
        boolean allAtLeast10 = catalog.allItemsAtLeast10();
        assertFalse(allAtLeast10);
    }

    @Test
    public void genreCount_shouldReturnCorrectValue() {
        int count = catalog.genreCount(POP);
        assertEquals(4, count);
    }

    @Test
    public void getRockItemsAtSpecifiedPrice_shouldReturnCollection_rockLessThanEqual() {
        Collection<MusicItem> items = catalog.getRockItemsAtSpecifiedPrice(14.0);

        assertEquals(4, items.size());
        for (MusicItem item : items) {
            assertTrue(item.getPrice() <= 14.0);
            assertTrue(item.getMusicCategory().equals(ROCK) ||
                       item.getMusicCategory().equals(CLASSIC_ROCK));
        }
    }

    @Test
    public void selfTitledAlbums_shouldReturnCollection_titleArtistSame() {
        Collection<MusicItem> items = catalog.selfTitledAlbums();

        assertEquals(2, items.size());
        for (MusicItem item : items) {
            assertEquals(item.getArtist(), item.getTitle());
        }
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(POP);

        assertEquals(4, popItems.size());
        for (MusicItem item : popItems) {
            assertEquals(POP, item.getMusicCategory());
        }
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_idFound() {
        MusicItem item = catalog.findById(6L);
        assertEquals(6L, item.getId().longValue());
    }
}