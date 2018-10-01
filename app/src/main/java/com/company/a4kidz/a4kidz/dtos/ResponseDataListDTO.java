package com.company.a4kidz.a4kidz.dtos;

import java.util.List;

/**
 * Created by Fred Rueda on 1/10/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class ResponseDataListDTO {

    private List<Memories> memories;

    public List<Memories> getMemories() {
        return memories;
    }

    @Override
    public String toString() {
        return "ResponseDataListDTO{" +
                "memories=" + memories +
                '}';
    }

    public void setMemories(List<Memories> memories) {
        this.memories = memories;
    }

}
