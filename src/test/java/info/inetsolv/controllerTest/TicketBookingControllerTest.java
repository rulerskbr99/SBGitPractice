package info.inetsolv.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import info.inetsolv.Model.Ticket;
import info.inetsolv.controller.TicketBookingController;
import info.inetsolv.service.TicketBookingService;



@WebMvcTest(value=TicketBookingController.class)
class TicketBookingControllerTest {

	/*
	 * @Autowired MockMvc mockMvc;
	 * 
	 * @Mock TicketBookingService ticketBookingService;
	 * 
	 * @InjectMocks TicketBookingController ticketBookingController;
	 * 
	 * @Mock Ticket tick;
	 * 
	 * @BeforeEach void setUp() throws Exception {
	 * MockitoAnnotations.initMocks(this); tick.setTicketId(1);
	 * tick.setBookingDate(new Date()); tick.setDestStation("goa");
	 * tick.setPassengerName("rakesh"); tick.setEmail("abc@gmail.com");
	 * tick.setSourceStation("HYD"); }
	 * 
	 * @Test void testGetTicketByEmailId() {
	 * when(ticketBookingService.getTicketByEmail(anyString())).thenReturn(tick);
	 * Ticket ticketByEmail =
	 * ticketBookingController.getTicketByEmail("abc@gmail.com");
	 * 
	 * assertEquals(ticketByEmail,tick); }
	 */
		/*
		 * @PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,
		 * produces=MediaType.APPLICATION_JSON_VALUE) public Ticket
		 * createTicket(@RequestBody Ticket ticket){ return
		 * ticketBookingService.createTicket(ticket); }
		 */
	
		/*
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * MockHttpServletResponse response = result.getResponse();
		 * 
		 * String outputInJson = response.getContentAsString();
		 * 
		 * assertThat(outputInJson).isEqualTo(inputInJson);
		 * assertEquals(HttpStatus.OK.value(), response.getStatus());
		 */
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TicketBookingService ticketBookingService;
	
	@Test
	public void testCreateTicket() throws Exception {
		
		Ticket mockTicket = new Ticket();
		mockTicket.setTicketId(1);
		mockTicket.setPassengerName("Martin Bingel");
		mockTicket.setSourceStation("Kolkata");
		mockTicket.setDestStation("Delhi");
		//mockTicket.setBookingDate(new Date());
		mockTicket.setEmail("martin.s2017@gmail.com");
		
		String inputInJson = this.mapToJson(mockTicket);
		
		String URI = "/api/tickets/create";
		
		Mockito.when(ticketBookingService.createTicket(Mockito.any(Ticket.class))).thenReturn(mockTicket);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
		  private String mapToJson(Object object) throws JsonProcessingException {
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.writeValueAsString(object);
			}
		 
	
	

}
