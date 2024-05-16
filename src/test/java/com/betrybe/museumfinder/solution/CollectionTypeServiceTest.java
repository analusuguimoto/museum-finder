package com.betrybe.museumfinder.solution;
import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Tests for the Collection Type Service")
public class CollectionTypeServiceTest {
    private MuseumFakeDatabase museumDatabase;
    private CollectionTypeService museumService;

    @BeforeEach
    public void setup() {
        museumDatabase = Mockito.mock(MuseumFakeDatabase.class);
        museumService = new CollectionTypeService(museumDatabase);
    }

    @Test
    @DisplayName("Testing the countByCollectionTypes considering only one type")
    public void testCountByCollectionTypes_oneType() {
        String type = "hist";
        when(museumDatabase.countByCollectionType(type)).thenReturn(387L);

        CollectionTypeCount result = museumService.countByCollectionTypes(type);

        assertEquals(1, result.collectionTypes().length);
        assertEquals(type, result.collectionTypes()[0]);
        assertEquals(387, result.count());
    }

    @Test
    @DisplayName("Testing countByCollectionTypes considering more than 1 type")
    public void testCountByCollectionTypes_moreThanOneType() {
        String type1 = "hist";
        String type2 = "arque";
        when(museumDatabase.countByCollectionType(type1)).thenReturn(387L);
        when(museumDatabase.countByCollectionType(type2)).thenReturn(84L);

        CollectionTypeCount result = museumService.countByCollectionTypes(type1 + "," + type2);

        assertEquals(2, result.collectionTypes().length);
        assertEquals(type1, result.collectionTypes()[0]);
        assertEquals(type2, result.collectionTypes()[1]);
        assertEquals(471, result.count());
    }
}

