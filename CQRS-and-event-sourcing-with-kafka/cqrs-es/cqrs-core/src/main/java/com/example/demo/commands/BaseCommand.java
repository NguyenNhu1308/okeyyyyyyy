package com.example.demo.commands;

import com.example.demo.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BaseCommand extends Message {
    public BaseCommand(String id){
        super(id);
    }
}
