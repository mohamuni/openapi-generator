package org.openapitools.api.factories;

import org.openapitools.api.StoreApiService;
import org.openapitools.api.impl.StoreApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", comments = "Generator version: 7.8.0-SNAPSHOT")
public class StoreApiServiceFactory {
    private static final StoreApiService service = new StoreApiServiceImpl();

    public static StoreApiService getStoreApi() {
        return service;
    }
}
