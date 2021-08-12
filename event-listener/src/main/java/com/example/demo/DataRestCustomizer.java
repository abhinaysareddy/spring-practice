package com.example.demo;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RootResourceInformation;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.RequestMapping;

@BasePathAwareController
@RequestMapping("api")
public class DataRestCustomizer {
    PagedResourcesAssembler<Object> assembler=null;

   public DataRestCustomizer(PagedResourcesAssembler<Object> assembler){
       this.assembler=assembler;
   }
    @RequestMapping("/{repository}/resting")
    public String dataRest(RootResourceInformation resourceInformation){

        return "asa";
    }
}
