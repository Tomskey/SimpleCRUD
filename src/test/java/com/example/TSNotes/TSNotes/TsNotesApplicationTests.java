package com.example.TSNotes.TSNotes;

import com.example.TSNotes.TSNotes.controller.NoteController;
import com.example.TSNotes.TSNotes.model.dto.EditNoteDto;
import com.example.TSNotes.TSNotes.model.dto.NoteDto;
import com.example.TSNotes.TSNotes.model.entity.NoteEntity;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.example.TSNotes.TSNotes.service.NoteService;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TsNotesApplicationTests {

	@Mock
	private NoteService noteService;

	@InjectMocks
	private NoteController noteController;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
	}

	@Test
	public void getAllNotesTest() throws Exception{
		List<NoteDto> notes = new ArrayList<>();
		notes.add(new NoteDto());
		notes.add(new NoteDto());
		notes.add(new NoteDto());

		when(noteService.findAll()).thenReturn((List) notes);
		mockMvc.perform(get("/api/notes/"))
				.andExpect(status().isOk())
				.andExpect(view().name("/api/notes/"))
				.andExpect(model().attribute("notes",hasSize(3)));
	}


//	@Test
//	public void putNoteTest(EditNoteDto note) throws Exception {
//
//
//	}

}
