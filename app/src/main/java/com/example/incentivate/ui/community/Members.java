package com.example.incentivate.ui.community;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private String name;
    private int score;

    public Members(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void getFakeMembers(){
        List<Members> membersList = new ArrayList<>();

        membersList.add(new Members("Harvir", 300));
        membersList.add(new Members("Bryan", 200));
        membersList.add(new Members("Andrew", 100));
        membersList.add(new Members("Harvir", 300));
        membersList.add(new Members("Bryan", 200));
        membersList.add(new Members("Andrew", 100));
        membersList.add(new Members("Harvir", 300));
        membersList.add(new Members("Bryan", 200));
        membersList.add(new Members("Andrew", 100));
        membersList.add(new Members("Harvir", 300));
        membersList.add(new Members("Bryan", 200));
        membersList.add(new Members("Andrew", 100));
        membersList.add(new Members("Harvir", 300));
        membersList.add(new Members("Bryan", 200));
        membersList.add(new Members("Andrew", 100));
    }
}
