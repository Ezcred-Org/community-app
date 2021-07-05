package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.noncore.Document;
import com.mifos.api.GenericResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * This DataManager Class for Handling the every request regarding the Document.
 * Created by Rajan Maurya on 02/09/16.
 */
@Singleton
public class DataManagerDocument {

    public final BaseApiManager mBaseApiManager;

    @Inject
    public DataManagerDocument(BaseApiManager baseApiManager) {
        mBaseApiManager = baseApiManager;
    }

    /**
     * This Method for Fetching the Document List with EntityType and EntityId from the REST API.
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents
     *
     * @param entityType Entity Type
     * @param entityId   Entity Id
     * @return List<Document>
     */
    public Observable<List<Document>> getDocumentsList(String entityType, int entityId) {
        return mBaseApiManager.getDocumentApi().getDocuments(entityType, entityId);
    }

    /**
     * This Method for Fetching the Document with EntityType, EntityId and DocumentId from the REST API.
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents/{documentId}
     *
     * @param entityType Entity Type
     * @param entityId   Entity Id
     * @param documentId   Document Id
     * @return Document
     */
    public Observable<Document> getDocument(String entityType, int entityId, int documentId) {
        return mBaseApiManager.getDocumentApi().getDocument(entityType, entityId, documentId);
    }

    /**
     * This Method for Creating the Document with EntityType and EntityId to server.
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents
     *
     * @param entityType   Entity Type
     * @param entityId     Entity Id
     * @param name         Name of Document
     * @param desc         Description of Document
     * @param subDirectory SubDirectory of Document
     * @param file         Document File
     * @param metadata     Document Metadata
     * @return SaveResponse
     */
    public Observable<GenericResponse> createDocument(
        String entityType,
        int entityId,
        String name,
        String desc,
        String subDirectory,
        String metadata,
        MultipartBody.Part file
    ) {
        return mBaseApiManager.getDocumentApi()
            .createDocument(entityType, entityId, name, desc, subDirectory, metadata, file
            );
    }

    /**
     * This Method for Creating the Document with EntityType and EntityId to server.
     * This document doesn't actually upload the file but takes in a location. It's useful when
     * a document has already been uploaded directly and Mifos is just being notified of the
     * location.
     *
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents/custom
     *
     * @param entityType Entity Type
     * @param entityId   Entity Id
     * @param name       Name of Document
     * @param desc       Description of Document
     * @param fileName   FileName of actual document.
     * @param location   Actual locaiton of the document file
     * @return GenericResponse
     */
    public Observable<GenericResponse> createDocumentLocation(String entityType, int entityId, String name,
                                                              String desc, String fileName, String location) {
        return mBaseApiManager
          .getDocumentApi()
          .createDocumentLocation(entityType, entityId, name, desc, fileName, location);
    }

    /**
     * This Method to Retrieve Binary File associated with Document.
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents/
     * {documentId}/attachment
     *
     * @param entityType Entity Type
     * @param entityId   Entity Id
     * @param documentId Document Id
     * @return ResponseBody Binary File of Document
     */
    public Observable<ResponseBody> downloadDocument(String entityType, int entityId,
                                                     int documentId) {
        return mBaseApiManager.getDocumentApi().downloadDocument(entityType, entityId, documentId);
    }

    /**
     * This Method to Remove the Document from the server with EntityType and EntityId and
     * Document Id.
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents/
     * {documentId}
     *
     * @param entityType Entity Type
     * @param entityId   Entity Id
     * @param documentId Document Id
     * @return GenericResponse
     */
    public Observable<GenericResponse> removeDocument(String entityType, int entityId,
                                                                    int documentId) {
        return mBaseApiManager.getDocumentApi().removeDocument(entityType, entityId, documentId);
    }

    /**
     * This Method for Updating the document with EntityType and EntityId and Document Id
     * to the new one.
     * REST END POINT:
     * https://demo.openmf.org/fineract-provider/api/v1/{entityType}/{entityId}/documents/
     * {documentId}
     *
     * @param entityType Entity Type
     * @param entityId   Entity Id
     * @param documentId Document Id
     * @param name       Name of Document
     * @param desc       Description of Document
     * @param verificationStatus
     *@param file       Document File  @return GenericResponse
     */
    public Observable<GenericResponse> updateDocument(String entityType, int entityId, int
            documentId, String name, String desc, String comments, Document.DocumentVerificationStatusEnum verificationStatus, MultipartBody.Part file) {
        return mBaseApiManager.getDocumentApi()
                .updateDocument(entityType, entityId, documentId, name, desc, comments, verificationStatus, file);
    }
}
