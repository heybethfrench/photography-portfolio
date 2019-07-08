package com.bethfrench.photographyportfolio.storage;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;

public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
