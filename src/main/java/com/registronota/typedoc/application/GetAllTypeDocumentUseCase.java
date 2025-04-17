package com.registronota.typedoc.application;

import java.util.List;

import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class GetAllTypeDocumentUseCase {

    private TypeDocumentService tDocumentService;

    public GetAllTypeDocumentUseCase(TypeDocumentService tDocumentService) {
        this.tDocumentService = tDocumentService;
    }

    public List<TypeDocument> execute (){
        return tDocumentService.getAllTypeDocument();
    }

}
