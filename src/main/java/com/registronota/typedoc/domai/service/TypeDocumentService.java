package com.registronota.typedoc.domai.service;

import java.util.List;
import java.util.Optional;

import com.registronota.typedoc.domain.entity.TypeDocument;

public interface TypeDocumentService {

    public void createTypeDocument(TypeDocument typeDocument);
    public List<TypeDocument> getAllTypeDocument();
    public Optional<TypeDocument> getTypeDocumentById(int id);
}
