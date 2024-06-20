package tn.esprit.eventsproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.repositories.LogisticsRepository;
import tn.esprit.eventsproject.services.EventServicesImpl;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class LogisticsServiceImplTest {

    @Mock
    LogisticsRepository logisticsRepository;

    @InjectMocks
    EventServicesImpl eventServices;

    @Test
    public void retrieveAllLogisticsTest() {
        when(logisticsRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Logistics(1, "description1", true, 10.0f, 100),
                        new Logistics(2, "description2", false, 20.0f, 200),
                        new Logistics(3, "description3", true, 30.0f, 300)
                )
        );

        assertEquals(3, eventServices.retrieveAllLogistics().size());
    }

    @Test
    public void addLogisticsTest() {
        Logistics logistics = new Logistics(1, "description1", true, 10.0f, 100);
        when(logisticsRepository.save(logistics)).thenReturn(logistics);
        assertEquals(logistics, eventServices.addLogistics(logistics));
    }
    /*
        @Test
        public void retrieveLogisticsTest() {
            Logistics logistics = new Logistics(2, "description2", false, 20.0f, 200);
            when(logisticsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(logistics));
            Logistics retrievedLogistics = eventServices.retrieveLogistics(2);
            assertNotNull(retrievedLogistics);
        }

        @Test
        public void retrieveLogisticsNotFoundTest() {
            when(logisticsRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
            Assertions.assertThrows(NullPointerException.class, () -> {
                eventServices.retrieveLogistics(2);
            });
        }
    */
    @Test
    public void deleteLogisticsTest() {
        eventServices.deleteLogistics(1);
        verify(logisticsRepository).deleteById(1);
    }

    @Test
    public void updateLogisticsTest() {
        Logistics logistics = new Logistics(1, "description1", true, 10.0f, 100);
        when(logisticsRepository.save(Mockito.any(Logistics.class))).thenReturn(logistics);
        logistics.setDescription("updated description");
        Logistics updatedLogistics = eventServices.updateLogistics(logistics);
        assertNotNull(updatedLogistics);
        assertEquals("updated description", updatedLogistics.getDescription());
    }
}
