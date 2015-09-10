package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;

import hello.repository.*;

@Controller
public class AirportController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/ticket")
    public String greeting(
            @RequestParam(value = "from", defaultValue = "Kiev") String from,
            @RequestParam(value = "to", defaultValue = "Paris") String to,
            @RequestParam(value = "fromDate", required = false) LocalDateTime fromDate,
            @RequestParam(value = "toDate", required = false) LocalDateTime toDate,
            Model model){

        flightRepository.findAll().forEach(
                flight -> System.out.println(flight.toString())
        );
        airplaneRepository.findAll().forEach(
                airplane -> System.out.println("--" + airplane.toString())
        );
        ticketRepository.findAll().forEach(
                ticket -> System.out.println(ticket.toString())
        );

        model.addAttribute("flightsFrom", flightRepository.findByFrom(from));
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("flightsFromTo", flightRepository.findFirstByFromAndToAllIgnoreCase(from, to));
        model.addAttribute("airplane", airplaneRepository.findOne(1L));

        return "ticket";
    }

    @RequestMapping("/shedule")
    public String shedule(
            @RequestParam(value = "from", defaultValue = "Kiev") String from,
            @RequestParam(value = "to", defaultValue = "Paris") String to,
            @RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate,
            @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy")Date toDate,
            Model model
    ){
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("flight", flightRepository.findFirstByFromAndToAllIgnoreCase(from, to));
        return "shedule";
    }

}
