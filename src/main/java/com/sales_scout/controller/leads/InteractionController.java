package com.sales_scout.controller.leads;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales_scout.dto.request.create.InteractionRequestDto;
import com.sales_scout.dto.response.InteractionResponseDto;
import com.sales_scout.entity.leads.Interaction;
import com.sales_scout.service.leads.InteractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/interaction")
public class InteractionController {
    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping("")
    ResponseEntity<List<InteractionResponseDto>> getAllInteractions(){
        List<InteractionResponseDto> interactions = this.interactionService.getAllInteractions();
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<InteractionResponseDto> getInteractionById(@PathVariable Long id){
        InteractionResponseDto interactions = this.interactionService.getInteractionById(id);
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }



    @GetMapping("/interlocutor/{interlocutorId}")
    ResponseEntity<List<InteractionResponseDto>> getAllInteractionsByInterlocutorId(@PathVariable Long interlocutorId){
        List<InteractionResponseDto> interactions = this.interactionService.getInteractionByInterlocutorId(interlocutorId);
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }


    @PostMapping("/create")
    ResponseEntity<InteractionResponseDto> createInteraction(@RequestBody InteractionRequestDto interactionRequestDto){
        InteractionResponseDto interaction = this.interactionService.saveOrUpdateInteraction(interactionRequestDto);
        return new ResponseEntity<>(interaction, HttpStatus.OK);
    }

    @GetMapping("/export")
    public ResponseEntity<String> exportProspectsToExcel(@RequestParam(required = false) String interactionsJson){
        try{
            List<Interaction> interactions = null;
            if (interactionsJson != null && !interactionsJson.isEmpty()){
                ObjectMapper objectMapper = new ObjectMapper();
                interactions = objectMapper.readValue(interactionsJson, new TypeReference<List<Interaction>>() {
                });
            }
            interactionService.exportFileExcel(interactions , "Interaction_File.xlsx");
            return ResponseEntity.ok("Excel File exported successfuly: Interactions_file.xlsx");
        }catch (IOException e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to export Excel file " + e.getMessage());
        }
    }
}
