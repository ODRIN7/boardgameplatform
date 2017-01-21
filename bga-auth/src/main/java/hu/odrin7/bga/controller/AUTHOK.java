package hu.odrin7.bga.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DANIEL on 2016.10.22..

 */

@Controller
@RequestMapping("/ok")
public class AUTHOK {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getOK() {
        return new ResponseEntity<String>(
            "szia",HttpStatus.OK);
    }
}
