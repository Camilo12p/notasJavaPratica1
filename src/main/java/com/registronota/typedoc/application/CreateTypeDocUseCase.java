package com.registronota.typedoc.application;

import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class CreateTypeDocUseCase {

    private TypeDocumentService tDocumentService;

    public CreateTypeDocUseCase(TypeDocumentService tDocumentService) {
        this.tDocumentService = tDocumentService;
    }

    public void execute(TypeDocument typeDocument){
        tDocumentService.createTypeDocument(typeDocument);
    }

    
}
