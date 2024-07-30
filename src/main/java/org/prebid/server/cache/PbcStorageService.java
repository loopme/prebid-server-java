package org.prebid.server.cache;

import io.vertx.core.Future;
import org.prebid.server.cache.proto.request.module.StorageDataType;
import org.prebid.server.cache.proto.response.module.ModuleCacheResponse;

public interface PbcStorageService {

    Future<Void> storeEntry(String key,
                            String value,
                            StorageDataType type,
                            Integer ttlseconds,
                            String application,
                            String moduleCode);

    Future<ModuleCacheResponse> retrieveModuleEntry(String key, String moduleCode, String application);

    static NoOpPbcStorageService noOp() {
        return new NoOpPbcStorageService();
    }

    class NoOpPbcStorageService implements PbcStorageService {

        @Override
        public Future<Void> storeEntry(String key,
                                       String value,
                                       StorageDataType type,
                                       Integer ttlseconds,
                                       String application,
                                       String moduleCode) {

            return Future.succeededFuture();
        }

        @Override
        public Future<ModuleCacheResponse> retrieveModuleEntry(String key, String moduleCode, String application) {
            return Future.succeededFuture(ModuleCacheResponse.empty());
        }
    }
}
