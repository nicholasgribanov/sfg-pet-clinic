package name.nicholasgribanov.sfgpetclinic.controllers;

import name.nicholasgribanov.sfgpetclinic.model.Pet;
import name.nicholasgribanov.sfgpetclinic.services.PetService;
import name.nicholasgribanov.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    @Mock
    private VisitService visitService;
    @Mock
    private PetService petService;
    MockMvc mockMvc;

    private VisitController visitController;
    String URL;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        visitController = new VisitController(visitService, petService);
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
        URL = "/owners/1/pets/2/visits/new";

        Pet pet = Pet.builder().id(1L).visits(new HashSet<>()).build();
        when(petService.findById(anyLong())).thenReturn(pet);

    }

    @Test
    void initNewForms() throws Exception{
        mockMvc.perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(URL)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("date", "2019-01-01")
        .param("description", "description"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("visit"));
    }
}