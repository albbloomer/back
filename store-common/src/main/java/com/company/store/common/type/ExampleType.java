package com.company.store.common.type;

import com.company.store.common.exception.ExampleException;

public enum ExampleType {

    EXAMPLE("example");

    private final String type;

    ExampleType(String type) {
        this.type = type;
    }

    public static ExampleType getValue(final String type) {
        return switch (type) {
            case "EXAMPLE" -> EXAMPLE;
            default -> throw new ExampleException("No supported point types.");
        };
    }

    /**
     *     public static ExampleType getValue(final String type) {
     *         return Arrays.stream(values())
     *                 .filter(enumConstant -> enumConstant.type.equalsIgnoreCase(type))
     *                 .findFirst()
     *                 .orElseThrow(() -> new ExampleException("No supported point types."));
     *     }
     */
}
