package com.galaxyware.colaborae.model;

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
