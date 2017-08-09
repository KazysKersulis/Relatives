package relatives.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relatives.model.Relative;
import relatives.service.RelativeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
public class SampleRestController {

    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    @Autowired
    private RelativeService relativeService;

//    @GetMapping(value = "/")
//    public String hello() {
//        return "Hello World!";
//    }

    @GetMapping(value = "/all-relatives")
    public String allRelatives() {
        return relativeService.findAll().toString();
    }

    @GetMapping(value = "/save-relative")
    public String saveRelative(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String dateOfBirth,
                               @RequestParam String relativeType) throws ParseException {
        Date parsedDate = parseDate(dateOfBirth);

        Relative relative = new Relative(firstName, lastName, parsedDate, relativeType);
        relativeService.save(relative);
        return "Relative saved";
    }

    @GetMapping(value="/delete-relative")
    public String deleteRelative(@RequestParam int id) {
        relativeService.delete(id);
        return "Relative deleted";
    }

    private Date parseDate(String date) throws ParseException {
        Date parsedDate = parser.parse(date);
        return parsedDate;
    }

}
