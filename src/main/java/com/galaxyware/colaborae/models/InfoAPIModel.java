package com.galaxyware.colaborae.models;

import lombok.*;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class InfoAPIModel {
    private String name;
    private String version;

    public InfoAPIModel(String colaborae, String s) {
    }
}
