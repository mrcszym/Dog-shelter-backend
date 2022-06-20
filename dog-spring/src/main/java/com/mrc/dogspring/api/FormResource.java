package com.mrc.dogspring.api;

import com.mrc.dogspring.domain.ApplicationForm;
import com.mrc.dogspring.service.AppFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.*;
import java.util.*;

//@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/f")
public class FormResource {
    private final AppFormService appFormService;

    @GetMapping("/forms")
    public ResponseEntity<List<ApplicationForm>> getForms() {
        return ResponseEntity.ok().body(appFormService.getForms());
    }

    @PostMapping(path = "/save", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<ApplicationForm> saveForm( @Valid ApplicationForm applicationForm) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/f/save").toUriString());
        return ResponseEntity.created(uri).body(appFormService.saveForm(applicationForm));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        appFormService.deleteForm(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public static void acceptForm(@PathVariable Long id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/schelter", "root", "SpaceMysql1!");

        String query = "UPDATE application_form SET decision = ? WHERE id = ?";

        PreparedStatement myStmt
                = con.prepareStatement(query);

        myStmt.setString(1, "zaakceptowano");
        myStmt.setLong(2, id);

        int res = myStmt.executeUpdate();
        con.close();
    }

    @PutMapping(path = "/updatedecline/{id}")
    public static void updatedecline(@PathVariable Long id) throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/schelter", "root", "SpaceMysql1!");

        String query = "UPDATE application_form SET decision = ? WHERE id = ?";

        PreparedStatement myStmt
                = con.prepareStatement(query);

        myStmt.setString(1, "odrzucono");
        myStmt.setLong(2, id);

        int res = myStmt.executeUpdate();
        con.close();
    }
}

