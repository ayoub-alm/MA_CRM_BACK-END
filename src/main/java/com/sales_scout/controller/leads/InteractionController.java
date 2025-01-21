package com.sales_scout.controller.leads;


import com.sales_scout.dto.request.create.InteractionRequestDto;
import com.sales_scout.dto.response.InteractionResponseDto;
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

    /**
     * get all interactions
     * @return
     */
    @GetMapping("")
    ResponseEntity<List<InteractionResponseDto>> getAllInteractions(){
        List<InteractionResponseDto> interactions = this.interactionService.getAllInteractions();
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }

    /**
     * get Interactions By Id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<InteractionResponseDto> getInteractionById(@PathVariable Long id){
        InteractionResponseDto interactions = this.interactionService.getInteractionById(id);
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }

    /**
     * get all Interaction By interlocutor Id
     * @param interlocutorId
     * @return
     */
    @GetMapping("/interlocutor/{interlocutorId}")
    ResponseEntity<List<InteractionResponseDto>> getAllInteractionsByInterlocutorId(@PathVariable Long interlocutorId){
        List<InteractionResponseDto> interactions = this.interactionService.getInteractionByInterlocutorId(interlocutorId);
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }

    /**
     * create interaction
     * @param interactionRequestDto
     * @return interactionRequestDto
     * @throws IOException
     */
    @PostMapping("/create")
    ResponseEntity<InteractionResponseDto> createInteraction(@RequestBody InteractionRequestDto interactionRequestDto) throws IOException {
        InteractionResponseDto interaction = this.interactionService.saveOrUpdateInteraction(interactionRequestDto);
        return new ResponseEntity<>(interaction, HttpStatus.OK);
    }
}
