package com.mum.dto;

public class BuildDirector {
    private IBuilder builder;

    public BuildDirector(IBuilder builder) {
        this.builder = builder;
    }

    public void build() {
        this.builder.buildParts();
    }
}
