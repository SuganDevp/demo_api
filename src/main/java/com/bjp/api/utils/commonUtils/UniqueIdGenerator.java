package com.bjp.api.utils.commonUtils;

import java.util.function.Supplier;

import static java.util.UUID.randomUUID;

public class UniqueIdGenerator {

    public static final Supplier<String> getPrimaryId = () -> randomUUID().toString().replace("-", "");
}
