package com.sales_scout.controller.crm.wms;

import com.sales_scout.dto.request.create.wms.UnloadingTypeCreateDto;
import com.sales_scout.dto.response.crm.wms.UnloadingTypeResponseDto;
import com.sales_scout.exception.ResourceNotFoundException;
import com.sales_scout.service.crm.wms.UnloadingTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unloading-types")
public class UnloadingTypeController {

    private final UnloadingTypeService unloadingTypeService;

    public UnloadingTypeController(UnloadingTypeService unloadingTypeService) {
        this.unloadingTypeService = unloadingTypeService;
    }


    /**
     * Get all unloading types by company ID
     * @param companyId the ID of the company
     * @return list of unloading types
     */
    @GetMapping("")
    public ResponseEntity<List<UnloadingTypeResponseDto>> getAllUnloadingTypeByCompanyId(@RequestParam Long companyId){
        return ResponseEntity.ok( this.unloadingTypeService.getUnloadingTypesByCompanyId(companyId) );
    }

    /**
     * this function allows to create a new unloading type
     * @param unloadingTypeCreateDto data to create new unloading type
     * @return { ResponseEntity<UnloadingTypeResponseDto>} the dto of created unloading type
     * @throws Exception runtime exception
     */
    @PostMapping("")
    public ResponseEntity<UnloadingTypeResponseDto> createUnloadingType(@RequestBody UnloadingTypeCreateDto unloadingTypeCreateDto)
    throws Exception{
      try{
          return ResponseEntity.ok(this.unloadingTypeService.createUnloadingType(unloadingTypeCreateDto));
      }catch (Exception e){
          throw new  ResourceNotFoundException(e.getCause().getMessage(),"unloadingType","unloadingType");
      }
    }
}
